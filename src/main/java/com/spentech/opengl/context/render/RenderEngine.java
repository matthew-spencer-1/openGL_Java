package com.spentech.opengl.context.render;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glViewport;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.spentech.opengl.context.camera.Camera;
import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.context.lights.DirectionalLight;
import com.spentech.opengl.context.lights.PointLight;
import com.spentech.opengl.context.lights.ShaderProgram;
import com.spentech.opengl.context.lights.SpotLight;
import com.spentech.opengl.context.window.Window;
import com.spentech.opengl.graph.Transformation;
import com.spentech.opengl.graph.mesh.impl.MaterialMeshImpl;

public class RenderEngine {

	/**
	 * Field of View in Radians
	 */
	private static final float FOV = (float) Math.toRadians(60.0f);
	private static final float Z_NEAR = 0.01f;
	private static final float Z_FAR = 1000.f;
	private static final int MAX_POINT_LIGHTS = 5;
    private static final int MAX_SPOT_LIGHTS = 5;
	
	private static final float specularPower = 10f;

	private final Transformation transformation;

	private ShaderProgram shaderProgram;

	private static final String COLOR_VS = "/vertexShaders/color.vs";
	private static final String COLOR_FS = "/fragmentShaders/color.fs";
	private static final String TEXTURE_VS = "/vertexShaders/texture.vs";
	private static final String TEXTURE_FS = "/fragmentShaders/texture.fs";
	private static final String LIGHTING_VS = "/vertexShaders/lighting.vs";
	private static final String LIGHTING_FS = "/fragmentShaders/lighting.fs";
	private final String vertexShader;
	private final String fragmentShader;

	private final boolean useTextures;
	private final boolean useLighting;

	public RenderEngine(boolean useTextures, boolean useLighting) {
		transformation = new Transformation();
		this.useTextures = useTextures;
		this.useLighting = useLighting;

		if (this.useTextures ) {
			if( this.useLighting ) {
				vertexShader = LIGHTING_VS;
				fragmentShader = LIGHTING_FS;
			} else {
				vertexShader = TEXTURE_VS;
				fragmentShader = TEXTURE_FS;
			}
		} else {
			vertexShader = COLOR_VS;
			fragmentShader = COLOR_FS;
		}
	}

	public void init(Window window) throws Exception {
		// Create shader
		shaderProgram = new ShaderProgram();
		shaderProgram.createVertexShader(vertexShader);
		shaderProgram.createFragmentShader(fragmentShader);
		shaderProgram.link();

		// Create uniforms for world and projection matrices
		shaderProgram.createUniform("projectionMatrix");
		shaderProgram.createUniform("modelViewMatrix");
		if(this.useTextures) {
			shaderProgram.createUniform("texture_sampler");
			if(this.useLighting) {
				// Create uniform for material
		        shaderProgram.createMaterialUniform("material");
		        // Create lighting related uniforms
		        shaderProgram.createUniform("specularPower");
		        shaderProgram.createUniform("ambientLight");
		        shaderProgram.createPointLightListUniform("pointLights", MAX_POINT_LIGHTS);
		        shaderProgram.createSpotLightListUniform("spotLights", MAX_SPOT_LIGHTS);
		        shaderProgram.createDirectionalLightUniform("directionalLight");
			}
		}
	}

	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	/** Render method for non-lighted
	 * 
	 * @param window
	 * @param camera
	 * @param openGlItems
	 */
	public void render(Window window, Camera camera, OpenGLItem[] openGlItems) {
		Matrix4f viewMatrix = this.prepareViewMatrix(window, camera);

		if (this.useTextures) {
			shaderProgram.setUniform("texture_sampler", 0);
		} 

		this.renderItems(viewMatrix, openGlItems);

		shaderProgram.unbind();
	}
	
	public void render(Window window, Camera camera, OpenGLItem[] openGlItems, Vector3f ambientLight,
           PointLight[] pointLightList, SpotLight[] spotLightList, DirectionalLight directionalLight) {
		
		Matrix4f viewMatrix = this.prepareViewMatrix(window, camera);
		
		this.renderLights(viewMatrix, ambientLight, pointLightList, spotLightList, directionalLight);
		
		shaderProgram.setUniform("texture_sampler", 0);
		
		this.renderItems(viewMatrix, openGlItems);
		shaderProgram.unbind();
	}
	
	
	private void renderLights(Matrix4f viewMatrix, Vector3f ambientLight,
            PointLight[] pointLightList, SpotLight[] spotLightList, DirectionalLight directionalLight) {

        shaderProgram.setUniform("ambientLight", ambientLight);
        shaderProgram.setUniform("specularPower", specularPower);

        // Process Point Lights
        int numLights = pointLightList != null ? pointLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the point light object and transform its position to view coordinates
            PointLight currPointLight = new PointLight(pointLightList[i]);
            Vector3f lightPos = currPointLight.getPosition();
            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;
            shaderProgram.setUniform("pointLights", currPointLight, i);
        }

        // Process Spot Ligths
        numLights = spotLightList != null ? spotLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the spot light object and transform its position and cone direction to view coordinates
            SpotLight currSpotLight = new SpotLight(spotLightList[i]);
            Vector4f dir = new Vector4f(currSpotLight.getConeDirection(), 0);
            dir.mul(viewMatrix);
            currSpotLight.setConeDirection(new Vector3f(dir.x, dir.y, dir.z));
            Vector3f lightPos = currSpotLight.getPointLight().getPosition();

            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;

            shaderProgram.setUniform("spotLights", currSpotLight, i);
        }

        // Get a copy of the directional light object and transform its position to view coordinates
        DirectionalLight currDirLight = new DirectionalLight(directionalLight);
        Vector4f dir = new Vector4f(currDirLight.getDirection(), 0);
        dir.mul(viewMatrix);
        currDirLight.setDirection(new Vector3f(dir.x, dir.y, dir.z));
        shaderProgram.setUniform("directionalLight", currDirLight);

    }
	
	private Matrix4f prepareViewMatrix(Window window, Camera camera) {
		clear();

		if (window.isResized()) {
			glViewport(0, 0, window.getWidth(), window.getHeight());
			window.setResized(false);
		}

		shaderProgram.bind();

		// Update projection Matrix
		Matrix4f projectionMatrix = transformation.getProjectionMatrix(FOV, window.getWidth(), window.getHeight(),
				Z_NEAR, Z_FAR);
		shaderProgram.setUniform("projectionMatrix", projectionMatrix);

		// Update view Matrix
		return transformation.getViewMatrix(camera);
	}
	
	private void renderItems(Matrix4f viewMatrix, OpenGLItem[] openGlItems ) {
		// Render each gameItem
		for (OpenGLItem oglItem : openGlItems) {
			// Set model view matrix for this item
			Matrix4f modelMatrix = transformation.getModelViewMatrix(oglItem, viewMatrix);
			shaderProgram.setUniform("modelViewMatrix", modelMatrix);
			
			if(useLighting) {
				MaterialMeshImpl mesh = (MaterialMeshImpl) oglItem.getMesh();
				shaderProgram.setUniform("material", mesh.getMaterial());
			}
			
			// Render the mes for this game item
			oglItem.getMesh().render();
		}
	}

	public void cleanup() {
		if (shaderProgram != null) {
			shaderProgram.cleanup();
		}
	}
}

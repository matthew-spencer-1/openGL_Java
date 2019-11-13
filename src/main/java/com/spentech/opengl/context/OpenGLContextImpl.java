package com.spentech.opengl.context;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_K;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_M;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_N;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_O;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PERIOD;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_R;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_T;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_U;

import org.joml.Vector3f;

import com.spentech.opengl.context.camera.Camera;
import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.context.item.impl.ColorCube;
import com.spentech.opengl.context.item.impl.ColorSquare;
import com.spentech.opengl.context.item.impl.ColorTable;
import com.spentech.opengl.context.item.impl.ColorTriangle;
import com.spentech.opengl.context.item.impl.TextureBrickCube;
import com.spentech.opengl.context.item.impl.TextureCube;
import com.spentech.opengl.context.item.impl.TexturePyramid;
import com.spentech.opengl.context.item.impl.TextureTable;
import com.spentech.opengl.context.lights.DirectionalLight;
import com.spentech.opengl.context.lights.PointLight;
import com.spentech.opengl.context.lights.SpotLight;
import com.spentech.opengl.context.render.RenderEngine;
import com.spentech.opengl.context.window.MouseInput;
import com.spentech.opengl.context.window.Window;

public class OpenGLContextImpl implements OpenGLContext {

	private final Vector3f cameraIncrement;
	private Vector3f ambientLight;
	
	private float spotAngle = 0;
    private float spotInc = 1;
    private float lightAngle;
	
    private PointLight[] pointLightList;
    private SpotLight[] spotLightList;
    private DirectionalLight directionalLight;

	private final boolean useTextures;
	private final boolean useLighting;
	private final RenderEngine renderer;
	private final Camera camera;

	private static final float CAMERA_POS_STEP = 0.05f;
	private static final float MOUSE_SENSITIVITY = 0.2f;

	private boolean isAnimated = false;

	private OpenGLItem[] openGlItems;

	public OpenGLContextImpl(boolean useTextures, boolean useLighting) {
		this.useTextures = useTextures;
		if(!this.useTextures) {
			this.useLighting = false;
		} else {
			this.useLighting = useLighting;
		}
		
		camera = new Camera();
		this.setCameraDefaults();
		
		renderer = new RenderEngine(this.useTextures, this.useLighting);
		cameraIncrement = new Vector3f(0, 0, 0);
	}

	@Override
	public void init(Window window) throws Exception {
		renderer.init(window);

		if (!useTextures) {
			OpenGLItem colorTriangle = new ColorTriangle();
			colorTriangle.setPosition(-1, 0, -2);
			colorTriangle.setScale(0.5f);

			OpenGLItem colorSquare = new ColorSquare();
			colorSquare.setPosition(1, 0, -2);
			colorSquare.setScale(0.5f);

			OpenGLItem colorCube = new ColorCube();
			colorCube.setPosition(-1, 0.0f, -3);
			colorCube.setScale(0.5f);
			colorCube.setRotation(0, 45, 0);

			OpenGLItem colorTable = new ColorTable();
			colorTable.setPosition(0, 0.0f, 0);
			colorTable.setScale(0.8f);
			colorTable.setRotation(0, 45, 0);

			openGlItems = new OpenGLItem[] { colorCube, colorTable };
		} else {
			if(this.useLighting) {
				OpenGLItem textureTable = new TextureTable();
				textureTable.setPosition(0, 0.0f, 0);
				textureTable.setScale(1.0f);
				textureTable.setRotation(0, -40, 0);
				
				OpenGLItem texturePyramid = new TexturePyramid();
				texturePyramid.setPosition(0, 0, 0);
				texturePyramid.setRotation(0, 43, 0);
				
				openGlItems = new OpenGLItem[] { textureTable };
				
				this.setLightingDefaults();
			} else {
			
				OpenGLItem textureCube = new TextureCube();
				textureCube.setPosition(00f, 0f, 0f);
				textureCube.setScale(0.5f);
				textureCube.setRotation(0, 45, 0);
				
				OpenGLItem textureBrick = new TextureBrickCube();
				textureBrick.setPosition(-1, 0.5f, 0);
				textureBrick.setScale(0.5f);
				textureBrick.setRotation(0, 30, 0);
				
				OpenGLItem texturePyramid = new TexturePyramid();
				texturePyramid.setPosition(0, 0, 0);
				texturePyramid.setRotation(0, 43, 0);
				texturePyramid.setScale(1.5f);
				
				openGlItems = new OpenGLItem[] { textureBrick, texturePyramid};
			}
		}
	}

	@Override
	public void input(Window window, MouseInput mouseInput) {
		cameraIncrement.set(0, 0, 0);
		if (window.isKeyPressed(GLFW_KEY_PERIOD)) {
			cameraIncrement.z = -1;
		} else if (window.isKeyPressed(GLFW_KEY_E)) {
			cameraIncrement.z = 1;
		}
		if (window.isKeyPressed(GLFW_KEY_O)) {
			cameraIncrement.x = -1;
		} else if (window.isKeyPressed(GLFW_KEY_U)) {
			cameraIncrement.x = 1;
		}
		if (window.isKeyPressed(GLFW_KEY_K)) {
			cameraIncrement.y = -1;
		} else if (window.isKeyPressed(GLFW_KEY_Q)) {
			cameraIncrement.y = 1;
		} else if (window.isKeyPressed(GLFW_KEY_T)) {
			if(!isAnimated) {
				camera.setPosition(0, 0.0f, 5f);
				camera.setRotation(0, 0, 0);
			}
			isAnimated = !isAnimated;
		} else if (window.isKeyPressed(GLFW_KEY_R)) {
			this.setCameraDefaults();
			update(0, mouseInput);
		}
		float lightPos = spotLightList[0].getPointLight().getPosition().z;
        if (window.isKeyPressed(GLFW_KEY_N)) {
            this.spotLightList[0].getPointLight().getPosition().z = lightPos + 0.1f;
        } else if (window.isKeyPressed(GLFW_KEY_M)) {
            this.spotLightList[0].getPointLight().getPosition().z = lightPos - 0.1f;
        }
	}

	@Override
	public void update(float interval, MouseInput mouseInput) {
		// Update camera position
		camera.movePosition(cameraIncrement.x * CAMERA_POS_STEP, cameraIncrement.y * CAMERA_POS_STEP,
				cameraIncrement.z * CAMERA_POS_STEP);

		// Update camera based on mouse
		if (mouseInput.isLeftButtonPressed()) {
			Vector3f rotVec = mouseInput.getDisplVec();
			camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY , rotVec.z * MOUSE_SENSITIVITY );
		}
	
		if (isAnimated) {
			
			Vector3f rotVec = new Vector3f(0,-2.787f,0);
			Vector3f cameraIncrement = new Vector3f(1,0,0);
			
			camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY , rotVec.z * MOUSE_SENSITIVITY );
			camera.movePosition(cameraIncrement.x * CAMERA_POS_STEP, cameraIncrement.y * CAMERA_POS_STEP,
					cameraIncrement.z * CAMERA_POS_STEP);
		}
		
		if (useLighting) {
			// Update spot light direction
	        spotAngle += spotInc * 0.05f;
	        if (spotAngle > 2) {
	            spotInc = -1;
	        } else if (spotAngle < -2) {
	            spotInc = 1;
	        }
	        double spotAngleRad = Math.toRadians(spotAngle);
	        Vector3f coneDir = spotLightList[0].getConeDirection();
	        coneDir.y = (float) Math.sin(spotAngleRad);

	        // Update directional light direction, intensity and colour
	        lightAngle += 1.1f;
	        if (lightAngle > 90) {
	            directionalLight.setIntensity(0);
	            if (lightAngle >= 360) {
	                lightAngle = -90;
	            }
	        } else if (lightAngle <= -80 || lightAngle >= 80) {
	            float factor = 1 - (float) (Math.abs(lightAngle) - 80) / 10.0f;
	            directionalLight.setIntensity(factor);
	            directionalLight.getColor().y = Math.max(factor, 0.9f);
	            directionalLight.getColor().z = Math.max(factor, 0.5f);
	        } else {
	            directionalLight.setIntensity(1);
	            directionalLight.getColor().x = 1;
	            directionalLight.getColor().y = 1;
	            directionalLight.getColor().z = 1;
	        }
	        double angRad = Math.toRadians(lightAngle);
	        directionalLight.getDirection().x = (float) Math.sin(angRad);
	        directionalLight.getDirection().y = (float) Math.cos(angRad);
		}
	}

	@Override
	public void render(Window window) {
		if( !useLighting ) {
			renderer.render(window, camera, openGlItems);
		} else {
			renderer.render(window, camera, openGlItems, ambientLight, pointLightList, spotLightList, directionalLight);
		}
	}

	@Override
	public void cleanup() {
		renderer.cleanup();
		for (OpenGLItem gameItem : openGlItems) {
			gameItem.getMesh().cleanUp();
		}
	}
	
	private void setCameraDefaults() {
		camera.setPosition(0, 0.0f, 5f);
		camera.setRotation(0, 0, 0);
		camera.setCameraUpY(0, 1, 0);
		camera.setForwardZ(0, 0, -4);
		camera.setCameraTarget(0, 0, 0);
	}
	
	private void setLightingDefaults() {
		ambientLight = new Vector3f(0.8f, 0.8f, 0.0f);

        // Point Light
        Vector3f lightPosition = new Vector3f(0, 0, 1);
        float lightIntensity = 1.0f;
        PointLight pointLight = new PointLight(new Vector3f(1, 1, 1), lightPosition, lightIntensity);
        PointLight.Attenuation att = new PointLight.Attenuation(0.0f, 0.0f, 1.0f);
        pointLight.setAttenuation(att);
        pointLightList = new PointLight[]{pointLight};

        // Spot Light
        lightPosition = new Vector3f(0, 0.0f, 10f);
        pointLight = new PointLight(new Vector3f(1, 1, 1), lightPosition, lightIntensity);
        att = new PointLight.Attenuation(0.0f, 0.0f, 0.02f);
        pointLight.setAttenuation(att);
        Vector3f coneDir = new Vector3f(0, 0, -1);
        float cutoff = (float) Math.cos(Math.toRadians(140));
        SpotLight spotLight = new SpotLight(pointLight, coneDir, cutoff);
        spotLightList = new SpotLight[]{spotLight, new SpotLight(spotLight)};

        lightPosition = new Vector3f(-1, 0, 0);
        directionalLight = new DirectionalLight(new Vector3f(1, 1, 1), lightPosition, lightIntensity);
	}
}
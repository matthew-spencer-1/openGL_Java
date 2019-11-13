package com.spentech.opengl.context.item.impl;

import java.util.ArrayList;
import java.util.List;

import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.context.material.Material;
import com.spentech.opengl.graph.PositionRotationScale;
import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.graph.mesh.impl.MaterialMeshImpl;
import com.spentech.opengl.utils.TextureLoader;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class TexturePyramid extends PositionRotationScale implements OpenGLItem {
	
	private final int textureId;
	private final int TRIANGLE_COUNT = 30;
	private final float REFLECTANCE = 1f;
	
	private final String textureFile = "/textures/brick.jpg";
	private final Material material;
	private final Mesh mesh;
	
	public TexturePyramid() {
		this.textureId = TextureLoader.loadTexture(textureFile);
		this.material = new Material(this.textureId, REFLECTANCE );
		this.mesh = new MaterialMeshImpl(generateVertexArray(), generateParsingMap(), TRIANGLE_COUNT, this.material);
	}

	@Override
	public Mesh getMesh() {
		return mesh;
	}
	
	private float[] generateVertexArray() {
		return new float[]{
			//Positions				//Normals			//Texture
			//Back Face			//Negative Z Normals
			-0.5f, -0.5f, -0.5f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			 0.5f, -0.5f, -0.5f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f, -1.0f, 0.5f, 0.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f, -1.0f, 0.5f, 0.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f, -1.0f, 0.5f, 0.0f,
			-0.5f, -0.5f, -0.5f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			//Front Face		//Positive Z Normals
			-0.5f, -0.5f,  0.5f,  0.0f,  0.0f,  1.0f, 0.0f, 1.0f,
			 0.5f, -0.5f,  0.5f,  0.0f,  0.0f,  1.0f, 1.0f, 1.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f,  1.0f, 0.5f, 0.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f,  1.0f, 0.5f, 0.0f,
			 0.0f,  0.5f,  0.0f,  0.0f,  0.0f,  1.0f, 0.5f, 0.0f,
			-0.5f, -0.5f,  0.5f,  0.0f,  0.0f,  1.0f, 0.0f, 1.0f,
			//Left Face			//Negative X Normals
			 0.0f,  0.5f,  0.0f, -1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			 0.0f,  0.5f,  0.0f, -1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			-0.5f, -0.5f, -0.5f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.5f, -0.5f, -0.5f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.5f, -0.5f,  0.5f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.0f,  0.5f,  0.0f, -1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.0f,  0.5f,  0.0f,  1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			 0.0f,  0.5f,  0.0f,  1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			 0.5f, -0.5f, -0.5f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.5f, -0.5f, -0.5f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.5f, -0.5f,  0.5f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.0f,  0.5f,  0.0f,  1.0f,  0.0f,  0.0f, 0.5f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.5f, -0.5f, -0.5f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.5f, -0.5f, -0.5f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.5f, -0.5f,  0.5f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.5f, -0.5f,  0.5f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.5f, -0.5f,  0.5f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.5f, -0.5f, -0.5f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f	
		};
	}
	
	private List<VertexArrayParsingMap> generateParsingMap(){
		
		// The sizes of the vertex and color components
        final int sizeVertex = 3;
        final int sizeNormals = 3;
        final int sizeTexture  = 2;
        
        // The 'stride' is the sum of the sizes of individual components
        final int stride = sizeVertex + sizeNormals + sizeTexture;
        
        // The 'offset is the number of bytes from the start of the tuple
        final long offsetVertex = 0;
        final long offsetNormals = 3;
        final long offsetTexture  = 6;
        
        VertexArrayParsingMap vertexMap = new VertexArrayParsingMap(sizeVertex, offsetVertex, stride);
        VertexArrayParsingMap normalsMap = new VertexArrayParsingMap(sizeNormals, offsetNormals, stride);
        VertexArrayParsingMap textureMap = new VertexArrayParsingMap(sizeTexture, offsetTexture, stride );
        
        List<VertexArrayParsingMap> list = new ArrayList<>();
        list.add(vertexMap);
        list.add(textureMap);
        list.add(normalsMap);
        
        return list;
	}

}

package com.spentech.opengl.context.item.impl;

import java.util.ArrayList;
import java.util.List;

import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.graph.PositionRotationScale;
import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.graph.mesh.impl.TextureMeshImpl;
import com.spentech.opengl.utils.TextureLoader;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class TextureCube extends PositionRotationScale implements OpenGLItem {

	private final int textureId;
	private final String textureFile = "/textures/cube_texture.png";
	private final int TRIANGLE_COUNT = 36;
	private final Mesh mesh;

	public TextureCube() {
		this.textureId = TextureLoader.loadTexture(textureFile);
		this.mesh = new TextureMeshImpl(generateVertexArray(), generateParsingMap(), TRIANGLE_COUNT, textureId);
	}

	@Override
	public Mesh getMesh() {
		return mesh;
	}
	
	private float[] generateVertexArray() {
		return new float[]{
            // x,    y,   ,z     Texture Coord
			//Top Face
            -0.8f, +0.8f, +0.8f,  0, 0.5f,
            +0.8f, +0.8f, +0.8f,  0.5f, 0.5f,
            +0.8f, +0.8f, -0.8f,  0.5f, 1,
            +0.8f, +0.8f, -0.8f,  0.5f, 1,
            -0.8f, +0.8f, -0.8f,  0, 1,
            -0.8f, +0.8f, +0.8f,  0, 0.5f,
            //Back Face
            -0.8f, +0.8f, -0.8f,  0, 0,
            -0.8f, -0.8f, -0.8f,  0, 0.5f,
            +0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            -0.8f, +0.8f, -0.8f,  0, 0,
            +0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            +0.8f, +0.8f, -0.8f,  0.5f, 0,
            //Left Face
            -0.8f, -0.8f, +0.8f,  0, 0.5f,
            -0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            -0.8f, +0.8f, +0.8f,  0, 0,
            -0.8f, +0.8f, +0.8f,  0, 0,
            -0.8f, +0.8f, -0.8f,  0.5f, 0,
            -0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            //Right Face   
            +0.8f, -0.8f, +0.8f,  0, 0.5f,
            +0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            +0.8f, +0.8f, +0.8f,  0, 0,
            +0.8f, +0.8f, +0.8f,  0, 0,
            +0.8f, +0.8f, -0.8f,  0.5f, 0,
            +0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            // Front Face
            -0.8f, +0.8f, +0.8f,  0, 0,
            -0.8f, -0.8f, +0.8f,  0, 0.5f,
            +0.8f, -0.8f, +0.8f,  0.5f, 0.5f,
            -0.8f, +0.8f, +0.8f,  0, 0,
            +0.8f, -0.8f, +0.8f,  0.5f, 0.5f,
            +0.8f, +0.8f, +0.8f,  0.5f, 0,
            //Bottom Face
            -0.8f, -0.8f, +0.8f,  0.5f, 0,
            +0.8f, -0.8f, +0.8f,  1, 0,
            +0.8f, -0.8f, -0.8f,  1, 0.5f,
            +0.8f, -0.8f, -0.8f,  1, 0.5f,
            -0.8f, -0.8f, -0.8f,  0.5f, 0.5f,
            -0.8f, -0.8f, +0.8f,  0.5f, 0
        };
	}
	
	private List<VertexArrayParsingMap> generateParsingMap(){
		
		// The sizes of the vertex and color components
        final int sizeVertex = 3;
        final int sizeTexture  = 2;
        
        // The 'stride' is the sum of the sizes of individual components
        final int stride = sizeVertex + sizeTexture;
        
        // The 'offset is the number of bytes from the start of the tuple
        final long offsetVertex = 0;
        final long offsetTexture  = 3;
        
        VertexArrayParsingMap vertexMap = new VertexArrayParsingMap(sizeVertex, offsetVertex, stride);
        VertexArrayParsingMap textureMap = new VertexArrayParsingMap(sizeTexture, offsetTexture, stride );
        
        List<VertexArrayParsingMap> list = new ArrayList<>();
        list.add(vertexMap);
        list.add(textureMap);
        
        return list;
	}
}

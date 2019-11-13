package com.spentech.opengl.context.item.impl;

import java.util.ArrayList;
import java.util.List;

import com.spentech.opengl.context.item.OpenGLItem;
import com.spentech.opengl.graph.PositionRotationScale;
import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.graph.mesh.impl.OpenMeshImpl;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class ColorCube extends PositionRotationScale implements OpenGLItem {

	private final int TRIANGLE_COUNT = 36;
	private final Mesh mesh;

	public ColorCube() {
		this.mesh = new OpenMeshImpl(generateVertexArray(), generateParsingMap(), TRIANGLE_COUNT);
	}

	@Override
	public Mesh getMesh() {
		return mesh;
	}
	
	private float[] generateVertexArray() {
		return new float[]{
            // x,    y,   ,z  r, g, b, a
			//Top Face
            -0.8f, +0.8f, +0.8f,  1, 1, 0, 1,
            +0.8f, +0.8f, +0.8f,  1, 1, 0, 1,
            +0.8f, +0.8f, -0.8f,  1, 1, 0, 1,
            +0.8f, +0.8f, -0.8f,  1, 1, 0, 1,
            -0.8f, +0.8f, -0.8f,  1, 1, 0, 1,
            -0.8f, +0.8f, +0.8f,  1, 1, 0, 1,
            //Back Face
            -0.8f, +0.8f, -0.8f,  1, 0, 0, 1,
            -0.8f, -0.8f, -0.8f,  1, 0, 0, 1,
            +0.8f, -0.8f, -0.8f,  1, 0, 0, 1,
            -0.8f, +0.8f, -0.8f,  1, 0, 0, 1,
            +0.8f, -0.8f, -0.8f,  1, 0, 0, 1,
            +0.8f, +0.8f, -0.8f,  1, 0, 0, 1,
            //Left Face
            -0.8f, -0.8f, +0.8f,  0, 1, 0, 1,
            -0.8f, -0.8f, -0.8f,  0, 1, 0, 1,
            -0.8f, +0.8f, +0.8f,  0, 1, 0, 1,
            -0.8f, +0.8f, +0.8f,  0, 1, 0, 1,
            -0.8f, +0.8f, -0.8f,  0, 1, 0, 1,
            -0.8f, -0.8f, -0.8f,  0, 1, 0, 1,
            //Right Face
            +0.8f, -0.8f, +0.8f,  0, 0, 1, 1,
            +0.8f, -0.8f, -0.8f,  0, 0, 1, 1,
            +0.8f, +0.8f, +0.8f,  0, 0, 1, 1,
            +0.8f, +0.8f, +0.8f,  0, 0, 1, 1,
            +0.8f, +0.8f, -0.8f,  0, 0, 1, 1,
            +0.8f, -0.8f, -0.8f,  0, 0, 1, 1,
            // Front Face
            -0.8f, +0.8f, +0.8f,  1, 0, 1, 1,
            -0.8f, -0.8f, +0.8f,  1, 0, 1, 1,
            +0.8f, -0.8f, +0.8f,  1, 0, 1, 1,
            -0.8f, +0.8f, +0.8f,  1, 0, 1, 1,
            +0.8f, -0.8f, +0.8f,  1, 0, 1, 1,
            +0.8f, +0.8f, +0.8f,  1, 0, 1, 1,
            //Bottom Face
            -0.8f, -0.8f, +0.8f,  0, 1, 1, 1,
            +0.8f, -0.8f, +0.8f,  0, 1, 1, 1,
            +0.8f, -0.8f, -0.8f,  0, 1, 1, 1,
            +0.8f, -0.8f, -0.8f,  0, 1, 1, 1,
            -0.8f, -0.8f, -0.8f,  0, 1, 1, 1,
            -0.8f, -0.8f, +0.8f,  0, 1, 1, 1,
        };
	}
	
	private List<VertexArrayParsingMap> generateParsingMap(){
		
		// The sizes of the vertex and color components
        final int sizeVertex = 3;
        final int sizeColor  = 4;
        
        // The 'stride' is the sum of the sizes of individual components
        final int stride = sizeVertex + sizeColor;
        
        // The 'offset is the number of bytes from the start of the tuple
        final long offsetVertex = 0;
        final long offsetColor  = 3;
        
        VertexArrayParsingMap vertexMap = new VertexArrayParsingMap(sizeVertex, offsetVertex, stride);
        VertexArrayParsingMap colorMap = new VertexArrayParsingMap(sizeColor, offsetColor, stride );
        
        List<VertexArrayParsingMap> list = new ArrayList<>();
        list.add(vertexMap);
        list.add(colorMap);
        
        return list;
	}
}

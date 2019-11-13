package com.spentech.opengl.graph.mesh.impl;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryUtil;

import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class ObjectMeshImpl implements Mesh{
	private final int vaoId;
	private final int vboId;
	
	// The size of float, in bytes (will be 4)
    private final int sizeOfFloat = Float.SIZE / Byte.SIZE;
	
	public ObjectMeshImpl(float[] meshData) {
		FloatBuffer meshBuffer = null;
		
		try {
			vaoId = glGenVertexArrays();
            glBindVertexArray(vaoId);
            
            vboId = glGenBuffers();
            meshBuffer = MemoryUtil.memAllocFloat(meshData.length);
            meshBuffer.put(meshData).flip();
            glBindBuffer(GL_ARRAY_BUFFER, vboId);
            glBufferData(GL_ARRAY_BUFFER, meshBuffer, GL_STATIC_DRAW);
            
            List<VertexArrayParsingMap> parsingInstructions = this.generateParsingMap();
            
			for (int i = 0; i < parsingInstructions.size(); i++) {
				VertexArrayParsingMap instruction = parsingInstructions.get(i);
				glVertexAttribPointer(i, instruction.getElementCount(), GL_FLOAT, false, instruction.getStride(),
						instruction.getOffset());
				
				glEnableVertexAttribArray(i);
			}
	        
            glBindVertexArray(0);
		} finally {
			if(meshBuffer != null) {
				MemoryUtil.memFree(meshBuffer);
			}
		}
	}
	
	public int getVaoId() {
		return vaoId;
	}
	
	public void render() {
		glBindVertexArray(getVaoId());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);

		glDrawArrays(GL_TRIANGLES, 0, 3);

		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glBindVertexArray(0);
	}

	public void cleanUp() {
		glDisableVertexAttribArray(0);

		// Delete the VBOs
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vboId);

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(vaoId);
	}

	private List<VertexArrayParsingMap> generateParsingMap(){
		// The sizes of the vertex and color components
        final int sizeVertex = 2;
        final int sizeColor  = 4;
        
        // The 'stride' is the sum of the sizes of individual components
        final int stride = sizeVertex * sizeOfFloat + sizeColor * sizeOfFloat;
        
        // The 'offset is the number of bytes from the start of the tuple
        final long offsetVertex = 0;
        final long offsetColor  = 2 * sizeOfFloat;
        
        VertexArrayParsingMap vertexMap = new VertexArrayParsingMap(sizeVertex, offsetVertex, stride);
        VertexArrayParsingMap colorMap = new VertexArrayParsingMap(sizeColor, offsetColor, stride );
        
        List<VertexArrayParsingMap> list = new ArrayList<>();
        list.add(vertexMap);
        list.add(colorMap);
        
        return list;
	}
}

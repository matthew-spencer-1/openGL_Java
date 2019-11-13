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
import java.util.List;

import org.lwjgl.system.MemoryUtil;

import com.spentech.opengl.graph.mesh.Mesh;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class OpenMeshImpl implements Mesh {
	
	private int vaoId;
	private int vboId;
	private int triangleCount;
	private int attribArrayCount;
	
	public OpenMeshImpl(float[] vertexArray, List<VertexArrayParsingMap> parsingInstructions, int triangleCount) {
		FloatBuffer arrayBuffer = null;
		
		this.attribArrayCount = parsingInstructions.size();
		this.triangleCount = triangleCount;
		
		try {
			vaoId = glGenVertexArrays();
            glBindVertexArray(vaoId);
            
            vboId = glGenBuffers();
            arrayBuffer = MemoryUtil.memAllocFloat(vertexArray.length);
            arrayBuffer.put(vertexArray).flip();
            glBindBuffer(GL_ARRAY_BUFFER, vboId);
            glBufferData(GL_ARRAY_BUFFER, arrayBuffer, GL_STATIC_DRAW);
            
            for (int i = 0; i < parsingInstructions.size(); i++) {
				VertexArrayParsingMap instruction = parsingInstructions.get(i);
				glVertexAttribPointer(i, instruction.getElementCount(), GL_FLOAT, false, instruction.getStride(),
						instruction.getOffset());
			}
	        
            glBindVertexArray(0);
			
		} finally {
			if(null != arrayBuffer) {
				MemoryUtil.memFree(arrayBuffer);
			}
		}
	}

	@Override
	public void cleanUp() {
    	glDisableVertexAttribArray(0);

		// Delete the VBOs
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vboId);

		// Delete the VAO
		glBindVertexArray(0);
		glDeleteVertexArrays(vaoId);
	}

	@Override
	public int getVaoId() {
		return vaoId;
	}

	@Override
	public void render() {		
		glBindVertexArray(getVaoId());
		for (int i = 0; i < attribArrayCount; i++) {
			glEnableVertexAttribArray(i);	
		}

		glDrawArrays(GL_TRIANGLES, 0, triangleCount);

		for (int i = 0; i < attribArrayCount; i++) {
			glDisableVertexAttribArray(i);
		}
		glBindVertexArray(0);
	}

}

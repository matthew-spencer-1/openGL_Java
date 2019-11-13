package com.spentech.opengl.graph.mesh.impl;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import java.util.List;

import com.spentech.opengl.utils.VertexArrayParsingMap;

public class TextureMeshImpl extends OpenMeshImpl {
	
	private final int textureId;

	public TextureMeshImpl(float[] vertexArray, List<VertexArrayParsingMap> parsingInstructions, int triangleCount,
			int textureId) {
		super(vertexArray, parsingInstructions, triangleCount);
		
		this.textureId = textureId;
	}

	@Override
	public void cleanUp() {
		super.cleanUp();
		
		glDeleteTextures(textureId);
	}

	@Override
	public void render() {
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, textureId);
		
		super.render();
		
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	

}

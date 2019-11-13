package com.spentech.opengl.graph.mesh.impl;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

import java.util.List;

import com.spentech.opengl.context.material.Material;
import com.spentech.opengl.utils.VertexArrayParsingMap;

public class MaterialMeshImpl extends OpenMeshImpl {
	private Material material;

	public MaterialMeshImpl(float[] vertexArray, List<VertexArrayParsingMap> parsingInstructions, int triangleCount,
			Material material) {
	
		super(vertexArray, parsingInstructions, triangleCount);
	
		this.material = material;
	}

	@Override
	public void cleanUp() {
		super.cleanUp();
		
		if( null != material.getTextureId()) {
			glDeleteTextures(material.getTextureId());
		}
	}

	@Override
	public void render() {
		
		if ( null != material.getTextureId()) {
			glActiveTexture(GL_TEXTURE0);
			glBindTexture(GL_TEXTURE_2D, material.getTextureId());
        }

		super.render();
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	

}

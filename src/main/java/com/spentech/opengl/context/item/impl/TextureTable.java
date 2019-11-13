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

public class TextureTable extends PositionRotationScale implements OpenGLItem {
	
	private final int textureId;
	private final int TRIANGLE_COUNT = 288;
	private final float REFLECTANCE = 1f;
	
	private final String textureFile = "/textures/woodgrain.png";
	private final Material material;
	private final Mesh mesh;
	
	public TextureTable() {
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
			/* Start Table Top */
			//Back Face			
			-1.0f,  1.0f, -0.45f,  0.0f,  0.0f,  1.0f, 0.0f, 0.0f,
			 1.0f,  1.0f, -0.45f,  0.0f,  0.0f,  1.0f, 1.0f, 0.0f,
			 1.0f,  1.1f, -0.45f,  0.0f,  0.0f,  1.0f, 1.0f, 1.0f,
			 1.0f,  1.1f, -0.45f,  0.0f,  0.0f,  1.0f, 1.0f, 1.0f,
			-1.0f,  1.1f, -0.45f,  0.0f,  0.0f,  1.0f, 0.0f, 1.0f,
			-1.0f,  1.0f, -0.45f,  0.0f,  0.0f,  1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-1.0f,  1.0f,  0.55f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 1.0f,  1.0f,  0.55f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.55f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 1.0f,  1.1f,  0.55f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-1.0f,  1.1f,  0.55f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-1.0f,  1.0f,  0.55f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-1.0f,  1.1f,  0.55f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-1.0f,  1.1f, -0.45f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-1.0f,  1.0f, -0.45f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-1.0f,  1.0f, -0.45f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-1.0f,  1.0f,  0.55f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-1.0f,  1.1f,  0.55f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 1.0f,  1.1f,  0.55f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 1.0f,  1.1f, -0.45f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 1.0f,  1.0f, -0.45f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 1.0f,  1.0f, -0.45f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 1.0f,  1.0f,  0.55f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.55f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-1.0f,  1.0f, -0.45f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 1.0f,  1.0f, -0.45f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 1.0f,  1.0f,  0.55f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 1.0f,  1.0f,  0.55f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-1.0f,  1.0f,  0.55f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-1.0f,  1.0f, -0.45f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-1.0f,  1.1f, -0.45f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 1.0f,  1.1f, -0.45f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 1.0f,  1.1f,  0.55f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 1.0f,  1.1f,  0.55f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-1.0f,  1.1f,  0.55f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-1.0f,  1.1f, -0.45f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Top */
			/* Front Support */
			//Back Face			//Negative Z Normals
			-0.3f,  0.9f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 0.3f,  0.9f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 0.3f,  1.0f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.3f,  1.0f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.3f,  1.0f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-0.3f,  0.9f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-0.3f,  0.9f,  0.48f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			 0.3f,  0.9f,  0.48f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			 0.3f,  1.0f,  0.48f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.3f,  1.0f,  0.48f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.3f,  1.0f,  0.48f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			-0.3f,  0.9f,  0.48f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-0.3f,  1.0f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.3f,  1.0f,  0.48f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.3f,  0.9f,  0.48f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.3f,  0.9f,  0.48f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.3f,  0.9f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.3f,  1.0f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.3f,  1.0f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.3f,  1.0f,  0.48f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.3f,  0.9f,  0.48f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.3f,  0.9f,  0.48f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.3f,  0.9f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.3f,  1.0f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.3f,  0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.3f,  0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.3f,  0.9f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.3f,  0.9f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.3f,  0.9f,  0.43f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.3f,  0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-0.3f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.3f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.3f,  1.0f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.3f,  1.0f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.3f,  1.0f,  0.43f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.3f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Front Support */
			/* Left Outside Leg */
			//Back Face
			-0.8f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			-0.9f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			-0.9f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.9f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.8f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-0.8f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			-0.9f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			-0.9f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.9f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.8f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-0.9f,  1.0f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.9f,  1.0f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.9f, -0.9f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.9f, -0.9f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.9f, -0.9f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.9f,  1.0f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			-0.8f,  1.0f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.8f,  1.0f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.8f, -0.9f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.8f, -0.9f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.8f,  1.0f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.8f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			-0.9f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			-0.9f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.9f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-0.8f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			-0.9f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			-0.9f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.9f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.8f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.8f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Left Outside Leg */
			/* Right Outside Leg */
			//Back Face
			 0.8f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 0.9f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 0.9f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.9f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.8f,  1.0f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			 0.8f, -0.9f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			 0.8f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			 0.9f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			 0.9f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.9f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.8f,  1.0f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			 0.8f, -0.9f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			 0.8f,  1.0f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.8f,  1.0f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.8f, -0.9f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.8f, -0.9f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.8f,  1.0f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.9f,  1.0f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.9f,  1.0f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.9f, -0.9f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.9f, -0.9f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.9f, -0.9f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.9f,  1.0f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			 0.8f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.9f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.9f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.9f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			 0.8f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.9f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.9f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.9f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.8f,  1.0f, -0.28f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			 0.8f,  1.0f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* Right Outside Leg */
			/* Left Inside Leg */
			//Back Face
			-0.8f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			-0.7f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			-0.7f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.7f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.8f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-0.8f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-0.8f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			-0.7f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			-0.7f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.7f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.8f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			-0.8f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-0.8f,  1.0f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.8f,  1.0f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.8f, -0.9f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.8f, -0.9f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.8f,  1.0f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			-0.7f,  1.0f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.7f,  1.0f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.7f, -0.9f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f, -0.9f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f, -0.9f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.7f,  1.0f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.8f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			-0.7f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			-0.7f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.8f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.8f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-0.8f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			-0.7f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			-0.7f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.8f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.8f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Left Inside Leg */
			/* Right Inside Leg */
			//Back Face
			 0.8f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 0.7f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 0.7f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.7f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.8f,  1.0f,  0.48f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.28f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			 0.8f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			 0.7f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			 0.7f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.7f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.8f,  1.0f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			 0.7f,  1.0f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.7f,  1.0f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.7f, -0.9f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.9f, -0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.9f, -0.28f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.7f,  1.0f,  0.48f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.8f,  1.0f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.8f,  1.0f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.8f, -0.9f, -0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.8f, -0.9f, -0.28f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.8f,  1.0f,  0.48f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			 0.8f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.8f, -0.9f, -0.28f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			 0.8f, -0.9f, -0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			 0.8f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.8f,  1.0f,  0.48f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			 0.8f,  1.0f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Right Inside Leg */
			/* Rear Bottom Support */
			//Back Face			//Negative Z Normals
			-0.7f, -0.75f, -0.30f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 0.7f, -0.75f, -0.30f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 0.7f, -0.70f, -0.30f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.7f, -0.70f, -0.30f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.7f, -0.70f, -0.30f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-0.7f, -0.75f, -0.30f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-0.7f, -0.75f, -0.25f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			 0.7f, -0.75f, -0.25f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			 0.7f, -0.70f, -0.25f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.7f, -0.70f, -0.25f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.7f, -0.70f, -0.25f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			-0.7f, -0.75f, -0.25f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-0.7f, -0.70f, -0.30f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.7f, -0.70f, -0.25f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.7f, -0.75f, -0.25f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f, -0.75f, -0.25f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f, -0.75f, -0.30f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.7f, -0.70f, -0.30f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.7f, -0.70f, -0.30f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.7f, -0.70f, -0.25f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.7f, -0.75f, -0.25f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.75f, -0.25f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.75f, -0.30f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.7f, -0.70f, -0.30f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.7f, -0.75f, -0.25f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.75f, -0.25f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f, -0.75f, -0.30f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f, -0.75f, -0.30f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f, -0.75f, -0.30f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.7f, -0.75f, -0.25f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-0.7f, -0.70f, -0.25f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f, -0.70f, -0.25f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f, -0.70f, -0.30f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f, -0.70f, -0.30f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f, -0.70f, -0.30f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.7f, -0.70f, -0.25f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Rear Bottom Support */
			/* Front Top Support */
			//Back Face			//Negative Z Normals
			-0.7f,  0.93f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			 0.7f,  0.93f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 0.0f,
			 0.7f,  0.98f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			 0.7f,  0.98f,  0.43f,  0.0f,  0.0f, -1.0f, 1.0f, 1.0f,
			-0.7f,  0.98f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 1.0f,
			-0.7f,  0.93f,  0.43f,  0.0f,  0.0f, -1.0f, 0.0f, 0.0f,
			//Front Face		//Positive Z Normals
			-0.7f,  0.93f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			 0.7f,  0.93f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 0.0f,
			 0.7f,  0.98f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			 0.7f,  0.98f,  0.38f,  0.0f,  0.0f, 1.0f, 1.0f, 1.0f,
			-0.7f,  0.98f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 1.0f,
			-0.7f,  0.93f,  0.38f,  0.0f,  0.0f, 1.0f, 0.0f, 0.0f,
			//Left Face			//Negative X Normals
			-0.7f,  0.98f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			-0.7f,  0.98f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			-0.7f,  0.93f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f,  0.93f,  0.38f, -1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			-0.7f,  0.93f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			-0.7f,  0.98f,  0.43f, -1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Right Face 		//Positive X Normals
			 0.7f,  0.98f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			 0.7f,  0.98f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 1.0f,
			 0.7f,  0.93f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f,  0.93f,  0.38f,  1.0f,  0.0f,  0.0f, 0.0f, 0.0f,
			 0.7f,  0.93f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 0.0f,
			 0.7f,  0.98f,  0.43f,  1.0f,  0.0f,  0.0f, 1.0f, 1.0f,
			//Bottom Face		//Negative Y Normals
			-0.7f,  0.93f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f,  0.93f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f,  0.93f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f,  0.93f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f,  0.93f,  0.43f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.7f,  0.93f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			//Top Face			//Positive X Normals
			-0.7f,  0.98f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			 0.7f,  0.98f,  0.38f,  0.0f, -1.0f,  0.0f, 1.0f, 0.0f,
			 0.7f,  0.98f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			 0.7f,  0.98f,  0.43f,  0.0f, -1.0f,  0.0f, 1.0f, 1.0f,
			-0.7f,  0.98f,  0.43f,  0.0f, -1.0f,  0.0f, 0.0f, 1.0f,
			-0.7f,  0.98f,  0.38f,  0.0f, -1.0f,  0.0f, 0.0f, 0.0f,
			/* End Front Top Support */	
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

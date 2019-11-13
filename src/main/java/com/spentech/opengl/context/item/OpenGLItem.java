package com.spentech.opengl.context.item;

import org.joml.Vector3f;

import com.spentech.opengl.graph.mesh.Mesh;

public interface OpenGLItem {

	public Vector3f getPosition();
	
	public void setPosition(float x, float y, float z);
	
	public Vector3f getRotation();
	
	public void setRotation(float x, float y, float z);
	
	public float getScale();
	
	public void setScale(float scale);
	
	public Mesh getMesh();
	
}

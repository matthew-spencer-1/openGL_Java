package com.spentech.opengl.graph.mesh;

public interface Mesh {
	
	public void cleanUp();
	
	public int getVaoId();
	
	public void render();

}

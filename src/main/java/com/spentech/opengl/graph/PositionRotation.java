package com.spentech.opengl.graph;

import org.joml.Vector3f;

public abstract class PositionRotation {

	protected final Vector3f position;
	protected final Vector3f rotation;

	public PositionRotation() {

		position = new Vector3f(0, 0, 0);
		rotation = new Vector3f(0, 0, 0);
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(float x, float y, float z) {
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(float x, float y, float z) {
		this.rotation.x = x;
		this.rotation.y = y;
		this.rotation.z = z;
	}

}

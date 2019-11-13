package com.spentech.opengl.context.camera;

import org.joml.Vector3f;

import com.spentech.opengl.graph.PositionRotation;

public class Camera extends PositionRotation {

	private final Vector3f target;
	private final Vector3f upY;
	private final Vector3f forwardZ;

	public Camera() {
		super();
		target = new Vector3f(0, 0, 0);
		upY = new Vector3f(0,0,0);
		forwardZ = new Vector3f(0,0,0);
	}

	public void movePosition(float offsetX, float offsetY, float offsetZ) {
		if (offsetZ != 0) {
			position.x += (float) Math.sin(Math.toRadians(rotation.y)) * -1.0f * offsetZ;
			position.z += (float) Math.cos(Math.toRadians(rotation.y)) * offsetZ;
		}
		if (offsetX != 0) {
			position.x += (float) Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * offsetX;
			position.z += (float) Math.cos(Math.toRadians(rotation.y - 90)) * offsetX;
		}
		position.y += offsetY;
	}

	public void moveRotation(float offsetX, float offsetY, float offsetZ) {
		rotation.x += offsetX;
		rotation.y += offsetY;
		rotation.z += offsetZ;
	}

	public void setCameraTarget(float x, float y, float z) {
		this.target.x = x;
		this.target.y = y;
		this.target.z = z;
	}
	
	public void setCameraUpY(float x, float y, float z) {
		this.upY.x = x;
		this.upY.y = y;
		this.upY.z = z;
	}
	
	public void setForwardZ(float x, float y, float z) {
		this.forwardZ.x = x;
		this.forwardZ.y = y;
		this.forwardZ.z = z;
	}

	public Vector3f getTarget() {
		return this.target;
	}

	public Vector3f getDirection() {
		return this.position.sub(this.target).normalize();
	}
	
	public Vector3f getCameraRight() {
		return this.upY.cross(this.getDirection()).normalize();
	}
	
	public Vector3f getCameraUp() {
		return this.getDirection().cross(this.getCameraRight());
	}

}

package com.spentech.opengl.graph;

public abstract class PositionRotationScale extends PositionRotation {
	
    private float scale;
    
    public PositionRotationScale() {
    	super();
    	scale = 1;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

}

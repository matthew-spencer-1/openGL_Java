package com.spentech.opengl;

import com.spentech.opengl.context.OpenGLContextImpl;
import com.spentech.opengl.context.OpenGLContext;
import com.spentech.opengl.engine.ContextEngine;
 
public class Main {
 
    public static void main(String[] args) {
        try {
            boolean vSync = true;
            boolean useTextures = true;
            boolean useLighting = true;
            OpenGLContext context = new OpenGLContextImpl(useTextures, useLighting);
            ContextEngine contxtEng = new ContextEngine("Open GL PlayGround", 800, 600, vSync, context);
            contxtEng.run();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
}
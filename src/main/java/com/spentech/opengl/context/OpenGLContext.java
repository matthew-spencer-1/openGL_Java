package com.spentech.opengl.context;

import com.spentech.opengl.context.window.MouseInput;
import com.spentech.opengl.context.window.Window;

public interface OpenGLContext {

    void init(Window window) throws Exception;
    
    void input(Window window, MouseInput mouseInput);

    void update(float interval, MouseInput mouseInput);
    
    void render(Window window);
    
    void cleanup();
}
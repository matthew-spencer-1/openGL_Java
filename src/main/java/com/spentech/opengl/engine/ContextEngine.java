package com.spentech.opengl.engine;

import com.spentech.opengl.context.OpenGLContext;
import com.spentech.opengl.context.window.MouseInput;
import com.spentech.opengl.context.window.Window;
import com.spentech.opengl.utils.Timer;

public class ContextEngine implements Runnable {

    public static final int TARGET_FPS = 75;
    public static final int TARGET_UPS = 30;
    
    private final Window window;
    private final Timer timer;

    private final OpenGLContext oglContext;
    private final MouseInput mouseInput;

    public ContextEngine(String windowTitle, int width, int height, boolean vSync, OpenGLContext oglContext) throws Exception {
        window = new Window(windowTitle, width, height, vSync);
        mouseInput = new MouseInput();
        this.oglContext = oglContext;
        timer = new Timer();
    }

    @Override
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            cleanup();
        }
    }

    protected void init() throws Exception {
        window.init();
        mouseInput.init(window);
        timer.init();
        oglContext.init(window);
    }

    protected void gameLoop() {
        float elapsedTime;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;

        boolean running = true;
        while (running && !window.windowShouldClose()) {
            elapsedTime = timer.getElapsedTime();
            accumulator += elapsedTime;

            input();
            
            while (accumulator >= interval) {
                update(interval);
                accumulator -= interval;
            }
            
            render();

            if (!window.isvSync()) {
                sync();
            }
        }
    }

    protected void cleanup() {
        oglContext.cleanup();
    }

    private void sync() {
        float loopSlot = 1f / TARGET_FPS;
        double endTime = timer.getLastLoopTime() + loopSlot;
        while (timer.getTime() < endTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
            }
        }
    }

    protected void input() {
    	mouseInput.input(window);
        oglContext.input(window, mouseInput);
    }

    protected void update(float interval) {
        oglContext.update(interval, mouseInput);
    }

    protected void render() {
        oglContext.render(window);
        window.update();
    }
}

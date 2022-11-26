package com.eclaw.engine;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

public class KeyListener {
    private static KeyListener instance;
    private final boolean keyPressed[] = new boolean[350];

    private KeyListener() {

    }

    public static KeyListener get() {
        if (instance == null) {
            instance = new KeyListener();
        }
        return instance;
    }

    public static void keyCallback(final long window, final int key, final int scancode, final int action, final int mods) {

        if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) {
            glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        }

        if (action == GLFW_PRESS) {
            get().keyPressed[key] = true;
        } else if (action == GLFW_RELEASE) {
            get().keyPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(final int keyCode) {
        return get().keyPressed[keyCode];
    }
}

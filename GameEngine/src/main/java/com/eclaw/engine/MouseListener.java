package com.eclaw.engine;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance;
    private final boolean[] mouseButtonPressed = new boolean[]{false, false, false};
    private double scrollX = 0.0;
    private double scrollY = 0.0;
    private double xPos = 0.0;
    private double yPos = 0.0;
    private double lastX = 0.0;
    private double lastY = 0.0;
    private boolean isDragging = false;

    private MouseListener() {
    }

    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }
        return MouseListener.instance;
    }

    public static void mousePosCallback(final long window, final double xPos, final double yPos) {
        get().lastX = get().xPos;
        get().lastY = get().yPos;
        get().xPos = xPos;
        get().yPos = yPos;
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }

    public static void mouseButtonCallback(final long window, final int button, final int action, final int mods) {
        if (button < get().mouseButtonPressed.length) {
            if (action == GLFW_PRESS) {
                get().mouseButtonPressed[button] = true;
            } else if (action == GLFW_RELEASE) {
                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void mouseScrollCallback(final long window, final double xOffset, final double yOffset) {
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    public static void endFrame() {
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastX = get().xPos;
        get().lastY = get().yPos;
    }

    public static float getX() {
        return (float) get().xPos;
    }

    public static float getY() {
        return (float) get().yPos;
    }

    public static float getDx() {
        return (float) (get().lastX - get().xPos);
    }

    public static float getDy() {
        return (float) (get().lastY - get().yPos);
    }

    public static float getScrollX() {
        return (float) get().scrollX;
    }

    public static float getScrollY() {
        return (float) get().scrollY;
    }

    public static boolean isDragging() {
        return get().isDragging;
    }

    public static boolean mouseButtonDown(final int button) {
        return button > get().mouseButtonPressed.length && get().mouseButtonPressed[button];
    }
}

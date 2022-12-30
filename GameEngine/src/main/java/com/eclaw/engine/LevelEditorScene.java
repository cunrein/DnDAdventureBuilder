package com.eclaw.engine;

import com.eclaw.util.SceneType;
import lombok.NoArgsConstructor;

import java.awt.event.KeyEvent;

@NoArgsConstructor
public class LevelEditorScene extends Scene {

    private boolean changingScene;
    private float timeToChange = 2.0f;

    @Override
    public void update(float dt) {
        if (!changingScene && KeyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            changingScene = true;
        }

        if (changingScene && timeToChange > 0) {
            timeToChange -= dt;
            Window.get().setR(Window.get().getR() - (dt * 2.5f));
            Window.get().setG(Window.get().getG() - (dt * 2.5f));
            Window.get().setB(Window.get().getB() - (dt * 2.5f));
        } else if (changingScene) {
            Window.changeScene(SceneType.LEVEL);
        }
    }
}

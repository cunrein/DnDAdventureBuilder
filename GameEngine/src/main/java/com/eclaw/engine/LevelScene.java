package com.eclaw.engine;

import com.eclaw.util.SceneType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LevelScene extends Scene {

    private float timeToChange = 2.0f;

    @Override
    public void update(final float dt) {
        if (timeToChange > 0) {
            timeToChange -= dt;
            Window.get().setR(Window.get().getR() + (dt * 2.5f));
            Window.get().setG(Window.get().getG() + (dt * 2.5f));
            Window.get().setB(Window.get().getB() + (dt * 2.5f));
        } else {
            Window.changeScene(SceneType.LEVEL_EDITOR);
        }
    }
}

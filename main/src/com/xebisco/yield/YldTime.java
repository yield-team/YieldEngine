/*
 * Copyright [2022] [Xebisco]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xebisco.yield;

/**
 * An instance of this class is made to contain the time information of a YldGame.
 *
 * @author Xebisco
 * @since 4_beta1
 */
public class YldTime {
    private float delta, fps, targetFPS;
    private YldGame game;

    /**
     * Creates a YldTime instance that will pick the time information of the passed YldGame
     *
     * @param game the game instance
     */
    public YldTime(YldGame game) {
        setGame(game);
    }

    /**
     * @return The delta time of the current frame. This variable is updated in the YldTimeSystem.
     * @since 4_beta1
     */
    public float getDelta() {
        return delta;
    }

    /**
     * @return The fps since the last frame. This variable is updated in the YldTimeSystem.
     * @since 4_beta1
     */
    public float getFps() {
        return fps;
    }

    /**
     * @return The target fps of the YldGame GameConfiguration instance.
     * @since 4_1.1
     */
    public float getTargetFPS() {
        return targetFPS;
    }

    public void setTargetFPS(float fps) {
        if(fps <= 0) throw new IllegalArgumentException("TargetFPS needs to be mor than 0");
        targetFPS = fps;
        game.getHandler().setTargetTime((int) (1000 / fps));
    }

    /**
     * @return This YldTime YldGame instance.
     */
    public YldGame getGame() {
        return game;
    }

    /**
     * Setter for the YldGame instance
     */
    public void setGame(YldGame game) {
        this.game = game;
        targetFPS = game.getConfiguration().fps;
    }

    /**
     * Setter for the delta variable
     */
    public void setDelta(float delta) {
        this.delta = delta;
    }

    /**
     * Setter for the fps variable
     */
    public void setFps(float fps) {
        this.fps = fps;
    }

    /**
     * Returns the fps of the RenderMaster of this game.
     *
     * @return The RenderMaster fps.
     */
    public float getRenderFps() {
        return game.getHandler().getRenderMaster().fpsCount();
    }
}

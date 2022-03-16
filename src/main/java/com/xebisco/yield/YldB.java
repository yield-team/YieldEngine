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

import com.xebisco.yield.engine.Engine;
import com.xebisco.yield.engine.EngineStop;
import com.xebisco.yield.engine.YldEngineAction;
import com.xebisco.yield.utils.MultiThread;
import com.xebisco.yield.utils.YldAction;

/**
 * Sample methods for the majority of the Yield Game Engine classes.
 * @since 4_alpha1
 * @author Xebisco
 */
public abstract class YldB
{

    protected YldGame game;

    public abstract void create();

    public abstract void update(float delta);

    public abstract void onDestroy();

    /**
     * Executes a YldAction instance independently of others.
     * @param action The action to be executed.
     * @param multiThread The thread configuration.
     */
    public final void concurrent(YldAction action, MultiThread multiThread)
    {
        if (multiThread == MultiThread.DEFAULT)
        {
            game.getHandler().getDefaultConcurrentEngine().getTodoList().add(new YldEngineAction(action, 0, false));
        }
        else if (multiThread == MultiThread.ON_GAME_THREAD)
        {
            game.getHandler().getTodoList().add(new YldEngineAction(action, 0, false));
        }
        else if (multiThread == MultiThread.EXCLUSIVE)
        {
            Engine engine = new Engine(null);
            engine.getThread().start();
            engine.getTodoList().add(new YldEngineAction(action, 0, false));
            YldEngineAction action1 = new YldEngineAction(() ->
            {
                engine.setStop(EngineStop.INTERRUPT_ON_END);
                engine.setRunning(false);
            }, 0, false);
            engine.getTodoList().add(action1);
        }
    }

    /**
     * Creates a timer.
     * @param action The action to be performed on the end of the timer.
     * @param time The time, in seconds to end the timer.
     * @param repeat If the timer repeat after it ends.
     * @param multiThread The thread configuration.
     */
    public final void timer(YldAction action, float time, boolean repeat, MultiThread multiThread)
    {
        if (multiThread == MultiThread.DEFAULT)
        {
            game.getHandler().getDefaultConcurrentEngine().getTodoList().add(new YldEngineAction(action, (int) (time * 1000), repeat));
        }
        else if (multiThread == MultiThread.ON_GAME_THREAD)
        {
            game.getHandler().getTodoList().add(new YldEngineAction(action, (int) (time * 1000), repeat));
        }
        else if (multiThread == MultiThread.EXCLUSIVE)
        {
            Engine engine = new Engine(null);
            engine.getThread().start();
            engine.getTodoList().add(new YldEngineAction(action, (int) (time * 1000), repeat));
            YldEngineAction action1 = new YldEngineAction(() ->
            {
                engine.setStop(EngineStop.INTERRUPT_ON_END);
                engine.setRunning(false);
            }, 0, false);
            engine.getTodoList().add(action1);
        }
    }

    /**
     * Creates a timer, on the on game thread.
     * @param action The action to be performed on the end of the timer.
     * @param time The time, in seconds to end the timer.
     * @param repeat If the timer repeat after it ends.
     */
    public final void timer(YldAction action, float time, boolean repeat)
    {
        timer(action, time, repeat, MultiThread.ON_GAME_THREAD);
    }

    /**
     * Executes a YldAction instance independently of others, on the default multi thread.
     * @param action The action to be executed.
     */
    public final void concurrent(YldAction action)
    {
        concurrent(action, MultiThread.DEFAULT);
    }

    public YldGame getGame()
    {
        return game;
    }

    public void setGame(YldGame game)
    {
        this.game = game;
    }
}

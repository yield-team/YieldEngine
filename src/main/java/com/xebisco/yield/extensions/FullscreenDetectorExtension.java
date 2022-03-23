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

package com.xebisco.yield.extensions;

import com.xebisco.yield.Key;
import com.xebisco.yield.YldExtension;
import com.xebisco.yield.input.Keys;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class FullscreenDetectorExtension extends YldExtension
{

    private boolean fullscreen;

    private int fullscreenKey1 = Key.ALT, fullscreenKey2 = Key.F;
    private boolean importConfig = true;

    @Override
    public void update (float delta)
    {
        if (importConfig)
        {
            importConfig = false;
            fullscreen = game.getConfiguration().fullscreen;
            game.getInput().addShortcut(new Keys(fullscreenKey1, fullscreenKey2), () -> setFullscreen(!fullscreen));
        }
    }

    public int getFullscreenKey1()
    {
        return fullscreenKey1;
    }

    public void setFullscreenKey1(int fullscreenKey1)
    {
        this.fullscreenKey1 = fullscreenKey1;
    }

    public int getFullscreenKey2()
    {
        return fullscreenKey2;
    }

    public void setFullscreenKey2(int fullscreenKey2)
    {
        this.fullscreenKey2 = fullscreenKey2;
    }

    public boolean isImportConfig()
    {
        return importConfig;
    }

    public void setImportConfig(boolean importConfig)
    {
        this.importConfig = importConfig;
    }

    public boolean isFullscreen()
    {
        return fullscreen;
    }

    private void setFullscreen(boolean fullscreen)
    {
        try
        {
            Display.setFullscreen(true);
        } catch (LWJGLException e)
        {
            e.printStackTrace();
        }
    }
}
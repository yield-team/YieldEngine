/*
 * Copyright [2022] [Xebisco]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xebisco.yield.render;

import com.xebisco.yield.Color;
import com.xebisco.yield.Pixel;
import com.xebisco.yield.Texture;
import com.xebisco.yield.Vector2;

import java.io.InputStream;

/**
 * @since 4-1.2
 * @author Xebisco
 */
public interface VisualUtils {
    void loadTexture(Texture texture);
    void unloadTexture(Texture texture);

    void clearTexture(Texture texture);
    void loadFont(String saveName, String fontName, int fontSize, int fontStyle);
    void loadFont(String fontName, float size, float sizeToLoad, int fontFormat, InputStream inputStream);
    void unloadFont(String fontName);
    Color[][] getTextureColors(Texture texture);
    void setTextureColors(Texture texture, Color[][] colors);
    void setPixel(Texture texture, Color color, Vector2 position);
    Texture cutTexture(Texture texture, int x, int y, int width, int height);
    Texture duplicate(Texture texture);
    Texture overlayTexture(Texture tex1, Texture tex2, Vector2 pos1, Vector2 pos2);
    Texture scaleTexture(Texture texture, int width, int height);

    int getTextureWidth(int textureId);
    int getTextureHeight(int textureId);
}

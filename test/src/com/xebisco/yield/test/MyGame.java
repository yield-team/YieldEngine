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

package com.xebisco.yield.test;

import com.xebisco.yield.*;

public class MyGame extends YldGame {
    @Override
    public void create() {
        instantiate( e -> {
           e.center();
           e.addComponent(new Rectangle(new Vector2(100, 100)));
           e.addComponent(new PhysicsBody());
        });
    }

    public static void main(String[] args) {
        Yld.debug = true;
        GameConfiguration config = new GameConfiguration();
        Ini.file(new RelativeFile("com/xebisco/yield/test/assets/game.ini"), config);
        launch(new MyGame(), config);
    }
}
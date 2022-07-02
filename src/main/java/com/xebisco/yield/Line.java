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

package com.xebisco.yield;

public class Line extends SimpleRenderable {
    private Vector2 point2 = new Vector2(10, 10);

    @Override
    public void render(SampleGraphics graphics) {
        graphics.drawLine(getEntity().getTransform().position.subt(scene.getView().getTransform().position), getEntity().getTransform().position.subt(scene.getView().getTransform().position).sum(point2.mul(getEntity().getTransform().scale)), getColor());
    }

    public Vector2 getPoint2() {
        return point2;
    }

    public void setPoint2(Vector2 point2) {
        this.point2 = point2;
    }
}

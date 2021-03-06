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

public class SimpleRenderable extends Component {
    private boolean forceAngle;
    private Color color = Colors.CYAN;

    private float angle;

    private Vector2 addAnchorPoint = new Vector2();

    private boolean ignoreViewPosition;

    @Override
    public void render(SampleGraphics graphics) {
        float angle = getEntity().getTransform().rotation + this.angle;
        if (forceAngle)
            angle = this.angle;
        Vector2 pos = getEntity().getTransform().position.sum(addAnchorPoint);
        if (!ignoreViewPosition) {
            pos = pos.subt(scene.getView().getTransform().position);
        }
        graphics.setRotation(pos, angle);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isForceAngle() {
        return forceAngle;
    }

    public void setForceAngle(boolean forceAngle) {
        this.forceAngle = forceAngle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }

    public Vector2 getAddAnchorPoint() {
        return addAnchorPoint;
    }

    public void setAddAnchorPoint(Vector2 addAnchorPoint) {
        this.addAnchorPoint = addAnchorPoint;
    }

    public boolean isIgnoreViewPosition() {
        return ignoreViewPosition;
    }

    public void setIgnoreViewPosition(boolean ignoreViewPosition) {
        this.ignoreViewPosition = ignoreViewPosition;
    }
}

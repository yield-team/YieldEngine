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

import com.xebisco.yield.utils.Vector2;

public class Collider
{
    public enum Shape {
        RECTANGLE
    }
    private float density = 1, friction = .3f;
    private Shape shape;
    private Vector2 size;

    public Collider(Shape shape)
    {
        this.shape = shape;
    }

    public Collider(Shape shape, float density, float friction)
    {
        this.density = density;
        this.friction = friction;
        this.shape = shape;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public float getDensity()
    {
        return density;
    }

    public void setDensity(float density)
    {
        this.density = density;
    }

    public float getFriction()
    {
        return friction;
    }

    public void setFriction(float friction)
    {
        this.friction = friction;
    }

    public Vector2 getSize()
    {
        return size;
    }

    public void setSize(Vector2 size)
    {
        this.size = size;
    }
}
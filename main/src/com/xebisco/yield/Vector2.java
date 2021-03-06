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

import java.util.Objects;

public class Vector2
{
    public float x, y;

    public Vector2()
    {
    }

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Float.compare(vector2.x, x) == 0 && Float.compare(vector2.y, y) == 0;
    }

    public Vector2 mul(float value)
    {
        return new Vector2(x * value, y * value);
    }

    public Vector2 div(float value)
    {
        return new Vector2(x / value, y / value);
    }

    public Vector2 sum(float value)
    {
        return new Vector2(x + value, y + value);
    }

    public Vector2 subt(float value)
    {
        return new Vector2(x - value, y - value);
    }

    public Vector2 mul(Vector2 vector)
    {
        return new Vector2(x * vector.x, y * vector.y);
    }

    public Vector2 div(Vector2 vector)
    {
        return new Vector2(x / vector.x, y / vector.y);
    }

    public Vector2 sum(Vector2 vector)
    {
        return new Vector2(x + vector.x, y + vector.y);
    }

    public Vector2 subt(Vector2 vector)
    {
        return new Vector2(x - vector.x, y - vector.y);
    }

    @Deprecated
    public float distance(Vector2 other) {
        return (float) (((x + other.x) / Math.sqrt(2)) + (y + other.y) / Math.sqrt(2));
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    public Vector2 get()
    {
        return new Vector2(x, y);
    }

    @Override
    public String toString()
    {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void reset()
    {
        x = 0;
        y = 0;
    }
}

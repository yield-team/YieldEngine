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

import com.xebisco.yield.utils.ParticleObj;

import java.util.ArrayList;

public class ParticleSystem extends Component
{
    private boolean emitted;
    private float particlesLifeTime = 5;
    private ArrayList<Particle> toEmit = new ArrayList<>();
    private ArrayList<ParticleObj> active = new ArrayList<>();
    private Vector2 gravityForce = new Vector2(0, 3), emitSpeed = new Vector2(0, -4f);
    private int particlesIndex = 10;

    @Override
    public void update(float delta)
    {

        for (int i = 0; i < active.size(); i++)
        {
            ParticleObj po = active.get(i);
            if (YldGame.lwjgl)
                po.getGraphicalObject().slickImage = po.getParticle().getTexture().getSlickImage();
            else
                po.getGraphicalObject().image = po.getParticle().getTexture().getImage();
            po.getSpeed().x += gravityForce.x * delta;
            po.getSpeed().y += gravityForce.y * delta;
            po.getPos().x += po.getSpeed().x * delta * 60f;
            po.getPos().y += po.getSpeed().y * delta * 60f;
            po.getGraphicalObject().x = (int) po.getPos().x;
            po.getGraphicalObject().y = (int) po.getPos().y;
            po.getGraphicalObject().x2 = (int) (po.getGraphicalObject().x + po.getParticle().getSize().x);
            po.getGraphicalObject().y2 = (int) (po.getGraphicalObject().y + po.getParticle().getSize().y);
            po.getGraphicalObject().rotationV += po.getParticle().getRotationForce() * delta;
            po.getGraphicalObject().rotationX = (int) ((po.getParticle().getSize().x) / 2) + po.getGraphicalObject().x;
            po.getGraphicalObject().rotationY = (int) ((po.getParticle().getSize().y) / 2) + po.getGraphicalObject().y;
            po.setLife(po.getLife() - delta);
            if (po.getLife() <= 0)
            {
                active.remove(po);
                graphics.shapeRends.remove(po.getGraphicalObject());
            }
        }
    }

    public void emit()
    {
        emitted = true;
        for (Particle particle : toEmit)
        {
            ParticleObj po = new ParticleObj(particle);
            po.setLife(particlesLifeTime);
            po.getSpeed().x = emitSpeed.x;
            po.getSpeed().y = emitSpeed.y;
            po.setGraphicalObject(graphics.rect(transform.position.x - particle.getSize().x / 2f, transform.position.y - particle.getSize().y / 2f, particle.getSize().x, particle.getSize().y));
            po.getGraphicalObject().index = particlesIndex;
            po.getPos().x = po.getGraphicalObject().x;
            po.getPos().y = po.getGraphicalObject().y;
            active.add(po);
        }
        toEmit.removeIf(p -> true);
    }

    public boolean isEmitted()
    {
        return emitted;
    }

    public void setEmitted(boolean emitted)
    {
        this.emitted = emitted;
    }

    public ArrayList<Particle> getToEmit()
    {
        return toEmit;
    }

    public void setToEmit(ArrayList<Particle> toEmit)
    {
        this.toEmit = toEmit;
    }

    public float getParticlesLifeTime()
    {
        return particlesLifeTime;
    }

    public void setParticlesLifeTime(float particlesLifeTime)
    {
        this.particlesLifeTime = particlesLifeTime;
    }

    public ArrayList<ParticleObj> getActive()
    {
        return active;
    }

    public void setActive(ArrayList<ParticleObj> active)
    {
        this.active = active;
    }

    public Vector2 getGravityForce()
    {
        return gravityForce;
    }

    public void setGravityForce(Vector2 gravityForce)
    {
        this.gravityForce = gravityForce;
    }

    public Vector2 getEmitSpeed()
    {
        return emitSpeed;
    }

    public void setEmitSpeed(Vector2 emitSpeed)
    {
        this.emitSpeed = emitSpeed;
    }

    public int getParticlesIndex()
    {
        return particlesIndex;
    }

    public void setParticlesIndex(int particlesIndex)
    {
        this.particlesIndex = particlesIndex;
    }
}

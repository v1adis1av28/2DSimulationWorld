package org.example.Creatures;

import org.example.Coordinates;
import org.example.Entity;

public abstract class Creature extends Entity {
    private int speed_;
    private int hp_;
    public int getHp_() {
        return hp_;
    }
    public int getSpeed_() {
        return speed_;
    }
    public void setSpeed_(int speed_) {
        this.speed_ = speed_;
    }
    public void reduceHp()
    {
        this.hp_ = hp_-15;
    }
    public void healHp()
    {
        this.hp_ = getHp_() + 20;
    }
    public Creature()
    {
        this.speed_ = 3;
        this.hp_ = 50;
    }
    public boolean checkStatement()
    {
     return getHp_()<=0 ? false : true;
    }
    public void makeMove(boolean flag)
    {
        if (flag) {
            healHp();
        } else {
            reduceHp();
        }
    }
}

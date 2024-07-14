package org.example.Creatures;

import org.example.Coordinates;
import org.example.Entity;

public abstract class Creature extends Entity {
//    АБстрактный класс сущ-во должно иметь
    // кол-во хп, скорость(кол-во клеток которое может пройти за 1 ход)
    // Имеет абстрактный метод makeMove() - Сделать ход. Далее от него наследуются другие классы
    // И каждый будет реализовывать по своему
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
    abstract void makeMove(boolean flag);
}

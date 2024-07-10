package org.example.Creatures;

import org.example.Entity;

public abstract class Creature extends Entity {
//    АБстрактный класс сущ-во должно иметь
    // кол-во хп, скорость(кол-во клеток которое может пройти за 1 ход)
    // Имеет абстрактный метод makeMove() - Сделать ход. Далее от него наследуются другие классы
    // И каждый будет реализовывать по своему
    private int speed_;

    public int getHp_() {
        return hp_;
    }

    public void setHp_(int hp_) {
        this.hp_ = hp_;
    }

    public int getSpeed_() {
        return speed_;
    }

    public void setSpeed_(int speed_) {
        this.speed_ = speed_;
    }

    private int hp_;
    abstract void makeMove();
}
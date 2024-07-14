package org.example.Creatures;
import org.example.Coordinates;

public class Herbivore extends Creature {
    //Класс травоядных стремится найти ресурс(траву),Ю может потратить свой ход
    // - Сделать движение в сторону травы
    // - Если находится на траве поглотить ее]
    public void makeMove(boolean flag)
    {
        if (flag) {
            healHp();
        } else {
            reduceHp();
        }
    }
    public Herbivore getValue()
    {
        return this;
    }
    public Herbivore()
    {

    }
    private int speed_ = 4;
}

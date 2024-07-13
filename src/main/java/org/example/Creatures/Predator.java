package org.example.Creatures;

import org.example.Coordinates;

public class Predator extends Creature {
//    В дополении имеет силу атаки(колл-во хп которое сносит)
//    Может потратить ход на:
//    -Перемиститься к жертве(травоядному)
//    - Атаковать травоядное при это кол-во хп травоядного уменьшапется на силу атаки хищника,
//    если значение хп жертвы опускатся до 0, травоядное исчезает
    private int strength_;//Поле силы хищника
    public Predator()
    {
        super();
        this.strength_ = 50;
    }
    public int getStrength_()
    {
        return strength_;
    }
     public void makeMove(Coordinates coordinates)
    {
        //Здесь выполняется ход на кол-во значений в поле speed_;\
        //Также выполняется проход по пути Point и если мы попали на точку c жертвой, то хаваем травоядное.
    }
}

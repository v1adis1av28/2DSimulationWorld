package org.example.Creatures;

public class Predator extends Creature {
//    В дополении имеет силу атаки(колл-во хп которое сносит)
//    Может потратить ход на:
//    -Перемиститься к жертве(травоядному)
//    - Атаковать травоядное при это кол-во хп травоядного уменьшапется на силу атаки хищника,
//    если значение хп жертвы опускатся до 0, травоядное исчезает
    private int strength_;//Поле силы хищника
    public Predator()
    {

    }
    public int getStrength_()
    {
        return strength_;
    }
    public void setStrength_(int strength)
    {
        this.strength_ = strength;
    }
     public void makeMove()
    {
        //Здесь выполняется ход на кол-во значений в поле speed_;
    }
}

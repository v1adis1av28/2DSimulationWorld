package org.example.Creatures;

import org.example.Coordinates;

public class Predator extends Creature {
//    В дополении имеет силу атаки(колл-во хп которое сносит)
//    Может потратить ход на:
//    -Перемиститься к жертве(травоядному)
//    - Атаковать травоядное при это кол-во хп травоядного уменьшапется на силу атаки хищника,
//    если значение хп жертвы опускатся до 0, травоядное исчезает
    private int speed_ =5;
    public Predator()
    {
        super();
    }
}

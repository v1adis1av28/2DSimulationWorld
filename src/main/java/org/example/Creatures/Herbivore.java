package org.example.Creatures;
import org.example.Coordinates;

public class Herbivore extends Creature {
    //Класс травоядных стремится найти ресурс(траву),Ю может потратить свой ход
    // - Сделать движение в сторону травы
    // - Если находится на траве поглотить ее]
    public void makeMove(Coordinates coordinate)
    {
      //Здесь выполняется ход на кол-во значений в поле speed_;
        // Как передвижение будет выполняться переход по результату BFS на кол-во итераций скорости
        /*reduseHp();
        if(getHp_()<=0)
        {
            return;
        }
*/

    }
    public Herbivore getValue()
    {
        return this;
    }
    public Herbivore()
    {

    }
    private int speed_ = 2;
}

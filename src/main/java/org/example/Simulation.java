package org.example;

import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.Map;

//Главный класс приложеня
public class Simulation {
    private World world;
    private int stepsCount;
    private Renderer render;
    //nextTurn() - просимулировать и отрендерить один ход
    //startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    //pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга'
    public void nextTurn()
    {
        //что-то происходит(насколько я понимаю травоядные идут к траве, хищники за травоядными
        stepsCount++;
        turnActions();
    }

    private void initAcitons()
    {
        render.RenderWorld();
    }
    private void turnActions()
    {
        Map<Coordinates,Entity> map = world.getMap();
        //Получается проходим по всей мапе и для хищников и травоядных делаем действия
        //Если при переходе их координаты соовпадают с ресурсом который они могут поглотить
        for(Map.Entry<Coordinates,Entity> currentObject : map.entrySet())
        {
            if(currentObject.getValue() instanceof Rock || currentObject.getValue() instanceof Tree)
            {
                continue;//Так как дереьвья и камни статичные объекты на карте на каждом ходу мы просто пропускаем их действия
            }
            else
            {
                //ToDoo Доделать метод и придумать как использовать метод makeMove() Сейчас у тек.Объекта он не видит этого метода
            }
        }
    }
}

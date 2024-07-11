package org.example;
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
    }

    private void initAcitons()
    {
        render.RenderWorld();
    }
    private void turnActions()
    {
        //Получается проходим по всей мапе и для хищников и травоядных делаем действия
        //Если при переходе их координаты соовпадают с ресурсом который они могут поглотить
    }
}

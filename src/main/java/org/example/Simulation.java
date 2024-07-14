package org.example;

import org.example.Creatures.Herbivore;
import org.example.Creatures.Predator;
import org.example.Resources.Grass;
import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Главный класс приложения
public class Simulation {
    private World world;
    private int stepsCount;
    private Renderer render;
    private BFS bfs;

    // nextTurn() - просимулировать и отрендерить один ход
    // startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    // pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга
    public void nextTurn() {
        // что-то происходит (насколько я понимаю травоядные идут к траве, хищники за травоядными)
        stepsCount++;
        turnActions();
    }

    public Simulation() {
        this.render = new Renderer();
        this.bfs = new BFS();
        initActions();
    }

    private void initActions() {
        render.RenderWorld();
    }

    private void turnActions() {
        Map<Coordinates, Entity> map = render.getWorld().getMap();
        // Получается проходим по всей мапе и для хищников и травоядных делаем действия
        // Если при переходе их координаты совпадают с ресурсом, который они могут поглотить
        Iterator<Map.Entry<Coordinates, Entity>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Coordinates, Entity> currentObject = iterator.next();
            Coordinates currentCoordinates = currentObject.getKey();
            Entity currentEntity = currentObject.getValue();

            if (currentEntity instanceof Rock || currentEntity instanceof Tree || currentEntity instanceof Grass) {
                continue; // Так как деревья и камни статичные объекты на карте на каждом ходу мы просто пропускаем их действия
            } else {
                if (currentEntity instanceof Predator) {
                    Point route = bfs.BFS(currentCoordinates, new Herbivore(), render.getWorld()); // путь до ближайшего травоядного
                    List<Coordinates> path = route.buildPath(); // массив из координат пути для достижения травоядного
                    if (path.size() < ((Predator) currentEntity).getSpeed_()) {
                        Coordinates herbivoreCoordinates = path.get(path.size() - 1);
                        iterator.remove(); // Удаляем прошлое место хищника
                        map.remove(herbivoreCoordinates); // Съедаем травоядное
                        map.put(herbivoreCoordinates, new Predator()); // Хищник занимает место травоядного на карте
                        ((Predator) currentEntity).makeMove(true);
                    } else {
                        iterator.remove(); // Удаляем прошлое место хищника
                        map.put(path.get(((Predator) currentEntity).getSpeed_()), new Predator()); // Переместили на последнюю возможную по скорости клетку для хищника
                        ((Predator) currentEntity).makeMove(false);
                    }
                    if (!((Predator) currentEntity).checkStatement())
                        iterator.remove(); // Удаляем прошлое место хищника
                } else {
                    Point route = bfs.BFS(currentCoordinates, new Grass(), render.getWorld()); // путь до ближайшей травы
                    List<Coordinates> path = route.buildPath(); // массив из координат пути для достижения травоядного
                    if (path.size() < ((Herbivore) currentEntity).getSpeed_()) {
                        Coordinates grassCoordinates = path.get(path.size() - 1);
                        iterator.remove(); // Удаляем прошлое место травоядного
                        map.remove(grassCoordinates); // Съедаем траву
                        map.put(grassCoordinates, new Herbivore()); // травоядное занимает место травы на карте
                        ((Herbivore) currentEntity).makeMove(true);
                    } else {
                        iterator.remove(); // Удаляем прошлое место травоядного
                        map.put(path.get(((Herbivore) currentEntity).getSpeed_()), new Herbivore()); // Переместили на последнюю возможную по скорости клетку для травоядного
                        ((Herbivore) currentEntity).makeMove(false);
                    }
                    if (!((Herbivore) currentEntity).checkStatement())
                        iterator.remove(); // Удаляем прошлое место травоядного
                }
            }
        }
        render.RenderWorld();
    }
}
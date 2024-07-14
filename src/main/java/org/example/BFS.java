package org.example;
import org.example.Creatures.Predator;
import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class BFS {

   public Set<Point> getNeighbours(Coordinates currentCoordinate) {
    Set<Point> set = new HashSet<>();
    int directions[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    for (int[] direct : directions) {
        int coordX = currentCoordinate.getX() + direct[0];
        int coordY = currentCoordinate.getY() + direct[1];

        if (coordY >= 0 && coordX >= 0 && coordX < 10 && coordY < 10) { // Исправьте границы
            set.add(new Point(new Coordinates(coordX, coordY), new Point(currentCoordinate)));
        }
    }
    return set;
}
    //Вторым параметром будем передавать новый объект определнного класса, чтобы не писать доп методы для разделения
    //поиска для каждой сущности.Например для Хищника BFS(coordinate, new Herbivore(), world);
    public Point BFS(Coordinates startCoordinates, Entity object, World world) {
    Point startNode = new Point(startCoordinates, null);
    Queue<Point> queue = new LinkedList<>();
    Map<Coordinates, Entity> map = world.getMap();
    Set<Coordinates> visitedCoordinates = new HashSet<>();
    queue.add(startNode);

    while (!queue.isEmpty()) {
        Point currentNode = queue.poll(); // Текущая точка на карте
        Coordinates currentCoord = currentNode.getCurrentCoordinate();

        if (visitedCoordinates.contains(currentCoord)) {
            continue;
        }

        Entity currentType = map.get(currentCoord); // Тип данных который хранится в текущей точке

        if (currentType != null && object.getClass().equals(currentType.getClass())) {
            return currentNode;
        }

        visitedCoordinates.add(currentCoord);

        for (Point tmp : getNeighbours(currentCoord)) {
            Coordinates tmpCoord = tmp.getCurrentCoordinate();
            Entity tmpType = map.get(tmpCoord);

            // Проверка, что на клетке нет объекта, который мы хотим избежать
            if (!visitedCoordinates.contains(tmpCoord) && (tmpType == null || !tmpType.getClass().equals(Rock.class) && !tmpType.getClass().equals(Tree.class))) {
                tmp.setPrevPoint(currentNode); // Установите предыдущую точку
                queue.add(tmp);
            }
        }
    }
    return startNode;
}
}

class Point {
    private Coordinates currentCoordinate;
    private Point prevPoint;

    public Point(Coordinates coordinates) {
        this.currentCoordinate = coordinates;
        this.prevPoint = null;
    }

    public Point getPrevPoint() {
        return prevPoint;
    }

    public void setPrevPoint(Point prevPoint) {
        this.prevPoint = prevPoint;
    }

    public Point(Coordinates current, Point prev) {
        this.currentCoordinate = current;
        this.prevPoint = prev;
    }

    public Coordinates getCurrentCoordinate() {
        return currentCoordinate;
    }

    public List<Coordinates> buildPath() {
        List<Coordinates> path = new ArrayList<>();
        Point current = this;
        while (current != null) {
            path.add(current.getCurrentCoordinate());
            current = current.getPrevPoint();
        }
        Collections.reverse(path);
        return path;
    }
}
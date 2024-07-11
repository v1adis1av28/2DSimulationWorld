package org.example;
import java.util.HashSet;
import java.util.Set;
public class BFS {
    //Для класс нужна структура которая хранит в себе текущую координату, а также координату из которой она пришла
    //нужен метод для поиска соседних pointов

    public Set<Point> getNeighbours(Coordinates currentCoordinate)
    {
        Set<Point> set = new HashSet<>();
        int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] direct : directions)
        {
            int coordX = currentCoordinate.getX()+direct[0];
            int coordY = currentCoordinate.getY()+direct[1];

            if(coordY >=0 && coordX >=0 && coordX <=20 && coordY<=20)
            {
                set.add(new Point(new Coordinates(coordX,coordY),currentCoordinate));
            }
        }
        return set;
    }
}

class Point
{
    private Coordinates currentCoordinate;

    public Coordinates getPrevCoordinate() {
        return prevCoordinate;
    }
    public Point(Coordinates current, Coordinates prev)
    {
        this.currentCoordinate=current;
        this.prevCoordinate = prev;
    }
    public Coordinates getCurrentCoordinate() {
        return currentCoordinate;
    }
    private Coordinates prevCoordinate;

}
package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();
        BFS b = new BFS();
        Coordinates c = new Coordinates(0,0);
        for(Point a : b.getNeighbours(c))
        {
            System.out.println(a.getCurrentCoordinate().toString() + a.getPrevCoordinate().toString());
        }
    }

}// Х-хищник Т-травоядное т-трава к-камень Д-деревья
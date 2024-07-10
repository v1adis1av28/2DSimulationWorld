package org.example;
import org.example.Creatures.Herbivore;
import org.example.Creatures.Predator;
import org.example.Resources.Grass;
import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.*;

public class World {
    private int N;//Длина поля
    private int M;//Щирина поля

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    private Map<Coordinates,Entity> map;//Структура для хранения информации о мире



    public World()
    {
        this.N = 20;
        this.M = 20;
        this.map = new HashMap<>();
        fill();
        //нужно придумать как заполнить поле объектами и в каком количествае каждое
    }
    private void fill()
    {
        this.map.put(new Coordinates(0,1),new Predator());
        this.map.put(new Coordinates(0,2),new Tree());
        this.map.put(new Coordinates(0,3),new Herbivore());
        this.map.put(new Coordinates(0,4),new Grass());
        this.map.put(new Coordinates(0,5),new Predator());
        this.map.put(new Coordinates(0,6),new Tree());
        this.map.put(new Coordinates(0,0),new Rock());
    }
    public int getN() {
        return N;
    }
    public int getM() {
        return M;
    }
}

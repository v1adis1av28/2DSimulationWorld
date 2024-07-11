package org.example;
import org.example.Creatures.Herbivore;
import org.example.Creatures.Predator;
import org.example.Resources.Grass;
import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.*;

class World {
    private int N; // Длина поля
    private int M; // Ширина поля

    public Map<Coordinates, Entity> getMap() {
        return map;
    }

    private Map<Coordinates, Entity> map; // Структура для хранения информации о мире

    public World() {
        this.N = 20;
        this.M = 20;
        this.map = new HashMap<>();
        fill();
    }
    private void fill() {
        Random random = new Random();
        int[] counts = {10, 12, 15, 15, 15}; // Количество хищников, травоядных, травы, камней, деревьев
        Entity[] entities = {new Predator(), new Herbivore(), new Grass(), new Rock(), new Tree()};

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                Coordinates coord;
                do {
                    coord = new Coordinates(random.nextInt(N), random.nextInt(M));
                } while (map.containsKey(coord)); // Убеждаемся, что координаты уникальны
                map.put(coord, entities[i]);
            }
        }
    }


    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }
}

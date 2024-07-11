package org.example;

import org.example.Creatures.Herbivore;
import org.example.Creatures.Predator;
import org.example.Resources.Grass;
import org.example.Resources.Rock;
import org.example.Resources.Tree;

import java.util.Map;
import java.util.Objects;

public class Renderer {
    private World world;

    public World getWorld() {
        return world;
    }

    public Renderer() {
        this.world = new World();
    }

    public void RenderWorld() {
        world = getWorld();
        Map<Coordinates, Entity> map = world.getMap();
        // Метод должен проходить по значениям m,n и Отрисовывать значение в данных кординатах
        for (int i = 0; i < world.getN(); i++) {
            for (int j = 0; j < world.getM(); j++) {
                Coordinates coord = new Coordinates(i, j);
                Entity obj = map.get(coord);
                if (obj instanceof Predator) {
                    System.out.print(" 🐺 ");
                } else if (obj instanceof Herbivore) {
                    System.out.print(" 🐰 ");
                } else if (obj instanceof Rock) {
                    System.out.print(" 🏔 ");
                } else if (obj instanceof Grass) {
                    System.out.print(" 🌾 ");
                } else if (obj instanceof Tree) {
                    System.out.print(" 🌲 ");
                } else {
                    System.out.print(" *  ");
                }
            }
            System.out.println();
        }
    }
}
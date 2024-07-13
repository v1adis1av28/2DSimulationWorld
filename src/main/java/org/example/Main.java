package org.example;

import org.example.Creatures.Herbivore;

import javax.swing.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       Renderer sm = new Renderer();
       sm.RenderWorld();
        BFS b = new BFS();
        System.out.println(b.BFS(new Coordinates(1,1),new Herbivore(),sm.getWorld()));
    }

}// Х-хищник Т-травоядное т-трава к-камень Д-деревья
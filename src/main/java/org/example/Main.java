package org.example;

import org.example.Creatures.Herbivore;

import javax.swing.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       //Renderer sm = new Renderer();
       //sm.RenderWorld();
       Simulation sim = new Simulation();
       for(int i = 0;i<3;i++)
       {
           sim.nextTurn();
           System.out.println("------------------------------------------------");
               System.out.println();
           System.out.println();

       }

    }

}// Х-хищник Т-травоядное т-трава к-камень Д-деревья
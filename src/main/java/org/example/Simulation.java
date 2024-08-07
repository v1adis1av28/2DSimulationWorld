    package org.example;
    
    import org.example.Creatures.Herbivore;
    import org.example.Creatures.Predator;
    import org.example.Resources.Grass;
    import org.example.Resources.Rock;
    import org.example.Resources.Tree;

    import java.util.*;

    // Главный класс приложения
    public class Simulation {
        private int stepsCount;
        private Renderer render;
        private BFS bfs;

        public void nextTurn() {
            stepsCount++;
            turnActions();
        }
    
        public Simulation() {
            this.render = new Renderer();
            this.bfs = new BFS();
            initActions();
        }

        private void initActions() {
            System.out.println("Старт симуляции:");
            render.RenderWorld();
            System.out.println(" ----------------------------------------");
        }
        private boolean isResourserEnd()
        {
            boolean grass = false, predator = false, herbivore = false;
            for(Map.Entry<Coordinates,Entity> objct : render.getWorld().getMap().entrySet())
            {
                if(objct.getValue() instanceof Grass)
                {
                    grass = true;
                }
                else if(objct.getValue() instanceof Predator)
                {
                    predator = true;
                } else if (objct.getValue() instanceof Herbivore) {
                    herbivore = true;
                }
            }
            return grass && herbivore && predator;
        }
        public void startSimulation()
        {
            while(true)
            {
                if(isResourserEnd())//Проверка есть ли все необходимые ресурсы на карте
            {
                nextTurn();
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println();
            }
            else
            {
                System.out.println("Симуляция окончена! Необходимые ресурсы для определенного существа были закончены!");
                break;
            }
            }
        }

        private void turnActions() {
            Map<Coordinates, Entity> map = render.getWorld().getMap();
            Map<Coordinates, Entity> newEntities = new HashMap<>();
            List<Coordinates> toRemove = new ArrayList<>();

            Iterator<Map.Entry<Coordinates, Entity>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Coordinates, Entity> currentObject = iterator.next();
                Coordinates currentCoordinates = currentObject.getKey();
                Entity currentEntity = currentObject.getValue();

                if (currentEntity instanceof Rock || currentEntity instanceof Tree || currentEntity instanceof Grass) {
                    continue; // Static entities, no action needed
                } else {
                    if (currentEntity instanceof Predator) {
                        Point route = bfs.BFS(currentCoordinates, new Herbivore(), render.getWorld());
                        List<Coordinates> path = route.buildPath();
                        if (path.size() <= ((Predator) currentEntity).getSpeed_()) {
                            Coordinates herbivoreCoordinates = path.get(path.size() - 1);
                            toRemove.add(currentCoordinates);
                            toRemove.add(herbivoreCoordinates);
                            newEntities.put(herbivoreCoordinates, new Predator());
                            ((Predator) currentEntity).makeMove(true);
                        } else {
                            toRemove.add(currentCoordinates);
                            newEntities.put(path.get(((Predator) currentEntity).getSpeed_() - 1), new Predator());
                            ((Predator) currentEntity).makeMove(false);
                        }
                        if (!((Predator) currentEntity).checkStatement()) {
                            toRemove.add(currentCoordinates);
                        }
                    } else {
                        Point route = bfs.BFS(currentCoordinates, new Grass(), render.getWorld());
                        List<Coordinates> path = route.buildPath();
                        if (path.size() <= ((Herbivore) currentEntity).getSpeed_()) {
                            Coordinates grassCoordinates = path.get(path.size() - 1);
                            toRemove.add(currentCoordinates);
                            toRemove.add(grassCoordinates);
                            newEntities.put(grassCoordinates, new Herbivore());
                            ((Herbivore) currentEntity).makeMove(true);
                        } else {
                            toRemove.add(currentCoordinates);
                            newEntities.put(path.get(((Herbivore) currentEntity).getSpeed_() - 1), new Herbivore());
                            ((Herbivore) currentEntity).makeMove(false);
                        }
                        if (!((Herbivore) currentEntity).checkStatement()) {
                            toRemove.add(currentCoordinates);
                        }
                    }
                }
            }
            for (Coordinates coord : toRemove) {
                map.remove(coord);
            }
            map.putAll(newEntities);

            render.RenderWorld();
        }

    }
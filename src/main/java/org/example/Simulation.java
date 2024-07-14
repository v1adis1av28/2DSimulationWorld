    package org.example;
    
    import org.example.Creatures.Herbivore;
    import org.example.Creatures.Predator;
    import org.example.Resources.Grass;
    import org.example.Resources.Rock;
    import org.example.Resources.Tree;

    import java.util.*;

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

            // Apply the collected changes
            for (Coordinates coord : toRemove) {
                map.remove(coord);
            }
            map.putAll(newEntities);

            render.RenderWorld();
        }

    }
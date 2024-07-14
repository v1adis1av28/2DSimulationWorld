
# 2D World Simulation

The essence of the project is a step-by-step simulation of a 2D world populated by herbivores and predators. In addition to creatures, the world contains resources (grass) that herbivores feed on, and static objects that cannot be interacted with - they just take up space.

The 2D world is an NxM matrix, each creature or object occupies a cell entirely, the presence of several objects/creatures in a cell is unacceptable.

The idea is taken from here and simplified -> https://www.youtube.com/watch?v=SfEZSyvbj2w


## Screenshots

An example of how the program works

At each iteration, for all non-static entities, the program uses a breadth-first search algorithm, in which it searches for a path to its resource for each object and absorbs it. The simulation continues until one of the important resources is exhausted!
1)
![image](https://github.com/user-attachments/assets/28c92ce8-e38a-48dd-a8bd-7e4698880b47)
2)
![image](https://github.com/user-attachments/assets/b6b0809a-ec57-4e50-9c2a-1b177c3ee044)
3)
![image](https://github.com/user-attachments/assets/0e555c1c-e05d-4c28-89d3-21d71dc99db1)

## Authors

- [@v1adis1av28](https://github.com/v1adis1av28)


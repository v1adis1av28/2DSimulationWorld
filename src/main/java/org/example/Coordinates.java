package org.example;
//Вспомогательный класс структура
// Нужен для хранения кординат на поле
// будет использоваться в Map<?<T>,Coordinates>
//Ключ-тип существа или ресурса, а значение это его координаты
public class Coordinates {
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public Coordinates(int a,int b)
    {
        this.x = a;
        this.y = b;
    }

    private int x;
    private int y;

}

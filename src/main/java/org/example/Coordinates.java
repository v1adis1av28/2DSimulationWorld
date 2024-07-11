package org.example;
import java.util.Comparator;
import java.util.Objects;
//Вспомогательный класс структура
// Нужен для хранения кординат на поле
// будет использоваться в Map<?<T>,Coordinates>
//Ключ-тип существа или ресурса, а значение это его координаты
public class Coordinates implements Comparable<Coordinates> {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Coordinates other) {
        // Сравнение по X, если X равны, то по Y
        int result = Integer.compare(this.x, other.x);
        if (result == 0) {
            result = Integer.compare(this.y, other.y);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Конструктор для компаратора, если нужен
    public static Comparator<Coordinates> COMPARATOR = new Comparator<Coordinates>() {
        @Override
        public int compare(Coordinates c1, Coordinates c2) {
            return c1.compareTo(c2);
        }
    };
}
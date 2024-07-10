package org.example;
import java.util.Map;
public class World {
    private int N;//Длина поля
    private int M;//Щирина поля

    private Map<Coordinates,Entity> map;//Структура для хранения информации о мире
    public World()
    {
        this.N = 20;
        this.M = 20;
        //нужно придумать как заполнить поле объектами и в каком количествае каждое
    }
}

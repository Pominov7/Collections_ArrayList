package com.company.Playground;

//класс "Игровая таблица"
public class GameTable implements Comparable<GameTable> {

    // поля
    int playerIndex; // индекс игрока в списке игроков
    int gameIndex; //  индекс игры в списке игр
    int rating; //  рейтинг пользователя


    // Конструкторы
    // 1. Конструктор с 3-мя параметрами
    public GameTable(int userIndex, int gameIndex, int rating) {
        this.playerIndex = userIndex;
        this.gameIndex = gameIndex;
        this.rating = rating;
    }

    //метод для сравнения объектов
    @Override
    public int compareTo(GameTable obj) {
        return (this.rating - obj.rating);
    }//возвращаем разницу рейтингов
}

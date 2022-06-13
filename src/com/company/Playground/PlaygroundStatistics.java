package com.company.Playground;

//Класс "Статистика игровой площадки"

public class PlaygroundStatistics {
    public static void main(String[] args) throws Exception {

        //Создали базу данных игровой площадки
        PlaygroundDatabase base = new PlaygroundDatabase();

        //вызвали меню игровой площадки
        base.showMenu();
    }
}


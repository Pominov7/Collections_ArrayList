package com.company.Playground;

import java.util.Random;
import java.util.Scanner;

// Класс "Игровое меню"
public class Menu {
    public static void showMenu() {
        Scanner in = new Scanner(System.in);

        //Создали базу данных игровой площадки
        PlaygroundDatabase base = new PlaygroundDatabase();

        //Создали переменную для обработки меню
        String menu;

        //Создаем 10 игр и добавляем их в список игр
        base.addGame("Assassin's Creed 2");
        base.addGame("The Witcher");
        base.addGame("Grand Theft Auto V");
        base.addGame("Mortal Combat");
        base.addGame("Red Dead Redemption 2");
        base.addGame("Resident Evil 2: Remake");
        base.addGame("Half-Life");
        base.addGame("Mass Effect 2");
        base.addGame("Horizon Zero Dawn");
        base.addGame("Battlefield 3");

        //Создаем 10 игроков и добавляем их в список игр
        System.out.println("Список игроков: ");
        base.addPlayer("James");
        base.addPlayer("James");
        base.addPlayer("William");
        base.addPlayer("Benjamin");
        base.addPlayer("Michael");
        base.addPlayer("Amelia");
        base.addPlayer("Harry");
        base.addPlayer("Jack");
        base.addPlayer("Jon");
        base.addPlayer("Anna");
        base.showPlayerAll();


        //Рандомное присвоение рейтинга победителю
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            base.addRatingWinner(rand.nextInt(10), rand.nextInt(10));
        }

        //меню
        while (true) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println("1 - список игр ");
            System.out.println("2 - рейтинг игроков в игре ");
            System.out.println("3 - рейтинг 10 игроков в игре ");
            System.out.println("4 - рейтинг 10 игроков по всем играм ");
            System.out.println("5 - выход ");
            menu = in.nextLine();

            if ("1".equals(menu)) {
                System.out.println("Список игр: ");
                base.showGamesAll();
            }

            if ("2".equals(menu)) {

                int playerIndex = base.indexPlayer();//выбор игрока
                int gameIndex = base.indexGame();//выбор игры
                System.out.println("Рейтинг: " + base.getRatingList(playerIndex, gameIndex));
            }

            if ("3".equals(menu)) {
                int gameIndex = base.indexGame();
                base.showBestByGame(gameIndex);
            }

            if ("4".equals(menu)) {
                base.showBestByAllGame();
            }

            if ("5".equals(menu)) {
                System.out.println("До встречи в новых играх! ");
                break;
            }
        }
    }
}
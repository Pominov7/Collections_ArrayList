package com.company.Playground;

import java.util.ArrayList;
import java.util.Scanner;

//Класс "Игровая площадка онлайн"
public class Playground {

    //поля
    ArrayList<String> playerList = new ArrayList<>(); //список никнеймов игроков
    ArrayList<String> gameList = new ArrayList<>();// список игр на площадке
    ArrayList<GameTable> ratingList = new ArrayList<>();//список рейтингов игроков

    //Сканер для ввода игроков
    Scanner in = new Scanner(System.in);

    //методы
    // 1.  добавить игрока в список игроков
    public String addPlayer(String playerName) {
        String newName = playerName;
        if (playerList.size() == 0) {
            playerList.add(playerName);
        } else
            for (String item : playerList) {
                if (item.equals(newName)) {
                    int rand = (int) (Math.random() * 1000);
                    newName += "@" + rand;
                    System.out.println("Ваш новый никнейм: " + newName);
                    playerList.add(newName);
                    return newName;
                }
                playerList.add(newName);
                break;
            }
        return newName;
    }

    // 2.  добавить игру в список игр
    public boolean addGame(String gameName) {
        for (String game : this.gameList) {
            if (game == gameName) {
                return false;
            }
        }
        this.gameList.add(gameName);
        return true;
    }

    // 3.  показать список игроков
    public void showPlayerList() {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(i + 1 + ")" + "." + playerList.get(i));
        }
    }

    // 4.  выбрать игрока по индексу
    public int indexPlayer() {
        System.out.println("Выберите пользователя: ");
        showPlayerList();//отобразить список игроков на экране
        return in.nextInt();// номер,который вводится с клавиатуры
    }


    // 5.  показать список игр
    public void showGameList() {
        for (int i = 0; i < gameList.size(); i++) {
            System.out.println(i + 1 + ")" + "." + gameList.get(i));
        }
    }

    // 6.  выбрать игру по индексу
    public int indexGame() {
        System.out.println("Выберите игру: ");
        showGameList();//отобразить список игр на экране
        return in.nextInt();// номер,который вводится с клавиатуры
    }

    // 7.  добавить рейтинг игроку в игре
    public int getRating(int userIndex, int gameIndex) {
        int res = 0;
        GameTable p1; // запись таблицы
        for (GameTable table : ratingList) {
            p1 = table;
            if (p1.playerIndex == userIndex && p1.gameIndex == gameIndex)
                res += p1.rating;

        }
        return res;
    }
}

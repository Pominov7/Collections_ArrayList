package com.company.Playground;

import java.util.Collections;
import java.util.Scanner;

//Класс "База данных игровой площадки"
public class PlaygroundDatabase {

    //поля
    private Playground ratings = new Playground(); // рейтинг
    private Playground player = new Playground(); // игрок
    private Playground game = new Playground(); //  игра

    //сканер для ввода пунктов меню
    Scanner in = new Scanner(System.in);

    //методы
    // 1.  добавить игрока игрока
    public String addPlayer(String name) {
        return player.addPlayer(name);
    }

    // 2. добавить игру
    public boolean addGame(String name) {
        return game.addGame(name);
    }

    // 3. добавить рейтинг победителю
    public void addRatingWinner(int userIndex, int gameIndex) {
        GameTable p1;
        //поиск пользователя в игре
        int index = -1;
        for (int i = 0; i < ratings.ratingList.size(); i++) {
            p1 = ratings.ratingList.get(i);
            if (p1.gameIndex == gameIndex && p1.playerIndex == userIndex) {
                index = i;
            }
        }
        if (index == -1) {
            ratings.ratingList.add(new GameTable(gameIndex, userIndex, 0));
            index = ratings.ratingList.size() - 1;
        }
        int ratingOld = ratings.ratingList.get(index).rating;
        int ratingNew = ratingOld + 1;
        ratings.ratingList.set(index, new GameTable(gameIndex, userIndex, ratingNew));
    }


    // 4. выбрать игрока по индексу
    public int indexPlayer() {
        return player.indexPlayer();
    }

    // 5.  выбрать игру по индексу
    public int indexGame() {
        return game.indexGame();
    }

    // 6.  показать список игр
    public void showGamesAll() {
        game.showGameList();
    }

    // 7.  показать список игроков
    public void showPlayerAll() {
        player.showPlayerList();
    }

    // 7. добавить рейтинг игроку в игре
    public int getRatingList(int userIndex, int gameIndex) {
        return ratings.getRating(userIndex, gameIndex);
    }

    // 8. вывод 10 лучших игроков в определенной игре
    public void showBestByGame(int gameIndex) {
        Playground table = new Playground();
        GameTable p1;
        //проход по таблице рейтингов
        for (int i = 0; i < ratings.ratingList.size(); i++) {
            p1 = ratings.ratingList.get(i);
            if (p1.gameIndex == gameIndex)
                table.ratingList.add(p1);
        }

        Collections.sort(table.ratingList);
        Collections.reverse(table.ratingList);
        System.out.println("рейтинг игроков в игре " + game.gameList.get(gameIndex));
        for (int i = 0; i < 10; i++) {
            if (i < table.ratingList.size()) {
                p1 = table.ratingList.get(i);
                System.out.print(player.playerList.get(p1.playerIndex) + " рейтинг: ");
                System.out.println(p1.rating);
            }
        }
    }

    // 9. вывод 10 лучших игроков во всех играх
    public void showBestByAllGame() {
        Playground table = new Playground();
        GameTable p1;
        //проход по таблице пользователей, и создание рейтинга каждого пользователя
        for (int i = 0; i < player.playerList.size(); i++) {
            p1 = new GameTable(0, i, 0);
            table.ratingList.add(p1);

        }
        // проход по таблице рейтингов
        for (int i = 0; i < ratings.ratingList.size(); i++) {
            p1 = ratings.ratingList.get(i);
            int user = p1.playerIndex;
            int ratingOld = table.ratingList.get(user).rating;
            int ratingNew = ratingOld + p1.rating;
            table.ratingList.set(user, new GameTable(user, user, ratingNew));
        }
        Collections.sort(table.ratingList);//сортировка
        Collections.reverse(table.ratingList);//меняется парядок от максимального к минимальному
        System.out.println("Общий рейтинг игроков на игровой площадке: ");
        for (int i = 0; i < 10; i++) {
            if (i < table.ratingList.size()) {
                p1 = table.ratingList.get(i);
                System.out.print(player.playerList.get(p1.playerIndex) + " рейтинг: ");
                System.out.println(p1.rating);
            }

        }
    }

    // 10. вывод меню
    public void showMenu() {
        Menu.showMenu();
    }
}

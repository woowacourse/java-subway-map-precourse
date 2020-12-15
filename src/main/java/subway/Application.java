package subway;

import subway.controller.MainMenu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        MainMenu mainMenu = new MainMenu(scanner);

        mainMenu.initPrimaryStation(new String[]{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"});
        mainMenu.initPrimaryLine("2호선", new String[]{"교대역", "강남역", "역삼역"});
        mainMenu.initPrimaryLine("3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"});
        mainMenu.initPrimaryLine("신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"});

        mainMenu.run();
    }
}
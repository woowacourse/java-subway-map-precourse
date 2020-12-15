package subway.view;


import subway.menu.MainMenu;

import java.util.List;

public class OutputView {
    public static final String DOT_AND_BLANK = ". ";
    public static final String MAIN_MENU_TITLE = "## 메인 화면";

    public static void showMainMenu(){
        print(convertMainMenuToStringForConsoleOutput());
    }

    public static String convertMainMenuToStringForConsoleOutput(){
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        StringBuilder menu = new StringBuilder(MAIN_MENU_TITLE + System.lineSeparator());
        for (int i = 0; i < commands.size(); i++) {
            String menuLine = commands.get(i)
                    .concat(DOT_AND_BLANK)
                    .concat(titles.get(i))
                    .concat(System.lineSeparator());
            menu.append(menuLine);
        }
        return menu.toString();
    }

    public static void print(String message){
        System.out.print(message);
    }
    public static void println(String message){
        System.out.println(message);
    }
}

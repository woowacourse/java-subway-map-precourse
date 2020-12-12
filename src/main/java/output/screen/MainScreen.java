package output.screen;

import output.Menu;

public class MainScreen implements Screen{
    public final static String MAIN_SCREEN_MESSAGE = "메인 화면";
    public final static String SUBWAY_MAP = "4. 지하철 노선도 출력";
    public final static String QUIT = "Q. 종료";
    public final static int SET_NUMBER = 1;

    @Override
    public void visualize() {
        System.out.println(HEAD + MAIN_SCREEN_MESSAGE);
        for (Menu menu : Menu.values()) {
            System.out.println((menu.ordinal() + SET_NUMBER) + POINT + SPACE + menu.getMenuName() + SPACE + MANAGEMENT);
        }
        System.out.println(SUBWAY_MAP);
        System.out.println(QUIT + ENTER);
    }

    @Override
    public void logic() {

    }
}

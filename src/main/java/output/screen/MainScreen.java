package output.screen;

import exception.NoneFunctionException;
import input.Input;
import output.Menu;

public class MainScreen implements Screen{
    public final static String MAIN_SCREEN_MESSAGE = "메인 화면";
    public final static int SET_NUMBER = 1;
    private Menu selectedMenu = null;
    public final static String[] BUTTON = {"1", "2", "3", "4", "Q"};

    @Override
    public void visualize() {
        System.out.println(HEAD + MAIN_SCREEN_MESSAGE);
        for (Menu menu : Menu.values()) {
            printMenuElement(menu);
        }
    }

    @Override
    public void logic(Input input) {
        System.out.println(HEAD + SELECT_FUNCTION);
        String answer = input.inputFunction(); //입력.
        System.out.println();
        setSelectedScreen(answer);
    }

    private void setSelectedScreen(String answer){
        selectedMenu = null;
        if(answer.equals("1"))
            selectedMenu = Menu.STATION;
        if(answer.equals("2"))
            selectedMenu = Menu.LINE;
        if(answer.equals("3"))
            selectedMenu = Menu.ROUTE;
        if(answer.equals("4"))
            selectedMenu = Menu.SUBWAY_MAP;
        if(answer.equals("Q"))
            selectedMenu = Menu.QUIT;
        checkFunctionButton(answer);
    }
    public Menu getSelectedScreen(){
        return selectedMenu;
    }

    private void printMenuElement(Menu menu){
        if(menu.ordinal() == 3)
            System.out.println((menu.ordinal() + SET_NUMBER) + POINT + SPACE + menu.getMenuName());
        if(menu.ordinal() == 4)
            System.out.println("Q" + POINT + SPACE + menu.getMenuName());
        if(menu.ordinal() < 3)
        System.out.println((menu.ordinal() + SET_NUMBER) + POINT + SPACE + menu.getMenuName() + SPACE + MANAGEMENT);
    }

    private static boolean checkFunctionButton(String answer) {
        if(answer.equals(BUTTON[0]) || answer.equals(BUTTON[1]) || answer.equals(BUTTON[2]) || answer.equals(BUTTON[3]) || answer.equals(BUTTON[4]))
            return true;
        throw new NoneFunctionException();
    }
}

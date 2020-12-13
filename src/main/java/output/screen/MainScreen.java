package output.screen;

import exception.NoneFunctionException;
import input.Input;
import output.Menu;

public class MainScreen implements Screen{
    public final static String MAIN_SCREEN_MESSAGE = "메인 화면";
    public final static int SET_NUMBER = 1;
    private Menu selectedMenu = null;

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
        if(answer.equals("1")){
            selectedMenu = Menu.STATION;
        }else if(answer.equals("2")){
            selectedMenu = Menu.LINE;
        }else if(answer.equals("3")){
            selectedMenu = Menu.ROUTE;
        }else if(answer.equals("4")){
            selectedMenu = Menu.SUBWAY_MAP;
        }else if(answer.equals("Q")){
            selectedMenu = Menu.QUIT;
        }else if(selectedMenu == null) {
            throw new NoneFunctionException(); // 선택할 수 없는 기능
        }
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
}

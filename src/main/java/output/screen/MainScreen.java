package output.screen;

import input.Input;
import output.Menu;

public class MainScreen implements Screen{
    public final static String MAIN_SCREEN_MESSAGE = "메인 화면";
    public final static int SET_NUMBER = 1;
    private Menu selectedMenu;

    @Override
    public void visualize() {
        System.out.println(HEAD + MAIN_SCREEN_MESSAGE);
        for (Menu menu : Menu.values()) {
            System.out.println((menu.ordinal() + SET_NUMBER) + POINT + SPACE + menu.getMenuName() + SPACE + MANAGEMENT);
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
        }
    }
    public Menu getSelectedScreen(){
        return selectedMenu;
    }
}

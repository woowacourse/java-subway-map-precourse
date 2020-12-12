package output.screen;

import input.Input;
import management.LineManagement;
import management.RouteManagement;
import output.Function;
import output.Menu;
import management.StationManagement;

import java.util.List;


public class ManagementScreen implements Screen {
    public final static String MANAGEMENT_SCREEN_MESSAGE = "관리 화면";
    public final static String BACK = "B. 돌아가기";
    private Menu selectedMenu;
    private Input input;

    public ManagementScreen(Menu selectedMenu) {
        this.selectedMenu = selectedMenu;
    }

    @Override
    public void visualize() {
        List<Function> menuFunction = selectedMenu.getMenuElement();
        System.out.println(HEAD + selectedMenu.getMenuName() + SPACE + MANAGEMENT_SCREEN_MESSAGE);
        for (int i = 1; i <= menuFunction.size(); i++) {
            System.out.println(i + POINT + SPACE + selectedMenu.getMenuName() + SPACE + menuFunction.get(i - 1).getName());
        }
        System.out.println(BACK + ENTER);
    }

    @Override
    public void logic(Input input) {
        this.input = input;
        System.out.println(HEAD + SELECT_FUNCTION);
        String answer = input.inputFunction(); //입력.
        System.out.println();
        runFunction(answer);
    }

    private void runFunction(String answer){
        if(selectedMenu == Menu.STATION){
            StationManagement.stationManagement(answer, input);
        }
        if(selectedMenu == Menu.LINE){
            LineManagement.lineManagement(answer, input);
        }
        if(selectedMenu == Menu.ROUTE){
            RouteManagement.RouteManagement(answer, input);
        }
    }
}

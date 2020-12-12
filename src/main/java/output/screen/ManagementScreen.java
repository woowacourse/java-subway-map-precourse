package output.screen;

import output.Function;
import output.Menu;

import java.util.List;


public class ManagementScreen implements Screen {
    public final static String MANAGEMENT_SCREEN_MESSAGE = "관리 화면";
    public final static String BACK = "B. 돌아가기";
    private Menu selectedMenu;

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
    public void logic() {

    }
}

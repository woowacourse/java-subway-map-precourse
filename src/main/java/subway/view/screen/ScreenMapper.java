package subway.view.screen;

public class ScreenMapper {
    private ScreenMapper() {

    }

    public static final void mapping(int command) {
        final Element element = MainScreen.MAIN_MENU_ELEMENT.get(command - 1);
        if (element == Element.MAP) {
            ScreenStack.pushScreen(new PrintMapScreen());
            return;
        }
        if (element == Element.PATH) {
            ScreenStack.pushScreen(new PathManageScreen());
            return;
        }
        ScreenStack.pushScreen(new ManageScreen(element.toString()));
    }
}

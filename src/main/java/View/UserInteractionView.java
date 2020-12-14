package View;

import Enum.SubMenuType;

public class UserInteractionView {
    private static final String MANUAL = "";

    public UserInteractionView() {

    }

    public String getManual() {
        return MANUAL;
    }

    /*public SubMenuType execute(char letter) {
        SubMenuType subMenu = SubMenuType.fromLetter(letter);
        return subMenu;
    }*/
}

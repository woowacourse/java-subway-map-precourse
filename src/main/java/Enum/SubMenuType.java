package Enum;

import subway.controller.SubwayController;

public enum SubMenu {

    STATION('1'), LINE('2'), INTERVAL('3'), PRINT_SUBWAY_MAP('4'), EXIT('Q');

    private SubMenu(final char choice) {
        this.choice = choice;
    }

    private final char choice;

    public char getChoice() {
        return choice;
    }

}

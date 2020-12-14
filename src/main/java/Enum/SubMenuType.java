package Enum;

public enum SubMenuType {

    STATION('1'), LINE('2'), INTERVAL('3'), PRINT_SUBWAY_MAP('4'), EXIT('Q');

    SubMenuType(final char choice) {
        this.choice = choice;
    }

    private final char choice;
    private static SubMenuType[] allMenus = values();

    public char getChoice() {
        return choice;
    }

    public static SubMenuType fromLetter(char letter) {
        return allMenus[letter];
    }

    public boolean isExit() {
        return this == SubMenuType.EXIT;
    }
}

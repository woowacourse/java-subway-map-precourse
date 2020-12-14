package Enum;

public enum SubMenuType {

    STATION('1'), LINE('2'), INTERVAL('3'), EXIT('Q'), MAIN('0');

    SubMenuType(final char choice) {
        this.choice = choice;
    }

    private final char choice;
    private static SubMenuType[] allMenus = values();

    public char getChoice() {
        return choice;
    }

    public static SubMenuType fromCommand(char command) {
        for(SubMenuType subMenuType: allMenus) {
            if(subMenuType.choice == command) {
                return subMenuType;
            }
        }
        return null;
    }

    public boolean isExit() {
        return this == SubMenuType.EXIT;
    }

    public boolean isMain() {
        return this == SubMenuType.MAIN;
    }

}

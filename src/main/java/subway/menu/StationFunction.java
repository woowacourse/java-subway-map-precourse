package subway.menu;

public enum StationFunction {
    ADD('1'), DELETE('2'), INQUIRY('3'), GET_BACK('B');

    final private char menu;

    StationFunction(char menu) {
        this.menu = menu;
    }

    public char getMenu() {
        return menu;
    }

    public boolean matchMenu(char menu) {
        if (this.menu == menu) {
            return true;
        }
        return false;
    }

}
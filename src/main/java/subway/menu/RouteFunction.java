package subway.menu;

public enum RouteFunction {
    ADD('1'), DELETE('2'), GET_BACK('B');

    final private char menu;

    RouteFunction(char menu) {
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
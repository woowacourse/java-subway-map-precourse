package subway.menu;

public enum MainFunction {
    STATION_MANAGEMENT('1'), LINE_MANAGEMENT('2'), SECTION_MANAGEMENT('3'), SUBWAY_MAP(
        '4'), QUIT('Q');

    final private char menu;

    MainFunction(char menu) {
        this.menu = menu;
    }

    public char getMenu() {
        return menu;
    }
}

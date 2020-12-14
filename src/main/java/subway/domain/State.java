package subway.domain;

public enum State {
    QUIT(-1),
    MAIN_SCENE(0),
    STATION_SCENE(1),
    LINE_SCENE(2),
    SECTION_SCENE(3),
    MAP_SCENE(4),
    STATION_ADD(11),
    STATION_REMOVE(12),
    STATION_INQUIRY(13),
    LINE_ADD(21),
    LINE_REMOVE(22),
    LINE_INQUIRY(23),
    SECTION_ADD(31),
    SECTION_REMOVE(32),
    SECTION_INQUIRY(33);

    private int index;

    State(int index) {
        this.index = index;
    }
}

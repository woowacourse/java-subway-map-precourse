package subway.view.screen;

public enum Element {
    STATION("역"),
    LINE("노선"),
    PATH("구간"),
    MAP("지하철 노선도");

    private final String element;

    Element(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return element;
    }
}

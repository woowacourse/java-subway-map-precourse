package subway.initialization;

import subway.domain.Line;

public enum InitLine {
    LINE_2(new Line("2호선")),
    LINE_3(new Line("3호선")),
    LINE_SINBUNDANG(new Line("신분당선"));

    private final Line lineName;

    InitLine(Line lineName) {
        this.lineName = lineName;
    }

    public Line getLineName() {
        return lineName;
    }

    @Override
    public String toString() {
        return lineName.getName();
    }
}

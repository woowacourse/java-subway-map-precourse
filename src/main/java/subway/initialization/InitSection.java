package subway.initialization;

import static subway.initialization.InitLine.*;
import static subway.initialization.InitStation.*;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public enum InitSection {

    LINE_2_SECTION(LINE_2.getLineName(),
            List.of(KYODAE.getStationName(),
                    GANGNAM.getStationName(),
                    YEOKSAM.getStationName())),
    LINE_3_SECTION(LINE_3.getLineName(),
            List.of(KYODAE.getStationName(),
                    NAMBU_TERMINAL.getStationName(),
                    YANGJAE.getStationName(),
                    YANGJAE_FOREST.getStationName())),
    LINE_SINBUNDANG_SECTION(LINE_SINBUNDANG.getLineName(),
            List.of(GANGNAM.getStationName(),
                    YANGJAE.getStationName(),
                    YANGJAE_FOREST.getStationName()));

    private final Line initLine;
    private final List<Station> initStation;

    InitSection(Line initLine, List<Station> initStation) {
        this.initLine = initLine;
        this.initStation = initStation;
    }

    public Line getInitLine() {
        return initLine;
    }

    public List<Station> getInitStation() {
        return initStation;
    }
}

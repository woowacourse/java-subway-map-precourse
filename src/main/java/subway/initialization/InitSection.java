package subway.initialization;

import static subway.initialization.InitStation.GANGNAM;
import static subway.initialization.InitStation.KYODAE;
import static subway.initialization.InitStation.NAMBU_TERMINAL;
import static subway.initialization.InitStation.YANGJAE;
import static subway.initialization.InitStation.YANGJAE_FOREST;
import static subway.initialization.InitStation.YEOKSAM;

import java.util.List;
import subway.domain.Station;

public enum InitSection {

    LINE_2_SECTION(List.of(KYODAE.getStationName(),
                    GANGNAM.getStationName(),
                    YEOKSAM.getStationName())),
    LINE_3_SECTION(List.of(KYODAE.getStationName(),
                    NAMBU_TERMINAL.getStationName(),
                    YANGJAE.getStationName(),
                    YANGJAE_FOREST.getStationName())),
    LINE_SINBUNDANG_SECTION(List.of(GANGNAM.getStationName(),
                    YANGJAE.getStationName(),
                    YANGJAE_FOREST.getStationName()));

    private final List<Station> initStation;

    InitSection(List<Station> initStation) {
        this.initStation = initStation;
    }

    public List<Station> getInitStation() {
        return initStation;
    }
}

package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum InitialSections {
    SECTION_2(InitialLines.LINE_2, Arrays.asList(
            InitialStations.KYODAE, InitialStations.GANGNAM, InitialStations.YEOKSAM)),
    SECTION_3(InitialLines.LINE_3, Arrays.asList(
            InitialStations.KYODAE, InitialStations.NAMBU_TERMINAL, InitialStations.YANGJAE
            , InitialStations.MAEBONG)),
    SECTION_SINBUNDANG(InitialLines.LINE_SINBUNDANG, Arrays.asList(
            InitialStations.GANGNAM, InitialStations.YANGJAE, InitialStations.YANGJAE_SIMIN_SOUP));

    private InitialLines line;
    private List<InitialStations> stations;

    InitialSections(InitialLines line, List<InitialStations> stations) {
        this.line = line;
        this.stations = stations;
    }

    public InitialLines getLine() {
        return line;
    }

    public List<InitialStations> getStations() {
        return stations;
    }
}

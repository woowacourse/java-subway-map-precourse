package subway.setup;

import java.util.Arrays;
import java.util.List;
import subway.domain.Station;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/12
 */
public class SetStation {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NAMBU_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    static final Station gyodae = new Station(GYODAE);
    static final Station gangNam = new Station(GANGNAM);
    static final Station yeoksan = new Station(YEOKSAM);
    static final Station nambuTerminal = new Station(NAMBU_TERMINAL);
    static final Station yangjae = new Station(YANGJAE);
    static final Station yangjaeCitizenForest = new Station(YANGJAE_CITIZEN_FOREST);
    static final Station maebong = new Station(MAEBONG);

    private static final List<Station> setUpStation = Arrays.asList(
            gangNam, gyodae, yeoksan, nambuTerminal, yangjae, yangjaeCitizenForest, maebong);

    private SetStation() {
    }

    static void setUpStation() {
        setUpStation.forEach(StationRepository::addStation);
    }
}

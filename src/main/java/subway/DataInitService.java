package subway;

import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.StationService;
import subway.domain.station.dto.StationSaveReqDto;

public class DataInitService {
    private static final String STATION_GYODAE = "교대역";
    private static final String STATION_GANGNAM = "강남역";
    private static final String STATION_YEOKSAM = "역삼역";
    private static final String STATION_SOUTH_TERMINAL = "남부터미널역";
    private static final String STATION_YANGJAE = "양재역";
    private static final String STATION_CITIZEN_FOREST = "양재시민의숲역";
    private static final String STATION_MAEBONG = "매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final int THIRD = 3;

    private final StationService stationService;
    private final SectionService sectionService;

    public DataInitService(StationManageConfig stationManageConfig) {
        this.stationService = stationManageConfig.stationService();
        this.sectionService = stationManageConfig.sectionService();
    }

    public void init() {
        saveStation();
        saveSection();
    }

    private void saveSection() {
        sectionService.saveSection(new SectionSaveReqDto(LINE_TWO, STATION_GYODAE, STATION_YEOKSAM));
        sectionService.addStation(LINE_TWO, STATION_GANGNAM, SECOND);

        sectionService.saveSection(new SectionSaveReqDto(LINE_THREE, STATION_GYODAE, STATION_MAEBONG));
        sectionService.addStation(LINE_THREE, STATION_SOUTH_TERMINAL, SECOND);
        sectionService.addStation(LINE_THREE, STATION_YANGJAE, THIRD);

        sectionService.saveSection(new SectionSaveReqDto(LINE_SINBUNDANG, STATION_GANGNAM, STATION_CITIZEN_FOREST));
        sectionService.addStation(LINE_SINBUNDANG, STATION_YANGJAE, SECOND);
    }

    private void saveStation() {
        String[] stationNames = {STATION_GYODAE, STATION_GANGNAM, STATION_YEOKSAM, STATION_SOUTH_TERMINAL, STATION_YANGJAE, STATION_CITIZEN_FOREST, STATION_MAEBONG};
        for (String stationName : stationNames) {
            stationService.saveStation(new StationSaveReqDto(stationName));
        }
    }
}

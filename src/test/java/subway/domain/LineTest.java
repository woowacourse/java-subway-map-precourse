package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static subway.message.ErrorMessage.LINE_INVALID_NAME_LENGTH;
import static subway.message.ErrorMessage.LINE_STATIONS_ITEM_DUPLICATED;
import static subway.message.ErrorMessage.LINE_STATIONS_TOO_SMALL;
import static subway.message.ErrorMessage.LINE_STATION_ALREADY_EXIST;
import static subway.message.ErrorMessage.LINE_STATION_DOES_NOT_EXIST;
import static subway.message.ErrorMessage.LINE_STATION_INDEX_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LineTest {

    private static final String stationName1 = "강남역";
    private static final String stationName2 = "역삼역";
    private static final String validLineName = "2호선";
    private static final Station station1 = new Station(stationName1);
    private static final Station station2 = new Station(stationName2);
    private static List<Station> initialStations;
    private static Line line;
    private final String stationName3 = "매봉역";
    private final String invalidLineName = "a";
    private final Station station3 = new Station(stationName3);

    @BeforeAll
    static void init() {
        initialStations = new ArrayList<>();
        initialStations.add(station1);
        initialStations.add(station2);
        line = new Line(validLineName, initialStations);
    }

    @Test
    void line_InvalidNameLength_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final Line line = new Line(invalidLineName, initialStations);
        }).withMessage(LINE_INVALID_NAME_LENGTH.toString());
    }

    @Test
    void line_InitialStationsDuplicate_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Station> invalidStations = new ArrayList<>();
            invalidStations.add(station1);
            invalidStations.add(station1);
            final Line line = new Line(validLineName, invalidStations);
        }).withMessage(LINE_STATIONS_ITEM_DUPLICATED.toString());
    }

    @Test
    void line_SmallInitialStationsSize_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Station> invalidStations = new ArrayList<>();
            invalidStations.add(new Station(stationName1));
            final Line line = new Line(validLineName, invalidStations);
        }).withMessage(LINE_STATIONS_TOO_SMALL.toString());
    }

    @Test
    void getName_SameName_Equal() {
        assertThat(line.getName()).isEqualTo(validLineName);
    }

    @Test
    void getName_DifferentName_NotEqual() {
        assertThat(line.getName()).isNotEqualTo(invalidLineName);
    }

    @Test
    void getStations_SameStation_Equal() {
        final List<Station> stationList = line.getStations();
        assertThat(stationList.get(0)).isEqualTo(station1);
        assertThat(stationList.get(1)).isEqualTo(station2);
    }

    @Test
    void getStations_DifferentStation_NotEqual() {
        final List<Station> stationList = line.getStations();
        assertThat(stationList.get(0)).isNotEqualTo(station2);
        assertThat(stationList.get(1)).isNotEqualTo(station3);
    }

    @Test
    void addStation_StationAlreadyExist_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            line.addStation(0, station1)
        ).withMessage(LINE_STATION_ALREADY_EXIST.toString());
    }

    @Test
    void addStation_IndexOutOfRange_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            line.addStation(-1, station3)
        ).withMessage(LINE_STATION_INDEX_OUT_OF_RANGE.toString());
        assertThatIllegalArgumentException().isThrownBy(() ->
            line.addStation(line.getStations().size() + 1, station3)
        ).withMessage(LINE_STATION_INDEX_OUT_OF_RANGE.toString());
    }

    @Test
    void addStation_ValidFormat_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() -> {
            final Line tempLine = new Line(validLineName, initialStations);
            tempLine.addStation(0, station3);
        });
        assertThatNoException().isThrownBy(() -> {
            final Line tempLine = new Line(validLineName, initialStations);
            tempLine.addStation(tempLine.getStations().size(), station3);
        });
    }

    @Test
    void removeStation_StationNotExist_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            line.removeStation(station3)
        ).withMessage(LINE_STATION_DOES_NOT_EXIST.toString());
    }

    @Test
    void removeStation_TooSmallStationListSize_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            line.removeStation(station1)
        ).withMessage(LINE_STATIONS_TOO_SMALL.toString());
    }

    @Test
    void removeStation_ValidFormat_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() -> {
            final List<Station> stations = new ArrayList<>();
            stations.add(new Station(stationName1));
            stations.add(new Station(stationName2));
            stations.add(station3);
            final Line tempLine = new Line(validLineName, stations);
            tempLine.removeStation(station3);
        });
    }
}

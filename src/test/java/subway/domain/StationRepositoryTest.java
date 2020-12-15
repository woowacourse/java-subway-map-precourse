package subway.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.deleteStationByName;
import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_ALREADY_EXIST;
import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_DOES_NOT_EXIST;
import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_HAS_PARENT;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    private static final String stationName1 = "강남역";
    private static final String stationName2 = "역삼역";
    private static final Station station1 = new Station(stationName1);
    private static final Station station2 = new Station(stationName2);

    @BeforeAll
    static void init() {
        addStation(station1);
    }

    @Test
    void addStation_ItemDuplicate_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            addStation(new Station(stationName1))
        ).withMessage(STATION_REPOSITORY_STATION_ALREADY_EXIST.toString());
    }

    @Test
    void deleteStationByName_ItemDoesNotExist_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            deleteStationByName(stationName2)
        ).withMessage(STATION_REPOSITORY_STATION_DOES_NOT_EXIST.toString());
    }

    @Test
    void deleteStationByName_ItemHasParent_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Station> stations = new LinkedList<>();
            stations.add(station1);
            stations.add(station2);
            final Line line = new Line("2호선", stations);
            deleteStationByName(stationName1);
        }).withMessage(STATION_REPOSITORY_STATION_HAS_PARENT.toString());
    }
}

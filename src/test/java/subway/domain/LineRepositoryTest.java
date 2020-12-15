package subway.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.deleteLineByName;
import static subway.message.ErrorMessage.LINE_REPOSITORY_LINE_ALREADY_EXIST;
import static subway.message.ErrorMessage.LINE_REPOSITORY_LINE_DOES_NOT_EXIST;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    private static final String stationName1 = "강남역";
    private static final String stationName2 = "역삼역";
    private static final Station station1 = new Station(stationName1);
    private static final Station station2 = new Station(stationName2);
    private static final String lineName1 = "2호선";
    private static final String lineName2 = "3호선";
    private static Line line1;

    @BeforeAll
    static void init() {
        final List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        line1 = new Line(lineName1, stations);
        addLine(line1);
    }

    @Test
    void addLine_ItemDuplicate_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> addLine(line1))
            .withMessage(LINE_REPOSITORY_LINE_ALREADY_EXIST.toString());
    }

    @Test
    void deleteLineByName_ItemDoesNotExist_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> deleteLineByName(lineName2))
            .withMessage(LINE_REPOSITORY_LINE_DOES_NOT_EXIST.toString());
    }
}

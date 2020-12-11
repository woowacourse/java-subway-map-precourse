package subway.view;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import subway.SubwayManager;
import subway.domain.StationRepository;

class StationManagementViewTest {
    private final PrintStream printStream = System.out;
    private static final String REGISTER_STATION_INPUT =
            "1\n1\n강남역\n1\n1\n잠실역1\n1\n강남역\n1\n1\n잠\n1\n가나다라마바사아자차카타파하역\nB\nQ\n";
    private static final int REGESTER_STATION_OUTPUT = 3;

    @Test
    void registerStaionTest() {
        Scanner scanner = new Scanner(REGISTER_STATION_INPUT);
        SubwayManager subwayManager = new SubwayManager(scanner, printStream);
        subwayManager.run();
        assertEquals(REGESTER_STATION_OUTPUT, StationRepository.stations().size());
    }

}

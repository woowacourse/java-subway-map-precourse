package subway;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import subway.domain.StationRepository;
import subway.exception.StationExceptionManager;
import subway.io.Request;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class StationTest {
    private static final String TEST_STATION_NAME = "테스트역";
    private static final String REGISTER_STATION_INPUT =
            "잠실역\n역\n강남역\n양재역\n답십리역\n강남역역역역역역역역역역역역역역역";
    private static final boolean[] REGISTER_STATION_OUTPUTS =
            {true, false, false, false, true, true};
    private static final String REMOVE_STATION_INPUT = "역\n왕십리역역\n테스트역\n테스트역\n강남역역\n양재역\n";
    private static final boolean[] REMOVE_STATION_OUTPUTS =
            {false, false, true, false, false, false};

    private final PrintStream printStream = System.out;

    @BeforeEach
    void before() {
        InitialSetup.apply();
    }

    @AfterEach
    void after() {
        StationRepository.deleteAllStation();
    }

    @Test
    void registerStationTest() {
        Scanner scanner = new Scanner(REGISTER_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            boolean result = request.applyInput(StationExceptionManager::checkValidStationRegister,
                    StationRepository::addStation);
            assertEquals(REGISTER_STATION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void removeStationTest() {
        Scanner scanner = new Scanner(REMOVE_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        StationRepository.addStation(TEST_STATION_NAME);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            boolean result = request.applyInput(StationExceptionManager::checkValidStationRemoval,
                    StationRepository::deleteStation);
            assertEquals(REMOVE_STATION_OUTPUTS[indexOutput++], result);
        }
    }
}

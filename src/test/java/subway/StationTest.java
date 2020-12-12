package subway;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import subway.domain.StationRepository;
import subway.io.ExceptionManager;
import subway.io.Request;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class StationTest {
    private final PrintStream printStream = System.out;
    private static final String REGISTER_STATION_INPUT =
            "잠실역\n역\n잠실역\n왕십리역\n답십리역\n강남역역역역역역역역역역역역역역역";
    private static final String REMOVE_STATION_INPUT = "역\n왕십리역역\n잠실역\n잠실역\n강남역역";
    private static final String REGISTER_LINE_INPUT = "1호선\n선\n123456789선\n";
    private static final String TERMINATING_STATION_INPUT = "왕십리역\n답십리역\n역\n잠실역\n";
    private static final String[][] TERMINATING_STATION_PAIR_INPUTS =
            {{"왕십리역", "답십리역"}, {"왕십리역", "왕십리역"}};
    private static final boolean[] REGISTER_STATION_OUTPUTS =
            {true, false, false, true, true, true};
    private static final boolean[] REMOVE_STATION_OUTPUTS = {false, false, true, false, false};
    private static final String[] REGISTER_LINE_OUTPUTS = {"1호선", null, "123456789선"};
    private static final String[] TERMINATING_STATION_OUTPUTS = {"왕십리역", "답십리역", null, null};
    private static final boolean[] TERMINATING_STATION_PAIR_OUTPUTS = {true, false};

    @Test
    @Order(1)
    void registerStationTest() {
        Scanner scanner = new Scanner(REGISTER_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            boolean result = request.applyInput(ExceptionManager::checkValidStationRegister,
                    StationRepository::addStation);
            assertEquals(REGISTER_STATION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    @Order(2)
    void removeStationTest() {
        Scanner scanner = new Scanner(REMOVE_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            boolean result = request.applyInput(ExceptionManager::checkValidStationRemoval,
                    StationRepository::deleteStation);
            assertEquals(REMOVE_STATION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    @Order(3)
    void registerLineTest() {
        Scanner scanner = new Scanner(REGISTER_LINE_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(REGISTER_LINE_OUTPUTS[indexOutput++],
                    request.requestInput(ExceptionManager::checkValidLineRegister));
        }
    }

    @Test
    @Order(4)
    void terminatingStationTest() {
        Scanner scanner = new Scanner(TERMINATING_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(TERMINATING_STATION_OUTPUTS[indexOutput++],
                    request.requestInput(ExceptionManager::checkValidTerminatingStation));
        }
    }

    @Test
    @Order(5)
    void terminatingStationPairTest() {
        Scanner scanner = new Scanner("");
        Request request = new Request(scanner, printStream);
        for (int testIndex = 0; testIndex < TERMINATING_STATION_PAIR_INPUTS.length; testIndex++) {
            String upboundStation = TERMINATING_STATION_PAIR_INPUTS[testIndex][0];
            String downboundStation = TERMINATING_STATION_PAIR_INPUTS[testIndex][1];
            assertEquals(TERMINATING_STATION_PAIR_OUTPUTS[testIndex],
                    request.isValidTerminatingStationPair(upboundStation, downboundStation));
        }
    }
}

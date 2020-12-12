package subway.io;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class RequestTest {
    private final PrintStream printStream = System.out;
    private static final String REQUEST_STATION_REGISTER_INPUT =
            "잠실역\n역\n잠실역\n왕십리역\n답십리역\n강남역역역역역역역역역역역역역역역";
    private static final String REQUEST_STATION_REMOVAL_INPUT = "역\n왕십리역역\n잠실역\n잠실역\n강남역역";
    private static final String REQUEST_LINE_REGISTER_INPUT = "1호선\n선\n123456789선\n";
    private static final String REQUEST_TERMINATING_STATION_INPUT = "왕십리역\n답십리역\n역\n잠실역\n";
    private static final String[][] IS_VALID_TERMINATING_STATION_PAIR_INPUTS =
            {{"왕십리역", "답십리역"}, {"왕십리역", "왕십리역"}};
    private static final boolean[] REQUEST_STATION_REGISTER_OUTPUTS =
            {true, false, false, true, true, true};
    private static final boolean[] REQUEST_STATION_REMOVAL_OUTPUTS =
            {false, false, true, false, false};
    private static final String[] REQUEST_LINE_REGISTER_OUTPUTS = {"1호선", null, "123456789선"};
    private static final String[] REQUEST_TERMINATING_STATION_OUTPUTS =
            {"왕십리역", "답십리역", null, null};
    private static final boolean[] IS_VALID_TERMINATING_STATOIN_PAIR_OUTPUTS = {true, false};

    @Test
    @Order(1)
    void requestStationRegisterTest() {
        Scanner scanner = new Scanner(REQUEST_STATION_REGISTER_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(REQUEST_STATION_REGISTER_OUTPUTS[indexOutput++],
                    request.requestStationRegister());
        }
    }

    @Test
    @Order(2)
    void requestStationRemovalTest() {
        Scanner scanner = new Scanner(REQUEST_STATION_REMOVAL_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(REQUEST_STATION_REMOVAL_OUTPUTS[indexOutput++],
                    request.requestStationRemoval());
        }
    }

    @Test
    @Order(3)
    void requestLineRegisterTest() {
        Scanner scanner = new Scanner(REQUEST_LINE_REGISTER_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(REQUEST_LINE_REGISTER_OUTPUTS[indexOutput++],
                    request.requestLineRegister());
        }
    }

    @Test
    @Order(4)
    void requestTerminatingStationTest() {
        Scanner scanner = new Scanner(REQUEST_TERMINATING_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            assertEquals(REQUEST_TERMINATING_STATION_OUTPUTS[indexOutput++],
                    request.requestTerminatingStation());
        }
    }

    @Test
    @Order(5)
    void isValidTerminatingStationPairTest() {
        Scanner scanner = new Scanner("");
        Request request = new Request(scanner, printStream);
        for (int testIndex =
                0; testIndex < IS_VALID_TERMINATING_STATION_PAIR_INPUTS.length; testIndex++) {
            String upboundStation = IS_VALID_TERMINATING_STATION_PAIR_INPUTS[testIndex][0];
            String downboundStation = IS_VALID_TERMINATING_STATION_PAIR_INPUTS[testIndex][1];
            assertEquals(IS_VALID_TERMINATING_STATOIN_PAIR_OUTPUTS[testIndex],
                    request.isValidTerminatingStationPair(upboundStation, downboundStation));
        }
    }
}

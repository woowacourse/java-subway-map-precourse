package subway;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.io.ExceptionManager;
import subway.io.Request;

class LineTest {
    private static final String REGISTER_LINE_INPUT = "1호선\n선\n123456789선\n2호선\n";
    private static final String[] REGISTER_LINE_OUTPUTS = {"1호선", null, "123456789선", null};
    private static final String TERMINATING_STATION_INPUT = "강남역\n역삼역\n역\n잠실역\n";
    private static final String[] TERMINATING_STATION_OUTPUTS = {"강남역", "역삼역", null, null};
    private static final String[][] TERMINATING_STATION_PAIR_INPUTS =
            {{"강남역", "역삼역"}, {"강남역", "강남역"}};
    private static final boolean[] TERMINATING_STATION_PAIR_OUTPUTS = {true, false};
    private static final String REMOVE_LINE_INPUT = "2호선\n선\n9호선\n";
    private static final boolean[] REMOVE_LINE_OUTPUTS = {true, false, false};

    private final PrintStream printStream = System.out;

    @BeforeEach
    void before() {
        InitialSetup.apply();
    }

    @AfterEach
    void after() {
        LineRepository.deleteAllLine();
    }

    @Test
    void registerLineTest() {
        Scanner scanner = new Scanner(REGISTER_LINE_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result = request.requestInput(ExceptionManager::checkValidLineRegister);
            assertEquals(REGISTER_LINE_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void terminatingStationTest() {
        Scanner scanner = new Scanner(TERMINATING_STATION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result = request.requestInput(ExceptionManager::checkValidTerminatingStation);
            assertEquals(TERMINATING_STATION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void terminatingStationPairTest() {
        Scanner scanner = new Scanner("");
        Request request = new Request(scanner, printStream);
        for (int testIndex = 0; testIndex < TERMINATING_STATION_PAIR_INPUTS.length; testIndex++) {
            String upboundStation = TERMINATING_STATION_PAIR_INPUTS[testIndex][0];
            String downboundStation = TERMINATING_STATION_PAIR_INPUTS[testIndex][1];
            boolean result =
                    request.isValidTerminatingStationPair(upboundStation, downboundStation);
            assertEquals(TERMINATING_STATION_PAIR_OUTPUTS[testIndex], result);
        }
    }

    @Test
    void removeLineTest() {
        Scanner scanner = new Scanner(REMOVE_LINE_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            boolean result = request.applyInput(ExceptionManager::checkValidLineRemoval,
                    LineRepository::deleteLine);
            assertEquals(REMOVE_LINE_OUTPUTS[indexOutput++], result);
        }
    }

}

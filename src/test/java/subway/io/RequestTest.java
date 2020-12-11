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
            "ab\nab\na\nabc\nabbbbbbbbbbbbbbbbbbb";
    private static final String REQUEST_STATION_REMOVAL_INPUT = "c\nabsdfg\nab\nab\nabcd";
    private static final boolean[] REQUEST_STATION_REGISTER_OUTPUTS =
            {true, false, false, true, true};
    private static final boolean[] REQUEST_STATION_REMOVAL_OUTPUTS =
            {false, false, true, false, false};

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
}

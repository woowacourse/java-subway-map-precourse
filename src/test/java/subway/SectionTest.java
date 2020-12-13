package subway;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.io.ExceptionManager;
import subway.io.Request;

class SectionTest {
    private static final String TEST_LINE_OF_SECTION_NAME = "2호선";
    private static final String TEST_REMOVED_STATION_OF_SECTION = "강남역";
    private static final String REGISTER_STATION_OF_SECTION_INPUT =
            "잠실역\n역\n강남역\n양재역\n답십리역\n강남역역역역역역역역역역역역역역역";
    private static final String[] REGISTER_STATION_OF_SECTION_OUTPUTS =
            {null, null, null, "양재역", null, null};
    private static final String REGISTER_LINE_OF_SECTION_INPUT = "1호선\n선\n123456789선\n2호선\n";
    private static final String[] REGISTER_LINE_OF_SECTION_OUTPUTS = {null, null, null, "2호선"};
    private static final String REGISTER_INDEX_OF_SECTION_INPUT = "a\n0\n1\n98745135141234\n";
    private static final String[] REGISTER_IDNEX_OF_SECTION_OUTPUT = {null, null, "1", null};
    private static final String REMOVE_LINE_OF_SECTION_INPUT = "2호선\n선\n9호선\n3호선";
    private static final String[] REMOVE_LINE_OF_SECTION_OUTPUTS = {null, null, null, "3호선"};
    private static final String REMOVE_STATION_OF_SECTION_INPUT = "역\n없는역\n양재역\n역삼역\n";
    private static final String[] REMOVE_STATION_OF_SECTION_OUTPUTS = {null, null, null, "역삼역"};

    private final PrintStream printStream = System.out;

    @BeforeEach
    void before() {
        InitialSetup.apply();
    }

    @AfterEach
    void after() {
        StationRepository.deleteAllStation();
        LineRepository.deleteAllLine();
    }

    @Test
    void registerLineOfSectionTest() {
        Scanner scanner = new Scanner(REGISTER_LINE_OF_SECTION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result = request.requestInput(ExceptionManager::checkValidLineOfSectionRegister);
            assertEquals(REGISTER_LINE_OF_SECTION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void registerStationOfSectionTest() {
        Scanner scanner = new Scanner(REGISTER_STATION_OF_SECTION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result =
                    request.requestInputInLine(ExceptionManager::checkValidStationOfSectionRegister,
                            TEST_LINE_OF_SECTION_NAME);
            assertEquals(REGISTER_STATION_OF_SECTION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void registerIndexOfSectionTest() {
        Scanner scanner = new Scanner(REGISTER_INDEX_OF_SECTION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result = request.requestInputInLine(
                    ExceptionManager::checkValidIndexOfSectionRegister, TEST_LINE_OF_SECTION_NAME);
            assertEquals(REGISTER_IDNEX_OF_SECTION_OUTPUT[indexOutput++], result);
        }
    }

    @Test
    void removeLineOfSectionTest() {
        Scanner scanner = new Scanner(REMOVE_LINE_OF_SECTION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        SectionRepository.deleteStationInLine(TEST_REMOVED_STATION_OF_SECTION,
                TEST_LINE_OF_SECTION_NAME);
        while (scanner.hasNextLine()) {
            String result = request.requestInput(ExceptionManager::checkValidLineOfSectionRemoval);
            assertEquals(REMOVE_LINE_OF_SECTION_OUTPUTS[indexOutput++], result);
        }
    }

    @Test
    void removeStationOfSectionTest() {
        Scanner scanner = new Scanner(REMOVE_STATION_OF_SECTION_INPUT);
        Request request = new Request(scanner, printStream);
        int indexOutput = 0;
        while (scanner.hasNextLine()) {
            String result = request.requestInputInLine(
                    ExceptionManager::checkValidStationOfSectionRemoval, TEST_LINE_OF_SECTION_NAME);
            assertEquals(REMOVE_STATION_OF_SECTION_OUTPUTS[indexOutput++], result);
        }
    }
}

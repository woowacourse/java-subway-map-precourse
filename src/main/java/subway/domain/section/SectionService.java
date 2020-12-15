package subway.domain.section;

import subway.util.PrefixPrinter;

import java.util.Optional;
import java.util.Scanner;

import static subway.util.InputManager.*;

public class SectionService {
    private static final int SECTION_SIZE_CONDITION = 2;
    private static final int START_LINE_ORDER = 1;
    private static final int END_LINE_ORDER = 2;
    private static final String ADD_SECTION_LINE_INPUT_MESSAGE = "노선을 입력하세요.";
    private static final String ADD_SECTION_STATION_INPUT_MESSAGE = "역이름을 입력하세요.";
    private static final String ENTER_SECTION_STATION_ORDER_INPUT_MESSAGE = "순서를 입력하세요.";
    private static final String DELETE_SECTION_LINE_INPUT_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_SECTION_STATION_INPUT_MESSAGE = "삭제할 구간의 역을 입력하세요.";

    public void addLineStartEndSection(String line, String startStation, String endStation) {
        SectionRepository.addSection(new Section(line, startStation, START_LINE_ORDER));
        SectionRepository.addSection(new Section(line, endStation, END_LINE_ORDER));
    }

    public boolean addSection(Scanner scanner) {
        Optional<String> lineName = enterLineFromUser(scanner, ADD_SECTION_LINE_INPUT_MESSAGE);
        if (lineName.isEmpty()) {
            return false;
        }
        Optional<String> stationName = enterStationFromUser(scanner, ADD_SECTION_STATION_INPUT_MESSAGE);
        if (stationName.isEmpty()) {
            return false;
        }
        int order = enterOrderFromUser(lineName.get(), scanner, ENTER_SECTION_STATION_ORDER_INPUT_MESSAGE);
        if (order == 0) {
            return false;
        }
        SectionRepository.addSection(new Section(lineName.get(), stationName.get(), order));
        PrefixPrinter.printInfo("구간이 등록되었습니다.");
        return true;
    }

    public boolean deleteSection(Scanner scanner) {
        Optional<String> lineName = enterLineFromUser(scanner, DELETE_SECTION_LINE_INPUT_MESSAGE);
        if (lineName.isEmpty()) {
            return false;
        }
        Optional<String> stationName = enterStationFromUser(scanner, DELETE_SECTION_STATION_INPUT_MESSAGE);
        if (stationName.isEmpty()) {
            return false;
        }
        if(!validateSection(lineName.get(), stationName.get())) {
            return false;
        }
        PrefixPrinter.printInfo("구간이 삭제되었습니다.");
        return true;
    }

    private boolean validateSection(String lineName, String stationName) {
        if (SectionRepository.getLineSectionSize(lineName) <= SECTION_SIZE_CONDITION) {
            PrefixPrinter.printError("해당 노선의 역이 2개 이하 이므로 삭제할 수 없습니다.");
            return false;
        }
        if (!SectionRepository.deleteSectionByName(lineName, stationName)) {
            PrefixPrinter.printError("해당 노선에 등록되어 있지 않은 역입니다.");
            return false;
        }
        return true;
    }
}

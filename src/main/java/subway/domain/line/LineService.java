package subway.domain.line;

import subway.domain.section.SectionService;
import subway.util.PrefixPrinter;

import java.util.Optional;
import java.util.Scanner;

import static subway.util.InputManager.*;

public class LineService {
    private static final String ENTER_NEW_LINE_MSG = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_SECTION_START_STATION_MSG = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_SECTION_END_STATION_MSG = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private SectionService sectionService = new SectionService();

    public boolean addLine(Scanner scanner) {
        if(!checkNewLineInput(scanner)) {
            return false;
        }
        PrefixPrinter.printInfo("지하철 노선이 등록되었습니다.");
        return true;
    }

    private boolean checkNewLineInput(Scanner scanner) {
        Optional<String> lineName = enterNewLineFromUser(scanner, ENTER_NEW_LINE_MSG);
        if(lineName.isEmpty()) {
            return false;
        }
        Optional<String> upstreamLastStation = enterStationFromUser(scanner, ENTER_SECTION_START_STATION_MSG);
        if(upstreamLastStation.isEmpty()) {
            return false;
        }
        Optional<String> downstreamLastStation = enterStationFromUser(scanner, ENTER_SECTION_END_STATION_MSG);
        if(downstreamLastStation.isEmpty()) {
            return false;
        }
        addLineInSectionRepo(lineName.get(), upstreamLastStation.get(), downstreamLastStation.get());
        return true;
    }

    private void addLineInSectionRepo(String lineName, String upstreamLastStation, String downstreamLastStation) {
        LineRepository.addLine(new Line(lineName));
        sectionService.addLineStartEndSection(lineName, upstreamLastStation, downstreamLastStation);
    }

    public boolean deleteLine(Scanner scanner) {
        PrefixPrinter.printHeading("삭제할 노선 이름을 입력하세요.");
        String lineName = scanner.next();
        if(!LineRepository.deleteLineByName(lineName)) {
            PrefixPrinter.printError("해당 이름으로 등록된 노선이 없습니다.");
            return false;
        }
        PrefixPrinter.printInfo("지하철 노선이 삭제되었습니다.");
        return true;
    }

    public void getLine() {
        PrefixPrinter.printHeading("노선 목록");
        LineRepository.lines().forEach(line -> PrefixPrinter.printSubway(line.getName()));
    }
}

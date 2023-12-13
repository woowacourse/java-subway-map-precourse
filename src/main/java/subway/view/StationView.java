package subway.view;

import subway.domain.constants.StationCommand;
import subway.view.console.ConsoleReader;
import subway.view.console.ConsoleWriter;

public class StationView {
    private final ConsoleReader consoleReader;

    public StationView(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public StationCommand enterFunction() {
        ConsoleWriter.printlnMessage("## 원하는 기능을 선택하세요.");
        return StationCommand.from(consoleReader.enterMessage());
    }

    public String enterStationName() {
        ConsoleWriter.printlnMessage("## 등록할 역 이름을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public void printFunctions() {
        ConsoleWriter.printlnMessage("## 역 관리 화면");
        ConsoleWriter.printlnMessage("1. 역 등록");
        ConsoleWriter.printlnMessage("2. 역 삭제");
        ConsoleWriter.printlnMessage("3. 역 조회");
        ConsoleWriter.printlnMessage("B. 돌아가기");
    }

    public void printAddResult() {
        ConsoleWriter.printlnMessage("[INFO] 지하철 역이 등록되었습니다.");
    }
}

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
        return StationCommand.from(consoleReader.enterMessage());
    }

    public void enterStationName() {
        return
    }

    public void printFunctions() {
        ConsoleWriter.printlnMessage("## 역 관리 화면");
        ConsoleWriter.printlnMessage("1. 역 등록");
        ConsoleWriter.printlnMessage("2. 역 삭제");
        ConsoleWriter.printlnMessage("3. 역 조회");
        ConsoleWriter.printlnMessage("B. 돌아가기");
    }
}

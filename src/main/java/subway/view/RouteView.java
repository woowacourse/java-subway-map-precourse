package subway.view;

import subway.domain.constants.RouteCommand;
import subway.global.exception.ErrorMessage;
import subway.global.validator.Validator;
import subway.view.console.ConsoleReader;
import subway.view.console.ConsoleWriter;

public class RouteView {
    private final ConsoleReader consoleReader;

    public RouteView(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public void printFunctions() {
        ConsoleWriter.printlnMessage("## 구간 관리 화면");
        ConsoleWriter.printlnMessage("1. 구간 등록");
        ConsoleWriter.printlnMessage("2. 구간 삭제");
        ConsoleWriter.printlnMessage("B. 돌아가기");
    }

    public RouteCommand enterFunction() {
        ConsoleWriter.printlnMessage("## 원하는 기능을 선택하세요.");
        return RouteCommand.from(consoleReader.enterMessage());
    }

    public String enterLineNameToAdd() {
        ConsoleWriter.printlnMessage("## 노선을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public String enterStationNameToAdd() {
        ConsoleWriter.printlnMessage("## 역을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public int enterIndexToAdd() {
        ConsoleWriter.printlnMessage("## 순서를 입력하세요.");
        return Validator.validateNumber(
                consoleReader.enterMessage(),
                ErrorMessage.INVALID_INDEX_ERROR
        );
    }

    public String enterLineNameToDelete() {
        ConsoleWriter.printlnMessage("## 삭제할 구간의 노선을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public String enterStationNameToDelete() {
        ConsoleWriter.printlnMessage("## 삭제할 구간의 역을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public void printAddResult() {
        ConsoleWriter.printlnMessage("[INFO] 구간이 등록되었습니다.");
    }

    public void printDeleteResult() {
        ConsoleWriter.printlnMessage("[INFO] 구간이 삭제되었습니다.");
    }
}

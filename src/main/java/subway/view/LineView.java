package subway.view;

import java.util.List;
import subway.domain.constants.LineCommand;
import subway.view.console.ConsoleReader;
import subway.view.console.ConsoleWriter;

public class LineView {
    private final ConsoleReader consoleReader;

    public LineView(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public LineCommand enterFunction() {
        ConsoleWriter.printlnMessage("## 원하는 기능을 선택하세요.");
        return LineCommand.from(consoleReader.enterMessage());
    }

    public String enterLineNameToAdd() {
        ConsoleWriter.printlnMessage("## 등록할 노선 이름을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public String enterLineNameToDelete() {
        ConsoleWriter.printlnMessage("## 삭제할 노선 이름을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public void printFunctions() {
        ConsoleWriter.printlnMessage("## 노선 관리 화면");
        ConsoleWriter.printlnMessage("1. 노선 등록");
        ConsoleWriter.printlnMessage("2. 노선 삭제");
        ConsoleWriter.printlnMessage("3. 노선 조회");
        ConsoleWriter.printlnMessage("B. 돌아가기");
    }

    public void printAddResult() {
        ConsoleWriter.printlnMessage("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void printDeleteResult() {
        ConsoleWriter.printlnMessage("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void printAllLines(List<String> lines) {
        ConsoleWriter.printlnMessage("## 노선 목록");
        for (String line : lines) {
            ConsoleWriter.printlnMessage("[INFO] " + line);
        }
        ConsoleWriter.println();
    }

    public String enterHeadStation() {
        ConsoleWriter.printlnMessage("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return consoleReader.enterMessage();
    }

    public String enterTailStation() {
        ConsoleWriter.printlnMessage("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return consoleReader.enterMessage();
    }
}

package subway.view;

import subway.domain.constants.FunctionCommand;
import subway.view.console.ConsoleReader;
import subway.view.console.ConsoleWriter;

public class MainView {
    private final ConsoleReader consoleReader;

    public MainView(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public FunctionCommand enterFunction() {
        return FunctionCommand.from(consoleReader.enterMessage());
    }

    public void printMainScreen() {
        ConsoleWriter.printlnMessage("## 메인 화면");
        ConsoleWriter.printlnMessage("1. 역 관리");
        ConsoleWriter.printlnMessage("2. 노선 관리");
        ConsoleWriter.printlnMessage("3. 구간 관리");
        ConsoleWriter.printlnMessage("4. 지하철 노선도 출력");
        ConsoleWriter.printlnMessage("Q. 종료");
        ConsoleWriter.println();
    }
}

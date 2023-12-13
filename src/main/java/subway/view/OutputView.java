package subway.view;

import subway.view.console.ConsoleWriter;

public class OutputView {
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

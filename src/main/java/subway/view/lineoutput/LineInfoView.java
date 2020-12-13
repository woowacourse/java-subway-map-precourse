package subway.view.lineoutput;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InfoView;
import subway.view.OutputView;

public class LineInfoView extends InfoView {
    private static final String LINE_REGISTER_INFO = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE_INFO = "지하철 노선이 삭제되었습니다.";

    public static void printRegisterInfo() {
        printInfo(LINE_REGISTER_INFO);
    }

    public static void printDeleteInfo() {
        printInfo(LINE_DELETE_INFO);
    }

    public static void printLine() {
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO + line.getName());
        }
        OutputView.printNewLine();
    }
}

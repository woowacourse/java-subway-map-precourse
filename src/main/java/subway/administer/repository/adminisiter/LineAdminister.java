package subway.administer.repository.adminisiter;

import java.util.Map;

import validation.ValidationCheck;
import view.io.InputView;
import view.io.OutputView;

import subway.exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.repository.LineRepository;
import subway.domain.repository.PassingRouteRepository;
import subway.domain.repository.StationRepository;

public class LineAdminister {

    private static final String LINE_REGISTERED = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    private static final String LINE_LIST = "## 노선 목록";

    public LineAdminister() {

    }

    public static void addLine() {
        try {
            Map<String, String> info = InputView.inputNewLineInfo();
            String name = info.get("lineName");
            ValidationCheck.repeatedLineCheck(name);
            ValidationCheck.lineNameLengthCheck(name);
            Line line = new Line(name,
                        new PassingRouteRepository(new String[]{info.get("startTerminalName"), info.get("endTerminalName")}));
            LineRepository.addBack(line);
            OutputView.printAfterCommand(LINE_REGISTERED);
        } catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            addLine();
        }
    }

    public static void deleteLine() {
        try {
            String name = InputView.inputDeleteLineName();
            ValidationCheck.lineExistenceCheck(name);
            LineRepository.delete(name);
            OutputView.printAfterCommand(LINE_DELETED);
        } catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            deleteLine();
        }
    }

    public static void inquiryLines() {
        OutputView.printAllInfo(LineRepository.inquiryAllLines(), LINE_LIST);
    }

}

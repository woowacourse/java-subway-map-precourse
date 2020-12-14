package subway.controller.RepositoryAdminister;

import java.util.Map;

import Validation.SubwayValidation;
import View.IoView.InputView;
import View.IoView.OutputView;

import subway.Exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.subRepository.LineRepository;
import subway.domain.subRepository.PassingRouteRepository;
import subway.domain.subRepository.StationRepository;

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
            Line line = new Line(name,
                        new PassingRouteRepository(new String[]{info.get("startTerminalName"), info.get("endTerminalName")}));
            LineRepository.addBack(line);
            SubwayValidation.repeatedLineCheck(line);
            SubwayValidation.lineLengthCheck(line);
            OutputView.printAfterCommand(LINE_REGISTERED);
        } catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            addLine();
        }
    }

    public static void deleteLine() {
        try {
            String name = InputView.inputDeleteLineName();
            SubwayValidation.lineExistenceCheck(name);
            StationRepository.delete(name);
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

package subway.controller;

import Validation.SubwayValidation;
import View.InputView;
import View.OutputView;
import java.util.ArrayList;
import subway.Exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.Station;
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
            String name = InputView.inputNewLineName();
            Line line = new Line(name, new PassingRouteRepository(new ArrayList<Station>()));
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

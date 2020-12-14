package subway.controller;

import subway.domain.Line;
import subway.domain.repositories.LineRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.LineView;

public class LineController {

    public static void lineInit() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addStationToLine("2호선", "교대역", "역삼역");
        LineRepository.addStationToLine("2호선", "강남역", 2);

        LineRepository.addLine(new Line("3호선"));
        LineRepository.addStationToLine("3호선", "교대역", "매봉역");
        LineRepository.addStationToLine("3호선", "남부터미널역 ", 2);
        LineRepository.addStationToLine("3호선", "양재역  ", 3);

        LineRepository.addLine(new Line("신분당선"));
        LineRepository.addStationToLine("신분당선", "강남역", "양재시민의숲역");
        LineRepository.addStationToLine("신분당선", "양재역", 2);
    }

    public static void lineAdd() {
        try {
            LineView.printLineAddReqMsg();
            String lineName = lineNameInput();
            String frontStationName = frontLineStationInput();
            String backStationName = backLineStationInput();
            if (frontStationName.equals(backStationName)) {
                throw new IllegalArgumentException("상행, 하행 노선 이름이 같습니다");
            }
            LineRepository.addLine(new Line(lineName));
            LineRepository.addStationToLine(lineName, frontStationName, backStationName);
            LineView.printLineAddSuccessMsg();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    private static String lineNameInput() throws IllegalArgumentException {
        String lineName = InputView.getInput();
        lineName = lineName.replace(" ", "");
        if (!Validator.isValidNameLength(lineName)) {
            throw new IllegalArgumentException("잘못된 노선 이름 길이 입니다");
        }
        if (Validator.isExistLineName(lineName)) {
            throw new IllegalArgumentException("이미 등록된 노선 이름 입니다");
        }
        return lineName;
    }

    private static String frontLineStationInput() throws IllegalArgumentException {
        LineView.printLineAddFrontReqMsg();
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isValidNameLength(stationName)) {
            throw new IllegalArgumentException("역 이름 길이가 잘못 되었습니다");
        }
        if (!Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("DB에 존재 하지 않는 역 입니다");
        }
        return stationName;
    }

    private static String backLineStationInput() throws IllegalArgumentException {
        LineView.printLineAddBackReqMsg();
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isValidNameLength(stationName)) {
            throw new IllegalArgumentException("역 이름 길이가 잘못 되었습니다");
        }
        if (!Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("DB에 존재 하지 않는 역 입니다");
        }
        return stationName;
    }

    public static void lineCheck() {
        LineView.printLineCheck();
    }
}

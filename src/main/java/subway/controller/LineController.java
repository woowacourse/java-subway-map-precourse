package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.LineView;

public class LineController {
    public static void lineAdd() {
        try {
            LineView.printLineAddReqMsg();
            String lineName = lineNameInput();
            String frontStationName = frontLineStationInput();
            String backStationName = backLineStationInput();
            if(frontStationName.equals(backStationName)){
                throw new IllegalArgumentException("상행, 하행 노선 이름이 같습니다");
            }
            LineRepository.addLine(new Line(lineName));
            LineRepository.addStationToLine(new Line(lineName), frontStationName, backStationName);
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
}

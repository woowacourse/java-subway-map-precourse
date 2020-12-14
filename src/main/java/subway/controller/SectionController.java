package subway.controller;

import jdk.internal.util.xml.impl.Input;
import subway.domain.repositories.LineRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.SectionView;

public class SectionController {

    public static void selectionAdd() {
        try {
            SectionView.printLineReqMsg();
            String lineName = lineNameInput();
            SectionView.printStationReqMsg();
            String stationName = stationNameInput(lineName);
        } catch (IllegalArgumentException e) {

        }
    }

    private static String lineNameInput() throws IllegalArgumentException {
        String lineName = InputView.getInput();
        lineName = lineName.replace(" ", "");
        if (!Validator.isExistLineName(lineName)) {
            throw new IllegalArgumentException("DB에 존재하지 않는 노선 이름 입니다");
        }
        return lineName;
    }

    private static String stationNameInput(String lineName) throws IllegalArgumentException {
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("DB에 존재 하지 않는 역 입니다");
        }
        if (Validator.isStationAlreadyInLine(stationName, lineName)) {
            throw new IllegalArgumentException("노선에서 갈래길은 생길 수 없습니다.");
        }
        return stationName;
    }
}
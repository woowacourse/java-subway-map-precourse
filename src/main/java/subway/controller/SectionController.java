package subway.controller;

import subway.domain.repositories.LineRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.SectionView;

public class SectionController {

    public static void sectionAdd() {
        try {
            SectionView.printLineReqMsg();
            String lineName = lineNameInput();
            SectionView.printStationReqMsg();
            String stationName = stationNameInput(lineName);
            SectionView.printLocationReqMsg();
            int location = locationInput(lineName);

            LineRepository.addStationToLine(lineName, stationName, location);
            SectionView.printAddSuccessMsg();
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] " + e.getMessage() + "\n");
        }
    }

    public static void sectionDelete() {
        try {

        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] " + e.getMessage() + "\n");
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

    private static int locationInput(String lineName) throws IllegalArgumentException {
        try {
            int location = Integer.parseInt(InputView.getInput());
            if (!Validator.isValidSectionRange(lineName, location)) {
                throw new IllegalArgumentException("잘못된 범위를 입력 하셨습니다.");
            }
            return location;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 형식을 입력하셨습니다");
        }
    }
}
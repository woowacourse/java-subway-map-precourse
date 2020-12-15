package subway.controller;

import subway.domain.SectionManageMenu;
import subway.domain.repositories.LineRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.SectionView;

public class SectionController {

    public static void sectionAdd() {
        try {
            SectionView.printLineAddReqMsg();
            String lineName = lineNameInput();
            SectionView.printStationAddReqMsg();
            String stationName = stationNameInputForAdd(lineName);
            SectionView.printLocationAddReqMsg();
            int location = locationInput(lineName);

            LineRepository.addStationToLine(lineName, stationName, location);
            SectionView.printAddSuccessMsg();
            SectionManageMenu.sectionManageMenuStop();  // 이곳에서 멈춰야 성공적으로 완료 후 메인으로 간다.
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] " + e.getMessage() + "\n");
        }
    }

    public static void sectionDelete() {
        try {
            SectionView.printLineDelReqMsg();
            String lineName = lineNameInput();
            SectionView.printStationDelReqMsg();
            String stationName = stationNameInputForDelete(lineName);
            if (!LineRepository.deleteStationInLine(lineName, stationName)) {
                throw new IllegalArgumentException("노선에 포함된 역이 2개 이하 입니다");
            }

            SectionView.printDelSuccessMsg();
            SectionManageMenu.sectionManageMenuStop();
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

    private static String stationNameInputForAdd(String lineName) throws IllegalArgumentException {
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

    private static String stationNameInputForDelete(String lineName) throws IllegalArgumentException {
        String stationName = InputView.getInput();
        stationName = stationName.replace(" ", "");
        if (!Validator.isExistStationName(stationName)) {
            throw new IllegalArgumentException("DB에 존재 하지 않는 역 입니다");
        }
        if (!Validator.isStationAlreadyInLine(stationName, lineName)) {
            throw new IllegalArgumentException("노선에 해당 역이 존재하지 않습니다.");
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
package subway.domain.station;

import java.util.Scanner;
import subway.common.ErrorMessage;

public class StationInputManager {
    private static final int MIN_TWO_LETTERS = 2;
    private static final String OVER_TWO = "2글자 이상이어야 한다.";
    private static final char STATION = '역';
    private static final String LAST_LETTER_STATION = "역이름 끝에는 역이라고 붙여주세요.";
    private static final String VALUE_EXIST = "이미 존재하는 이름입니다.";
    private static final String NOT_EXIST_STATION = "등록되어 있지 않은 역입니다.";
    private static final String ON_PATH_STATION = "노선에 등록된 역은 삭제할 수 없습니다.";

    private final Scanner scanner;

    public StationInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStationNameToAdd() {
        StationOutputManager.printAddSGuide();
        String stationName = scanner.nextLine().trim();
        checkNameToAdd(stationName);
        return stationName;
    }

    public String getStationNameToDelete() {
        StationOutputManager.printDeleteGuide();
        String stationName = scanner.nextLine().trim();
        checkNameToDelete(stationName);
        return stationName;
    }

    private void checkNameToAdd(String stationName) {
        checkLength(stationName);
        checkLastLetter(stationName);
        checkEnrolledStation(stationName);
    }

    //2글자이상
    private void checkLength(String stationName) {
        if (stationName.length() < MIN_TWO_LETTERS) {
            throw new ErrorMessage(OVER_TWO);

        }
    }

    //끝에는 역이라고 붙였는지
    private void checkLastLetter(String stationName) {
        if (stationName.charAt(stationName.length() - 1) != STATION) {
            throw new ErrorMessage(LAST_LETTER_STATION);
        }
    }

    //기존 역에 포함되어 있는지 중복여부
    private void checkEnrolledStation(String stationName) {
        if (StationRepository.containsName(stationName)) {
            throw new ErrorMessage(VALUE_EXIST);
        }
    }

    private void checkNameToDelete(String stationName) {
        checkAlreadyExist(stationName);
        checkNotOnPath(stationName);
    }

    //이미 있는 역이어야 함 그래야 삭제가능
    private void checkAlreadyExist(String stationName) {
        if (!StationRepository.containsName(stationName)) {
            throw new ErrorMessage(NOT_EXIST_STATION);
        }
    }

    //구간에 등록된 역이 아니어야 함
    private void checkNotOnPath(String stationName) {
        if (!StationRepository.isAvailableToDelete(stationName)) {
            throw new ErrorMessage(ON_PATH_STATION);
        }
    }

}

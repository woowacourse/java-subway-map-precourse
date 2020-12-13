package subway.domain.station;

import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.common.Guide;

public class StationInputManager {
    private Scanner scanner;


    private static final String OVER_TWO = "2글자 이상이어야 한다.";
    private static final String LAST_LETTER_STATION = "역이름 끝에는 역이라고 붙여주세요.";
    private static final String VALUE_EXIST = "이미 존재하는 이름입니다.";
    private static final String NOT_EXIST_STATION = "등록되어 있지 않은 역입니다.";
    private static final String ON_PATH_STATION = "노선에 등록된 역은 삭제할 수 없습니다.";

    public StationInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStationNameToAdd() {
        Guide.print(StationOutputManager.STATION_ADD_GUIDE);
        String name = scanner.nextLine().trim();
        try {
            checkNameToAdd(name);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return name;
    }

    public String getStationNameToDelete() {
        Guide.print(StationOutputManager.STATION_DELETE_GUIDE);
        String name = scanner.nextLine().trim();
        try {
            checkNameToDelete(name);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return name;
    }

    private void checkNameToAdd(String name) {
        checkLength(name);
        checkLastLetter(name);
        checkEnrolledStation(name);
    }

    private void checkLength(String name) {
        if (name.length() < 2) {
            throw new ErrorMessage(OVER_TWO);

        }
    }

    private void checkLastLetter(String name) {
        if (name.charAt(name.length() - 1) != '역') {
            throw new ErrorMessage(LAST_LETTER_STATION);
        }
    }

    private void checkEnrolledStation(String name) {
        if (StationRepository.stationNames().contains(name)) {
            throw new ErrorMessage(VALUE_EXIST);
        }
    }

    private void checkNameToDelete(String name) {
        checkAlreadyExist(name);
        checkNotOnPath(name);
    }

    private void checkAlreadyExist(String name) {
        if (!StationRepository.stationNames().contains(name)) {
            throw new ErrorMessage(NOT_EXIST_STATION);
        }
    }

    private void checkNotOnPath(String name) {
        if (StationRepository.findStation(name).isOnPath()) {
            throw new ErrorMessage(ON_PATH_STATION);
        }
    }

}

package subway.domain.station;

import java.util.Scanner;
import subway.common.ErrorMessageException;
import subway.domain.SubwayRepository;

public class StationInputManager {
    private static final int MIN_TWO_LETTERS_EXCEPT_LAST_WORD = 3;
    private static final String NAME_OVER_TWO = "마지막 글자 역을 제외한 역이름은 2글자 이상이어야 합니다.";
    private static final char STATION = '역';
    private static final String EMPTY = " ";
    private static final String EMPTY_SPACE_UNACCEPTABLE = "이름에 공백은 허용하지 않습니다.";
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
        checkNotEnrolledStation(stationName);
        checkEmptyIncluded(stationName);
    }

    private void checkLength(String stationName) {
        if (stationName.length() < MIN_TWO_LETTERS_EXCEPT_LAST_WORD) {
            throw new ErrorMessageException(NAME_OVER_TWO);

        }
    }

    private void checkLastLetter(String stationName) {
        if (stationName.charAt(stationName.length() - 1) != STATION) {
            throw new ErrorMessageException(LAST_LETTER_STATION);
        }
    }

    private void checkNotEnrolledStation(String stationName) {
        if (StationRepository.containsStationByName(stationName)) {
            throw new ErrorMessageException(VALUE_EXIST);
        }
    }

    private void checkEmptyIncluded(String stationName) {
        if(stationName.contains(EMPTY)){
            throw new ErrorMessageException(EMPTY_SPACE_UNACCEPTABLE);
        }
    }

    private void checkNameToDelete(String stationName) {
        checkEnrolledStation(stationName);
        checkNotOnPath(stationName);
    }

    private void checkEnrolledStation(String stationName) {
        if (!StationRepository.containsStationByName(stationName)) {
            throw new ErrorMessageException(NOT_EXIST_STATION);
        }
    }

    private void checkNotOnPath(String stationName) {
        if (SubwayRepository.containsStationOnPath(stationName)) {
            throw new ErrorMessageException(ON_PATH_STATION);
        }
    }

}

package subway.domain.line;

import java.util.Scanner;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessageException;

public class LineInputManager {
    private static final int MIN_TWO_LETTERS_EXCEPT_LAST_WORD = 3;
    private static final String NAME_OVER_TWO = "마지막 글자 선을 제외한 노선이름은 2글자 이상이어야 합니다.";
    private static final char LINE = '선';
    private static final String LAST_LETTER_LINE = "노선이름 끝에는 선이라고 붙여주세요.";
    private static final String ALREADY_ENROLLED_NAME = "이미 존재하는 이름입니다.";
    private static final String EMPTY = " ";
    private static final String EMPTY_SPACE_UNACCEPTABLE = "이름에 공백은 허용하지 않습니다.";
    private static final String NOT_EXIST_STATION = "등록되어 있지 않은 역입니다.";
    private static final String SAME_UP_DOWN_STATION = "상행과 하행은 같은 역을 등록할 수 없습니다.";
    private static final String NOT_EXIST_LINE = "등록되어 있지 않은 노선입니다.";

    private final Scanner scanner;

    public LineInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getLineInfoToAdd() {
        String[] lineInfo = new String[3];
        lineInfo[0] = getLineNameToAdd();
        lineInfo[1] = getUpStationName();
        lineInfo[2] = getDownStationName(lineInfo[1]);
        return lineInfo;
    }

    public String getLineNameToDelete() {
        LineOutputManager.printDeleteGuide();
        String lineName = scanner.nextLine().trim();
        checkNameToDelete(lineName);
        return lineName;
    }

    private String getLineNameToAdd() {
        LineOutputManager.printAddGuide();
        String lineName = scanner.nextLine().trim();
        checkNameToAdd(lineName);
        return lineName;
    }

    private void checkNameToAdd(String lineName) {
        checkLength(lineName);
        checkLastLetter(lineName);
        checkNotEnrolledLine(lineName);
        checkEmptyIncluded(lineName);
    }

    private void checkLength(String lineName) {
        if (lineName.length() < MIN_TWO_LETTERS_EXCEPT_LAST_WORD) {
            throw new ErrorMessageException(NAME_OVER_TWO);
        }
    }

    private void checkLastLetter(String lineName) {
        if (lineName.charAt(lineName.length() - 1) != LINE) {
            throw new ErrorMessageException(LAST_LETTER_LINE);
        }
    }

    private void checkNotEnrolledLine(String lineName) {
        if (LineRepository.containsName(lineName)) {
            throw new ErrorMessageException(ALREADY_ENROLLED_NAME);
        }
    }

    private void checkEmptyIncluded(String lineName) {
        if(lineName.contains(EMPTY)){
            throw new ErrorMessageException(EMPTY_SPACE_UNACCEPTABLE);
        }
    }

    public String getUpStationName() {
        LineOutputManager.printUpStationGuide();
        String stationName = scanner.nextLine().trim();
        checkUpStationName(stationName);
        return stationName;
    }

    private void checkUpStationName(String stationName) {
        checkEnrolledStation(stationName);
    }


    private void checkEnrolledStation(String stationName) {
        if (!StationRepository.containsStationByName(stationName)) {
            throw new ErrorMessageException(NOT_EXIST_STATION);
        }
    }

    private String getDownStationName(String upStation) {
        LineOutputManager.printDownStationGuide();
        String stationName = scanner.nextLine().trim();
        checkDownStationName(upStation, stationName);
        return stationName;
    }

    private void checkDownStationName(String upStation, String stationName) {
        isEqualToUpStation(upStation, stationName);
        checkEnrolledStation(stationName);
    }

    private void isEqualToUpStation(String upStation, String stationName) {
        if (stationName.equals(upStation)) {
            throw new ErrorMessageException(SAME_UP_DOWN_STATION);
        }
    }

    private void checkNameToDelete(String lineName) {
        checkEnrolledLine(lineName);
    }
    //이미 등록되어 있는 노선만 삭제 가능
    private void checkEnrolledLine(String lineName) {
        if (!LineRepository.containsName(lineName)) {
            throw new ErrorMessageException(NOT_EXIST_LINE);
        }
    }

}

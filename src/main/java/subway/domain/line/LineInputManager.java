package subway.domain.line;

import java.util.Scanner;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessageException;

public class LineInputManager {
    private static final String LINE = "호선";
    private static final int MIN_TWO_LETTERS = 2;
    private static final String LAST_LETTER_LINE = "노선이름 끝에는 호선이라고 붙여주세요.";
    private static final String ALREADY_ENROLLED_NAME = "이미 존재하는 이름입니다.";
    private static final String SAME_UP_DOWN_STATION = "상행과 하행은 같은 역을 등록할 수 없습니다.";
    private static final String NOT_EXIST_LINE = "등록되어 있지 않은 노선입니다.";
    private static final String NOT_EXIST_STATION = "등록되어 있지 않은 역입니다.";
    private static final String OVER_TWO = "노선이름은 2글자 이상이어야 한다.";

    private final Scanner scanner;

    public LineInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getLineInfoToAdd() {
        String[] lineInfo = new String[3];
        lineInfo[0] = getLineName();
        lineInfo[1] = getUpStationName();
        lineInfo[2] = getDownStationName(lineInfo[1]);
        return lineInfo;
    }

    public String getLineNameToDelete() {
        LineOutputManager.printDeleteGuide();
        String name = scanner.nextLine().trim();
        checkNameToDelete(name);
        return name;
    }

    private String getLineName() {
        LineOutputManager.printAddGuide();
        String name = scanner.nextLine().trim();
        checkName(name);
        return name;
    }

    private void checkName(String name) {
        checkLength(name);
        checkLastLetter(name);
        checkEnrolledLine(name);
    }
    // 이름 2이상
    private void checkLength(String name) {
        if (name.length() < MIN_TWO_LETTERS) {
            throw new ErrorMessageException(OVER_TWO);
        }
    }
    // 끝에은 노선이라고 붙여줘야 함
    private void checkLastLetter(String name) {
        if (name.substring(name.length() - 3).equals(LINE)) {
            throw new ErrorMessageException(LAST_LETTER_LINE);
        }
    }
    //노선 중복 불가
    private void checkEnrolledLine(String name) {
        if (LineRepository.containsName(name)) {
            throw new ErrorMessageException(ALREADY_ENROLLED_NAME);
        }
    }

    public String getUpStationName() {
        LineOutputManager.printUpStationGuide();
        String name = scanner.nextLine().trim();
        checkEnrolledStation(name);
        return name;
    }
    //등록되어 있는 역인지 확인
    private void checkEnrolledStation(String name) {
        if (!StationRepository.containsStationByName(name)) {
            throw new ErrorMessageException(NOT_EXIST_STATION);
        }
    }

    private String getDownStationName(String upStation) {
        LineOutputManager.printDownStationGuide();
        String name = scanner.nextLine().trim();
        checkDownStationName(upStation, name);
        return name;
    }
    // 이미 등록되어 있는 역인지 확인
    private void checkDownStationName(String upStation, String name) {
        isEqualToUpStation(upStation, name);
        checkEnrolledStation(name);
    }
    //상행역이랑 같은지 확인
    private void isEqualToUpStation(String upStation, String name) {
        if (name.equals(upStation)) {
            throw new ErrorMessageException(SAME_UP_DOWN_STATION);
        }
    }

    private void checkNameToDelete(String name) {
        checkAlreadyExist(name);
    }
    //이미 등록되어 있는 노선만 삭제 가능
    private void checkAlreadyExist(String name) {
        if (!LineRepository.containsName(name)) {
            throw new ErrorMessageException(NOT_EXIST_LINE);
        }
    }

}

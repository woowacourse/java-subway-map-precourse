package subway.domain.line;

import java.util.Scanner;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessage;
import subway.common.Guide;

public class LineInputManager {
    private Scanner scanner;

    public LineInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getAddLineInfo() {
        String[] lineInfo = new String[3];
        lineInfo[0] = getLineName("등록할");
        lineInfo[1] = getUpStationName();
        if (invalidUpDownStation(lineInfo[1])) {
            return lineInfo;
        }
        lineInfo[2] = getDownStationName(lineInfo[1]);
        return lineInfo;
    }

    private String getDownStationName(String upStation) {
        Guide.printDownStationGuide();
        String name = scanner.nextLine().trim();
        if (isEqualToUpStation(upStation, name)) {
            return ErrorMessage.OUT;
        }
        if (!checkEnrolledStation(name)) {
            return ErrorMessage.OUT;
        }
        return name;

    }

    private boolean isEqualToUpStation(String upStation, String name) {
        if (name.equals(upStation)) {
            ErrorMessage.printSameUpDownStation();
            return true;
        }
        return false;
    }

    private boolean invalidUpDownStation(String lineInfo) {
        return lineInfo.contains(ErrorMessage.OUT);
    }

    private String getLineName(String function) {
        while (true) {
            Guide.printLineGuide(function);
            String name = scanner.nextLine().trim();
            if (!checkName(name)) {
                continue;
            }
            return name;
        }
    }

    /*
    예외상황 - 등록되지 않은 역, 상행과 종점이 같은 경우
     */
    public String getUpStationName() {
        Guide.printUpStationGuide();
        String name = scanner.nextLine().trim();
        if (!checkEnrolledStation(name)) {
            return ErrorMessage.OUT;
        }
        return name;
    }

    private boolean checkEnrolledStation(String name) {
        if (!StationRepository.stationNames().contains(name)) {
            ErrorMessage.printNotExistStation();
            return false;
        }
        return true;
    }

    private boolean checkName(String name) {
        return checkLength(name) && checkLastLetter(name) && checkNotAlreadyExist(name);
    }

    private boolean checkNotAlreadyExist(String name) {
        if (LineRepository.lineNames().contains(name)) {
            ErrorMessage.printValueAlreadyExist();
            return false;
        }
        return true;
    }

    private boolean checkLastLetter(String name) {
        if (name.substring(name.length() - 3).equals("호선")) {
            ErrorMessage.printLastLetterLine();
            return false;
        }
        return true;
    }

    private boolean checkLength(String name) {
        if (name.length() < 2) {
            ErrorMessage.printNameLength();
            return false;
        }
        return true;
    }

    public String getLineNameToDelete() {
        Guide.printStationDeleteGuide();
        String name = scanner.nextLine().trim();
        if (!checkNameToDelete(name)) {
            return ErrorMessage.OUT;
        }
        return name;
    }

    private boolean checkNameToDelete(String name) {
        return checkAlreadyExist(name);
    }

    private boolean checkAlreadyExist(String name) {
        if (!LineRepository.lineNames().contains(name)) {
            ErrorMessage.printNotExistLine();
            return false;
        }
        return true;
    }
}

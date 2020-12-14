package subway.domain.input;

import subway.domain.*;

import java.util.*;

public class LineManageInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";
    static final int MIN_LINE_NAME_LENGTH = 2;
    static final String LINE_NAME_SUFFIX = "선";

    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputLineManageScreen(Scanner scanner) throws IllegalArgumentException{
        String lineManageChoice = scanner.next();
        if (functionList().contains(lineManageChoice)) {
            return lineManageChoice;
        }
        ErrorMessage.isInvalidFunction();
        throw new IllegalArgumentException();
    }

    public String validateLineName(String lineName) throws IllegalArgumentException{
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            ErrorMessage.isLessThanTwoWordLine();
            throw new IllegalArgumentException();
        }
        if (!lineName.endsWith(LINE_NAME_SUFFIX)) {
            ErrorMessage.isNotCorrectLineName();
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    public String inputEnrollLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        Optional<Line> newLine = LineRepository.lines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        if (newLine.isPresent()) {
            ErrorMessage.isAlreadyExistLine();
            throw new IllegalArgumentException();
        }
        validateLineName(lineName);
        return lineName;
    }

    public Station inputUpDownTrainLine(Scanner scanner) throws IllegalArgumentException{
        String upTrainLastStop = scanner.next();
        Optional<Station> searchedStation = StationRepository.stations()
                .stream().filter(station -> station.getName().equals(upTrainLastStop)).findAny();
        if (searchedStation.isPresent()) {
            return searchedStation.get();
        }
        ErrorMessage.isNotExistStation();
        throw new IllegalArgumentException();
    }

    public boolean isFixedLine(String lineName) {
        Optional<Line> fixedLine = LineRepository.fixedLines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        return fixedLine.isPresent();
    }

    public String inputDeleteLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        Optional<Line> searchedLine = LineRepository.lines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        if (searchedLine.isPresent()) {
            if (isFixedLine(lineName)) {
                ErrorMessage.isNotAbleToDeleteLine();
                throw new IllegalArgumentException();
            }
            return lineName;
        }
        ErrorMessage.isNotExistLine();
        throw new IllegalArgumentException();
    }

}

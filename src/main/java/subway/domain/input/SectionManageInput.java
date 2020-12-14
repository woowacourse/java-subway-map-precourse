package subway.domain.input;


import subway.domain.*;

import java.util.*;

public class SectionManageInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_BACK = "B";

    List<String> functionList = new ArrayList<>();

    private List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputSectionManageScreen(Scanner scanner) throws IllegalArgumentException{
        String sectionManageChoice = scanner.next();
        if (functionList().contains(sectionManageChoice)) {
            return sectionManageChoice;
        }
        ErrorMessage.isInvalidFunction();
        throw new IllegalArgumentException();
    }

    public Line inputLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        Optional<Line> searchedLine =LineRepository.lines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        if (searchedLine.isPresent()) {
            return searchedLine.get();
        }
        ErrorMessage.isNotExistLine();
        throw new IllegalArgumentException();
    }

    public Station inputStation(Scanner scanner) throws IllegalArgumentException{
        String sectionStation = scanner.next();
        Optional<Station> searchedStation = StationRepository.stations()
                .stream().filter(station -> station.getName().equals(sectionStation)).findAny();
        if (searchedStation.isPresent()) {
            return searchedStation.get();
        }
        ErrorMessage.isNotExistStation();
        throw new IllegalArgumentException();
    }

    public int inputStationOrder(Scanner scanner) throws IllegalArgumentException{
        String order = scanner.next();
        try {
            return Integer.parseInt(order);
        } catch (NumberFormatException numberFormatException) {
            ErrorMessage.isNotNumber();
            throw new IllegalArgumentException();
        }

    }
}

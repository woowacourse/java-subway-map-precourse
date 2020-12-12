package subway.domain;

import java.util.List;
import java.util.stream.Collectors;

public enum MainFunctions {
    STATION("1", "역"),
    LINE("2", "노선"),
    WAY("3", "구간"),
    SUBWAY("4", "지하철 노선도"),
    FINISH("Q", "종료");

    private final String functionNumber;
    private final String functionName;

    MainFunctions(String functionNumber, String functionName) {
        this.functionName = functionName;
        this.functionNumber = functionNumber;
    }

    public static MainFunctions haveNumber(String inputNumber) {
        for(MainFunctions mainFunctions : MainFunctions.values()){
            if(mainFunctions.getFunctionNumber().equals(inputNumber)){
                return mainFunctions;
            }
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getFunctionNumber() {
        return functionNumber;
    }

    public static List<String> getObjectsToString(MainFunctions mainFunctions) {
        if(mainFunctions.equals(MainFunctions.STATION)) return StationRepository.stations().stream().map(Station::getName).collect(Collectors.toList());
        if(mainFunctions.equals(MainFunctions.LINE)) return LineRepository.lines().stream().map(Line::getName).collect(Collectors.toList());
        return null;
    }

}

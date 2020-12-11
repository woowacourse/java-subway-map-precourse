package subway.domain;

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
        throw new IllegalArgumentException("잘못된 입력입니다");
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getFunctionNumber() {
        return functionNumber;
    }
}

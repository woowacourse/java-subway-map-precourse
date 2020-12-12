package subway.domain;

public enum DetailFunctions {
    ENROLL("1", "등록"),
    REMOVE("2", "삭제"),
    RESEARCH("3", "조회"),
    BACK("B", "돌아가기");

    private final String functionNumber;
    private final String functionName;

    DetailFunctions(String functionNumber, String functionName) {
        this.functionName = functionName;
        this.functionNumber = functionNumber;
    }

    public static DetailFunctions haveNumber(String inputNumber) {
        for(DetailFunctions detailFunctions : DetailFunctions.values()){
            if(detailFunctions.getFunctionNumber().equals(inputNumber)){
                return detailFunctions;
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

}

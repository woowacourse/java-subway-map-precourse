package subway.station;

public class StationValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String WRONG_NAME = "지하철 역 이름은 %d 글자 이상이어야 합니다.";

    public static void validateName(String name){
        if(name.length() < MIN_NAME_LENGTH){
            throw new IllegalStateException(String.format(WRONG_NAME, MIN_NAME_LENGTH));
        }
    }
}

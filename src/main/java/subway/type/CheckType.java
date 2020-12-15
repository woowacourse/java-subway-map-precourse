package subway.type;

/**
 * CheckType.java : 입력 값 마지막 문자 확인용 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum  CheckType {
    STATION_CHECK("역"),
    LINE_CHECK("선");

    private final String check;

    CheckType(String check) {
        this.check = check;
    }

    public String getCheck() {
        return check;
    }
}

package subway.exception.validator;

import subway.domain.LineName;

public class LineNameOutOfRangeException extends ValidationException {

    public static final String LENGTH_ERROR = "노선 이름은 %d글자 이상, %d글자 이하이어야 합니다. 입력하신 글자는 %d자 입니다.";

    public LineNameOutOfRangeException(int length) {
        super(String.format(LENGTH_ERROR, LineName.LENGTH_LOWER_BOUND, LineName.LENGTH_UPPER_BOUND, length));
    }

    public static void main(String[] args) {
        String s = "LineNameLengthOutOfBoundsException";
        System.out.println(s.length());
    }
}

package subway.station;

import subway.utils.InputValidator;

public class Station {
    private String name;

    public Station(String name) {
        /** TODO: 아래 코드 리펙토링 커밋하기 */
//        InputValidator.validateMoreThanTwoWords(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}

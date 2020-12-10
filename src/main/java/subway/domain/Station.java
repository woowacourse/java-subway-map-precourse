package subway.domain;

import subway.view.OutputView;



public class Station {
    private static final String NAME_LENGTH_ERROR="역 이름은 2글자 이상입니다.";
    private static final Integer MIN_NAME_LENGTH=2;
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public static boolean isValidName(String name){
        return name.length()>=MIN_NAME_LENGTH;
    }
}

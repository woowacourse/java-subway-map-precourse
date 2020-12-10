package subway.domain;

import subway.view.OutputView;



public class Station {
    private static final Integer MIN_NAME_LENGTH=2;
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isValidStationName(){
        return name.length()>=MIN_NAME_LENGTH;
    }
}

package subway.domain;

import subway.view.ErrorView;

public class Station {
    private final int MINIMUM_LENGTH = 2;

    private String name;

    public Station(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            ErrorView.nameLengthError();
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

}

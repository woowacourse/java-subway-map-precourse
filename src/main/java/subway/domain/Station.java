package subway.domain;

import static subway.view.OutputView.INFO_HEAD;

public class Station {
    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String formatName() {
        return INFO_HEAD + name;
    }

    // 추가 기능 구현
    public boolean isSameName(String comparingName) {
        return name.equals(comparingName);
    }
}

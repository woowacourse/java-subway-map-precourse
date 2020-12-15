package subway.manager;

import java.util.Scanner;
import subway.domain.Subway;

public class SubwayManager {
    static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";

    static final String WANT_QUIT_CODE = "Q";

    private Subway subway = new Subway();

    public void printMap() {
        subway.printMap();
    }


}

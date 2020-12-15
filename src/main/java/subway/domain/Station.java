package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNameMoreThan2Letters() {
        return name.length() >= 2;
    }
}

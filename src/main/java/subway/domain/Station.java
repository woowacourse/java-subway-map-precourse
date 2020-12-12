package subway.domain;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object object) {
        if (object instanceof Station) {
            return ((Station) object).name.equals(this.name);
        }
        return false;
    }

}

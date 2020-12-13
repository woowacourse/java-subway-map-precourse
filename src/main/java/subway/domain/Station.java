package subway.domain;

import java.util.Objects;

public class Station {

    private String name;
    private int numberOnLines = 0;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOnLines() { return numberOnLines; }

    public void addNumberOnLines() {
        numberOnLines++;
    }

    public void subtractNumberOnLines() {
        numberOnLines--;
    }

    public boolean isNotOnLines() {
        if(numberOnLines == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object instanceof Station) {
            return ((Station) object).name.equals(this.name);
        }
        return false;
    }

    public String toString() {
        return name;
    }

}

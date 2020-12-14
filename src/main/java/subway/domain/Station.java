package subway.domain;

public class Station {
    private static final int MINIMUM_LENGTH = 2;
    
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isValidName() {
        if (name.length() >= MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (((Station)obj).getName().equals(name)) {
            return true;
        }
        return false;
    }
}

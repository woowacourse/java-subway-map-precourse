package subway.domain;

import subway.dto.StationDTO;

public class Station {
    private static final String INVALID_LENGTH_FORMAT = "이름은 %d 글자 이상이어야 합니다.";
    private static final int MIN_LENGTH = 2;

    private final String name;

    public Station(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_FORMAT, MIN_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StationDTO toDTO() {
        return new StationDTO(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Station paramObj = (Station) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

}

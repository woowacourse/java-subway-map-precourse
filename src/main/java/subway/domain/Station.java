package subway.domain;

import subway.view.ErrorView;

import java.util.regex.Pattern;

public class Station {

    public static final int STATION_NAME_LENGTH_MINIMUM = 2;
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[역|station|Station|STATION]$";

        if (StationRepository.exists(name)) {
            throw new IllegalArgumentException(ErrorView.ALREADY_EXIST_STATION);
        }
        if (name.length() < STATION_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException(ErrorView.AT_LEAST_TWO_LETTERS_STATION);
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException(ErrorView.NAME_FORM_STATION);
        }
    }
}

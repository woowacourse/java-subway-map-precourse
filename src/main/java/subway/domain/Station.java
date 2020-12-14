package subway.domain;

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

    // 추가 기능 구현
    public void validate(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[역|station|Station|STATION]$";

        if (StationRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
        if (name.length() < STATION_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 두글자 이상이어야 합니다.");
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '역' 이나 'station' 으로 끝나야 합니다.");
        }
    }
}

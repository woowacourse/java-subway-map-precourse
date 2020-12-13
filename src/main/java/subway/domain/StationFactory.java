package subway.domain;

public class StationFactory {
    public static Station makeStation(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역의 이름은 2글자 이상이어야 합니다.");
        }
        return new Station(name);
    }


}

package subway.domain;

public class Station {
    private static String ERR_DUPLICATE_STATION_NAME = "이미 등록된 역 이름입니다.";
    private String name;

    public Station(String name) {
        if (StationRepository.isInStationRepository(name)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_STATION_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

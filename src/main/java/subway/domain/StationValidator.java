package subway.domain;

public class StationValidator {
    public static String checkUnrolledStation(String stationName) {
        if (StationRepository.findStationByName(stationName) != null) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
        return stationName;
    }

    public static String checkEnrolledStation(String stationName) {
        if (StationRepository.findStationByName(stationName) == null) {
            throw new IllegalArgumentException("역이 존재하지 않습니다.");
        }
        return stationName;
    }

    public static Station checkEnrolledStationInLine(Line line, Station station) {
        if (!SubwayRepository.subway().get(line).contains(station)) {
            throw new IllegalArgumentException("노선에 역이 존재하지 않습니다.");
        }
        return station;
    }

    public static Station checkUnrolledStationInLine(Line line, Station station) {
        if (SubwayRepository.subway().get(line).contains(station)) {
            throw new IllegalArgumentException("노선에 이미 역이 존재합니다.");
        }
        return station;
    }
}

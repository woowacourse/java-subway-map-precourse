package Validation;

import javax.print.attribute.standard.MediaSize.NA;
import subway.Exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.subRepository.StationRepository;
import subway.domain.subRepository.LineRepository;

public class SubwayValidation {

    private static final String NAME_LENGTH_WARNING = "이름은 2글자 이상이어야 합니다.";
    private static final String REPEATED_STATION_NAME = "이미 등록된 역 이름입니다.";
    private static final String REPEATED_LINE_NAME = "이미 등록된 노선 이름입니다.";
    private static final String ALREADY_REGISTERED_INTERVAL = "이미 등록된 구간입니다.";
    private static final String INSUFFICIENT_STATION_NUM = "구간을 삭제하기에는 역의 개수가 3개 보다 적습니다";
    private static final int LEAST_LENGTH = 2;
    private static final int LEAST_STATION_NUM = 3;

    public static void stationLengthCheck(Station station) {
        if (station.getName().length() < LEAST_LENGTH) {
            throw new SubwayRelatedException(NAME_LENGTH_WARNING);
        }
    }

    public static void lineLengthCheck(Line line) {
        if (line.getName().length() < LEAST_LENGTH) {
            throw new SubwayRelatedException(NAME_LENGTH_WARNING);
        }
    }

    public static void repeatedStationCheck(Station station) {
        if (StationRepository.isRepeatedName(station.getName())) {
            throw new SubwayRelatedException(REPEATED_STATION_NAME);
        }
    }

    public static void repeatedLineCheck(Line line) {
        if (LineRepository.isRepeatedName(line.getName())) {
            throw new SubwayRelatedException(REPEATED_LINE_NAME);
        }
    }

    public static void RegisteredIntervalCheck(Line line, Station station) {
        if (line.passingRoutes.isContaining(station)) {
            throw new SubwayRelatedException(ALREADY_REGISTERED_INTERVAL);
        }
    }

    public static void StationExistenceCheck(String name) {
        StationRepository.searchStation(name);
    }

    public static void lineExistenceCheck(String name) {
        LineRepository.searchLine(name);
    }

    public void intervalLengthCheck(Line line) {
        if (line.getPassingRoutes().size() < LEAST_STATION_NUM) {
            throw new SubwayRelatedException(INSUFFICIENT_STATION_NUM);
        }
    }


}

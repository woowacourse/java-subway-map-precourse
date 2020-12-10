package subway.utils;

import java.util.Objects;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;

public class ValidateUtils {

    public static final String SHORT_NAME_EXCEPTION_MESSAGE = "이름은 2자 이상이어야 합니다.";
    public static final String EXISTING_STATION_EXCEPTION_MESSAGE = "이미 존재하는 역입니다.";
    public static final String EXISTING_LINE_EXCEPTION_MESSAGE = "이미 존재하는 노선입니다.";
    public static final String EXISTING_SECTON_EXCEPTION_MESSAGE = "이미 존재하는 구간입니다.";
    public static final String LESS_THAN_TWO_SECTIONS_EXCEPTION_MESSAGE = "노선 내 구간은 최소 2개이어야 합니다.";
    public static final int TWO = 2;

    private void isMoreThanTwo(String input){
        if(input.length() < TWO){
            throw new SubwayCustomException(SHORT_NAME_EXCEPTION_MESSAGE);
        }
    }

    private void isNotDuplicateStation(String input){
        if(StationRepository.stations().stream().anyMatch(station -> Objects.equals(station.getName(),input))){
            throw new SubwayCustomException(EXISTING_STATION_EXCEPTION_MESSAGE);
        }
    }

    private void isNotDuplicateLine(String input){
        if(LineRepository.lines().stream().anyMatch(line -> Objects.equals(line.getName(),input))){
            throw new SubwayCustomException(EXISTING_LINE_EXCEPTION_MESSAGE);
        }
    }

    private void isAlreadyExistingSection(Line line, Station station){
        if(line.getSections().contains(station)){
            throw new SubwayCustomException(EXISTING_SECTON_EXCEPTION_MESSAGE);
        }
    }

    private void isLessThanTwoStation(Line line){
        if(line.getSections().size() <= TWO){
            throw new SubwayCustomException(LESS_THAN_TWO_SECTIONS_EXCEPTION_MESSAGE);
        }
    }

}

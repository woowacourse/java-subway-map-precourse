package subway.domain.input;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.*;

public class LineManageInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";
    static final int MIN_LINE_NAME_LENGTH = 2;
    static final String LINE_NAME_SUFFIX = "선";

    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputLineManageScreen(Scanner scanner) throws IllegalArgumentException{
        String lineManageChoice = scanner.next();
        if (functionList().contains(lineManageChoice)) {
            return lineManageChoice;
        }
        // 정해진 것만 입력하라는 메시지
        throw new IllegalArgumentException();
    }

    public String validateLineName(String lineName) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            //2자 이상 입력하라는 메시지
            throw new IllegalArgumentException();
        }
        if (!lineName.endsWith(LINE_NAME_SUFFIX)) {
            //마지막 글자는 "선" 으로 입력하라는 메시지
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    public String inputEnrollLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        Optional<Line> newLine = LineRepository.lines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        if (newLine.isPresent()) {
            //해당 노선 이름이 존재한다는 메시지
            throw new IllegalArgumentException();
        }
        validateLineName(lineName);
        return lineName;
    }

    public Station inputUpDownTrainLine(Scanner scanner) throws IllegalArgumentException{
        String upTrainLastStop = scanner.next();
        Optional<Station> searchedStation = StationRepository.stations()
                .stream().filter(station -> station.getName().equals(upTrainLastStop)).findAny();
        if (searchedStation.isPresent()) {
            return searchedStation.get();
        }
        //해당 역은 없다는 메시지 출력
        throw new IllegalArgumentException();
    }



}

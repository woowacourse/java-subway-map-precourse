package subway.domain.input;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.*;

public class SectionManageInput {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_BACK = "B";

    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputLineManageScreen(Scanner scanner) throws IllegalArgumentException{
        String sectionManageChoice = scanner.next();
        if (functionList().contains(sectionManageChoice)) {
            return sectionManageChoice;
        }
        // 정해진 것만 입력하라는 메시지
        throw new IllegalArgumentException();
    }

    public String inputLine(Scanner scanner) throws IllegalArgumentException{
        String lineName = scanner.next();
        Optional<Line> searchedLine =LineRepository.lines()
                .stream().filter(line -> line.getName().equals(lineName)).findAny();
        if (searchedLine.isPresent()) {
            return lineName;
        }
        //해당 노선 이름이 존재하지 않는다는 메시지
        throw new IllegalArgumentException();
    }
}

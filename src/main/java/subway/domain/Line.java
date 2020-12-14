package subway.domain;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class Line {

    public static final int LINE_NAME_LENGTH_MINIMUM = 2;
    private String name;
    private LinkedList<Station> line = new LinkedList<>();

    public Line(String name) {
        validateLine(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Line addTerminus(String upBoundTerminus, String downBoundTerminus) {
        validateTerminus(upBoundTerminus);
        validateTerminus(downBoundTerminus);
        line.addFirst(StationRepository.findStation(upBoundTerminus));
        line.addLast(StationRepository.findStation(downBoundTerminus));
        return this;
    }

    public LinkedList<Station> stations() {
        return line;
    }

    public void validateLine(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[선|line|Line|LINE]$";

        if (LineRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
        if (name.length() < LINE_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 두글자 이상이어야 합니다.");
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '선' 이나 'line' 으로 끝나야 합니다.");
        }
    }

    public void validateTerminus(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[역|station|Station|STATION]$";

        if (!StationRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
        if (name.length() < LINE_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 두글자 이상이어야 합니다.");
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '역' 이나 'station' 으로 끝나야 합니다.");
        }
    }
}

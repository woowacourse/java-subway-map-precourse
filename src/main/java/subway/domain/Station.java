package subway.domain;

/**
 * Station.java : 지하철 역에 대한 도메인 모델 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}

package subway.domain;

/**
 * Line.java : 지하철 노선에 대한 도메인 모델 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}

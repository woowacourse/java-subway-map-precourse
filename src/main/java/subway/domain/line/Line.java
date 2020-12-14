package subway.domain.line;

public class Line {
    // 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
    private final String name;

    // 기본 생성자를 추가할 수 없다.
    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    // 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
}

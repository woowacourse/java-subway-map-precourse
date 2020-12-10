package subway.domain;

public class Line {
    private static final String INVALID_LENGTH_FORMAT = "이름은 %d 글자 이상이어야 합니다.";
    private static final int MIN_LENGTH = 2;

    private String name;

    public Line(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_FORMAT, MIN_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Line paramObj = (Line) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

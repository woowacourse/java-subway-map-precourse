package subway.domain;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름은 2글자 이상이어야 합니다.");
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name) {
            return ((Name) o).name.equals(this.name);
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}

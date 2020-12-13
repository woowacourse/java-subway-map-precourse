package subway.domain;

public class Station {

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof Station) {
//            return this.isSameName(((Station) o).getName());
//        }
//        return false;
//    }

    public boolean isSameName(String name) {
        return this.getName().equals(name);
    }
}

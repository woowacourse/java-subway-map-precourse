package subway.domain;

public class Line {
    private String name;
    private List<String> stations = new ArrayList<>();

    public Line(String name, String firstStation, String lastStation) {
        this.name = name;
        stations.add(firstStation);
        stations.add(lastStation);
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void add(int index, String sectionStations) {
        stations.add(index, sectionStations);
    }
    // 추가 기능 구현
}

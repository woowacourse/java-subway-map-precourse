package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }

    public void addSection(Station inputStation){
        if(StationRepository.stations().contains(inputStation)){
            sections.add(inputStation);
        }
    }
}

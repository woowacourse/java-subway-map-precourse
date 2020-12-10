package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class SectionRepository {

    // 노선의 실제 구현 (2호선 = {당산역, 홍대역, 신촌역, 이대역, 아현역, 충정로역, 시청역})
    private static final LinkedList<Station> sectionList = new LinkedList<>();

    public static void addSection(Line lineInstance, Station stationInstance, int indexNumber) {

    }

    public void removeSection(Line lineInstance, Station stationInstance) {

    }

    public List findAll() {

        return null;
    }

    public Station findByStation(Station station) {

        return null;
    }


}

package subway.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SectionRepository {

    // 노선의 실제 구현 (2호선 = {당산역, 홍대역, 신촌역, 이대역, 아현역, 충정로역, 시청역})
    private static final LinkedList<Station> sectionList = new LinkedList<>();

    public static void addSection(Station stationInstance, int indexNumber) {
        sectionList.add(indexNumber, stationInstance);
    }

    public void removeSection(Station stationInstance) {
        if (isExistStation(stationInstance)) {
            sectionList.remove(stationInstance);
            System.out.println("해당 역이 구간에 삭제되었습니다.");
        }
    }

    public List findAll() {
        Iterator<Station> iter = sectionList.iterator();
        List<String> stationNameList = new ArrayList<>();
        while (iter.hasNext()) {
            stationNameList.add(iter.next().getName());
        }
        return stationNameList;
    }

    public boolean isExistStation(Station station) {
        for (Station stationElement : sectionList) {
            if (stationElement.equals(station)) {
                return true;
            }
        }
        System.out.println("노선에 해당 역이 없습니다.");
        return false;
    }


}

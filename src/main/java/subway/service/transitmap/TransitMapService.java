package subway.service.transitmap;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.TransitMapRepository;
import subway.service.transitmap.show.TransitMapShowService;

import java.util.LinkedList;
import java.util.Map;

/**
 * TransitMapService.java : 지하철 노선도 비즈니스 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class TransitMapService {
    public static void showTransitMap() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();

        TransitMapShowService.readTransitMap(stringBuilder, transitMaps);
        System.out.println(stringBuilder);
    }
}

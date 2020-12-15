package subway.service.transitmap;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.TransitMapRepository;
import subway.service.transitmap.show.TransitMapShowService;

import java.util.LinkedList;
import java.util.Map;

public class TransitMapService {
    public static void showTransitMap() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();

        TransitMapShowService.readTransitMap(stringBuilder, transitMaps);
        System.out.println(stringBuilder);
    }
}

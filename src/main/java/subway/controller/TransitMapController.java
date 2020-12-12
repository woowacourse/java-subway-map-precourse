package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.TransitMapRepository;
import subway.service.TransitMapService;

import java.util.LinkedList;
import java.util.Map;

public class TransitMapController {
    public static void showTransitMap() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();

        TransitMapService.readTransitMap(stringBuilder, transitMaps);
        System.out.println(stringBuilder);
    }
}

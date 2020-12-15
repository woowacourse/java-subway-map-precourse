package subway.controller;

import subway.service.transitmap.TransitMapService;

/**
 * TransitMapController.java : 지하철 노선도에 대한 컨트롤러 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class TransitMapController {
    public static void startTransitMap() {
        TransitMapService.showTransitMap();
    }
}

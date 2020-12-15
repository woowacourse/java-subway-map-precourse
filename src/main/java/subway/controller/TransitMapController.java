package subway.controller;

import subway.service.transitmap.TransitMapService;

public class TransitMapController {
    public static void startTransitMap() {
        TransitMapService.showTransitMap();
    }
}

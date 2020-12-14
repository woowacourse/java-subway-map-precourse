package subway.controller;

import subway.domain.LineRepository;
import subway.viewer.EntireMapOutputViewer;

public class EntireShowManager {
    public void processSector() {
        EntireMapOutputViewer.showEntireMap(LineRepository.lines());
    }
}

package subway.controller;

import subway.service.SectionService;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public class SectionController {
    private SectionService sectionService;

    public SectionController() {
        this.sectionService = new SectionService();
    }

    public boolean createSection(String name, String line, String order) {
        return sectionService.addSection(name, line, order);
    }

    public boolean deleteSection(String name, String station) {
        return sectionService.deleteSection(name, station);
    }

    public boolean existLine(String name) {
        return sectionService.findLine(name);
    }

    public boolean existStation(String name) {
        return sectionService.findStation(name);
    }
}

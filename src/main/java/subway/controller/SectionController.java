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

    public void createSection(String name, String line, String order) {
        this.sectionService.addSection(name, line, order);
    }
}

package subway.controller;

import subway.service.section.SectionService;

import java.util.Scanner;

/**
 * SectionController.java : 지하철 구간에 대한 컨트롤러 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionController {
    public static void startSection(Scanner scanner) {
        SectionService sectionService = new SectionService();
        sectionService.manage(scanner);
    }
}

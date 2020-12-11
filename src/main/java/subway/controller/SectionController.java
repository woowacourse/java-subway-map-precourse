package subway.controller;

import subway.service.SectionService;

import java.util.Scanner;

public class SectionController {
    public static void startSection(Scanner scanner) {
        SectionService.manageSection(scanner);
    }
}

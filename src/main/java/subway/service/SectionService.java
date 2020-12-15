package subway.service;

import subway.domain.Section;
import subway.repository.SectionRepository;

import java.util.List;

public class SectionService {
    public static List<Section> sections() {
        return SectionRepository.sections();
    }

    public static void addSection(String lineName, String stationName) {
    }

    public static void addSection(String lineName, String stationName, int order) {
    }

    public static void deleteSectionByName(String lineName, String stationName) {
    }
}

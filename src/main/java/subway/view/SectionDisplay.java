package subway.view;

import java.util.List;
import subway.domain.Section;

public class SectionDisplay extends Display{
    public static void loadSectionMenu() {
    }

    public static void printAllSections(List<Section> sections) {
        sections.stream().forEach(section -> printInformation(section.getLine().getName()));
    }
}

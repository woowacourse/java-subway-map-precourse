package subway.domain.service;

import subway.domain.Line;
import subway.domain.Station;
import utils.Category;
import utils.ScriptUtils;

public class SectionService {
    public static final int ASK_LINE = 0;
    public static final int ASK_STATION = 1;

    public static void checkDuplicate(int askIdx, String answer) {
        if (askIdx == ASK_LINE) {
            if (!LineService.duplicateName(answer)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_NO(Category.LINE));
            }
        }
        if (askIdx == ASK_STATION) {
            if (!StationService.duplicateName(answer)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_NO(Category.STATION));
            }
        }
    }

    public static void createSection(Line line, Station station, int idx) {
        try {
            if (line.validateStation(station)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_DUPLICATE(Category.STATION));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        line.addStation(station, idx);
    }

    public static void deleteSection(Line line, Station station) {
        if (line.getLength() <= 2) {
            System.out.println(ScriptUtils.ERROR_TOO_SMALL);
            return;
        }
        line.deleteStation(station);
    }
}

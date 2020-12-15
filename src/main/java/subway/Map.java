package subway;

import subway.domain.LineRepository;
import subway.domain.Line;

public class Map {
    public static void lookUp() {
        Print.hashMessage(Constant.MAP_TITLE);
        LineRepository.lines().forEach(line -> {
            printLine(line);
            System.out.println();
        });
    }

    public static void printLine(Line line){
        System.out.println(Constant.HEAD_INFO + line.getName());
        System.out.println(Constant.HEAD_INFO + Constant.DIVIDER);
        line.stations().forEach(station -> {
            System.out.println(Constant.HEAD_INFO + station.getName());
        });
    }
}

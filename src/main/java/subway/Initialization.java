package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

enum DefaultStations {
    GYODAE("교대역"), GANGNAM("강남역"), YEOKSAM("역삼역"), NAMBU_BUS_TERMINAL("남부터미널역"),
    YANGJAE("양재역"), YANGJAE_CITIZEN_FOREST("양재시민의숲역"), MAEBONG("매봉역");

    private final String name;

    DefaultStations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum DefaultLines {
    LINE_2("2호선", DefaultStations.GYODAE.getName(), DefaultStations.YEOKSAM.getName(),
            new DefaultStations[]{DefaultStations.GYODAE, DefaultStations.GANGNAM, DefaultStations.YEOKSAM}),
    LINE_3("3호선", DefaultStations.GYODAE.getName(), DefaultStations.MAEBONG.getName(),
            new DefaultStations[]{DefaultStations.GYODAE, DefaultStations.NAMBU_BUS_TERMINAL, DefaultStations.YANGJAE, DefaultStations.MAEBONG}),
    LINE_SHINBUNDANG("신분당선", DefaultStations.GANGNAM.getName(), DefaultStations.YANGJAE_CITIZEN_FOREST.getName(),
            new DefaultStations[]{DefaultStations.GANGNAM, DefaultStations.YANGJAE, DefaultStations.YANGJAE_CITIZEN_FOREST});

    private final String name;
    private final String northboundTerminal;
    private final String southboundTerminal;
    private final DefaultStations[] containedStations;

    DefaultLines(String name, String northboundTerminal, String southboundTerminal, DefaultStations[] containedStations) {
        this.name = name;
        this.northboundTerminal = northboundTerminal;
        this.southboundTerminal = southboundTerminal;
        this.containedStations = containedStations;
    }

    public String getName() {
        return name;
    }

    public String getNorthboundTerminal() {
        return northboundTerminal;
    }

    public String getSouthboundTerminal() {
        return southboundTerminal;
    }

    public DefaultStations[] getContainedStations() {
        return containedStations;
    }
}

public class Initialization {

    public static void set() {
        Initialization init = new Initialization();
        init.registerStations();
        init.registerLines();
    }

    public void registerStations() {
        DefaultStations[] defaultStations = DefaultStations.values();
        for (DefaultStations defaultStation : defaultStations) {
            StationRepository.addStation(new Station(defaultStation.getName()));
        }
    }

    public void registerLines() {
        DefaultLines[] defaultLines = DefaultLines.values();
        for (DefaultLines defaultLine : defaultLines) {
            Line currentLine = new Line(defaultLine.getName(), defaultLine.getNorthboundTerminal(), defaultLine.getSouthboundTerminal());
            registerStationsInLine(defaultLine, currentLine);
            LineRepository.addLine(currentLine);
        }
    }

    public void registerStationsInLine(DefaultLines defaultLine, Line line) {
        for (DefaultStations defaultStation : defaultLine.getContainedStations()) {
            line.appendStation(defaultStation.getName());
        }
    }

}

package subway;

import subway.domain.*;
import subway.view.OutputView;
import subway.view.page.MainMenu;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayManagementApp {
    private static final String[] initialStation = new String[]{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] initialLine = new String[]{"2호선", "3호선", "신분당선"};

    private final Scanner scanner;

    public SubwayManagementApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        initialize();
        MainMenu.run(scanner);
    }

    private void initialize() {
        List<Station> stations = Arrays.stream(initialStation)
                .map(Name::new)
                .map(Station::create)
                .collect(Collectors.toList());

        List<Name> lineNames = Arrays.stream(initialLine)
                .map(Name::new)
                .collect(Collectors.toList());

        stations.stream().forEach(StationRepository::addStation);

        Line ihoseon = Line.create(lineNames.get(0), stations.get(0), stations.get(2));
        ihoseon.addStation(new Order(1), stations.get(1));

        Line samhoseon = Line.create(lineNames.get(1), stations.get(0), stations.get(6));
        samhoseon.addStation(new Order(1), stations.get(3));
        samhoseon.addStation(new Order(2), stations.get(4));

        Line sinboondang = Line.create(lineNames.get(2), stations.get(1), stations.get(5));
        sinboondang.addStation(new Order(1), stations.get(4));

        LineRepository.addLine(ihoseon);
        LineRepository.addLine(samhoseon);
        LineRepository.addLine(sinboondang);
    }
}

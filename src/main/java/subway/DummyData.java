package subway;

import subway.controller.ControllerContainer;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.service.*;

import java.util.Arrays;
import java.util.Objects;

public class DummyData {

    private static StationRepository stationRepository = ControllerContainer.getStationRepository();
    private static LineRepository lineRepository = ControllerContainer.getLineRepository();

    private static String[] stationNames = {
            "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
    };

    private static Station[] stations;

    private static Station from(String name) {
        return Arrays.stream(stations)
                .filter(station -> Objects.equals(station.getName().toString(), name))
                .findAny()
                .orElse(null);
    }

    public static void init() {
        stations = Arrays.stream(stationNames)
                .map(station -> new StationGenerateService().generate(station))
                .toArray(Station[]::new);

        Arrays.stream(stations).forEach(station -> new StationRegisterService(stationRepository).register(station));

        Line line = new LineGenerateService(stationRepository).generate("2호선", from("교대역"), from("역삼역"));
        new LineRegisterService(lineRepository).register(line);
        new SectionRegisterService(stationRepository, lineRepository).add("2호선", "강남역", "1");

        Line line3 = new LineGenerateService(stationRepository).generate("3호선", from("교대역"), from("매봉역"));
        new LineRegisterService(lineRepository).register(line3);
        new SectionRegisterService(stationRepository, lineRepository).add("3호선", "양재역", "1");
        new SectionRegisterService(stationRepository, lineRepository).add("3호선", "남부터미널역", "1");

        Line shin = new LineGenerateService(stationRepository).generate("신분당선", from("강남역"), from("양재시민의숲역"));
        new LineRegisterService(lineRepository).register(shin);
        new SectionRegisterService(stationRepository, lineRepository).add("신분당선", "양재역", "1");
    }
}

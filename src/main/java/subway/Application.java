package subway;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.repository.line.LineRepository;
import subway.repository.line.LineRepositoryImpl;
import subway.repository.station.StationRepository;
import subway.repository.station.StationRepositoryImpl;
import subway.service.*;

public class Application {
    public static void main(String[] args) {
        LineRepository lineRepository = new LineRepositoryImpl();
        StationRepository stationRepository = new StationRepositoryImpl();

        Station station1 = new StationGenerateService().generate("테스트역");
        Station station2 = new StationGenerateService().generate("테스트2역");
        Station station3 = new StationGenerateService().generate("테스역");

        new StationRegisterService(stationRepository).register(station1);
        new StationRegisterService(stationRepository).register(station2);
        new StationRegisterService(stationRepository).register(station3);

        Line line = new LineGenerateService(stationRepository).generate("테스트선", station1, station2);
        new LineRegisterService(lineRepository).register(line);

        new StationAddToLineService(stationRepository, lineRepository).add("테스트선", "테스역", "3");
        new LineListService(lineRepository).get();
    }
}

package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineManagementScreen;
import subway.view.MainScreen;
import subway.view.SectionManagementScreen;
import subway.view.StationManagementScreen;

public class Load {
    public static void loadMainScreen(){
        MainScreen mainScreen = new MainScreen();
        mainScreen.start();
    }

    public static void loadStationManagementScreen(){
        StationManagementScreen stationManagementScreen = new StationManagementScreen();
        stationManagementScreen.start();
    }

    public static void loadLineManagementScreen(){
        LineManagementScreen lineManagementScreen = new LineManagementScreen();
        lineManagementScreen.start();
    }

    public static void loadSectionManagementScreen(){
        SectionManagementScreen sectionManagementScreen = new SectionManagementScreen();
        sectionManagementScreen.start();
    }

    public static void initiate() {
        String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        String[] lines = {"2호선", "3호선", "신분당선"};
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
        for (String line : lines) {
            LineRepository.addLine(new Line(line));
        }
        Line line2 = LineRepository.findLine("2호선");
        line2.initiateLineStations(StationRepository.findStation("교대역"),
                StationRepository.findStation("역삼역"));
        line2.getLineStations().add(1, StationRepository.findStation("강남역"));
        Line line3 = LineRepository.findLine("3호선");
        line3.initiateLineStations(StationRepository.findStation("교대역"),
                StationRepository.findStation("매봉역"));
        line3.getLineStations().add(1, StationRepository.findStation("양재역"));
        line3.getLineStations().add(1, StationRepository.findStation("남부터미널역"));
        Line newBunDang = LineRepository.findLine("신분당선");
        newBunDang.initiateLineStations(StationRepository.findStation("강남역"),
                StationRepository.findStation("양재시민의숲역"));
        newBunDang.getLineStations().add(1, StationRepository.findStation("양재역"));
    }
}

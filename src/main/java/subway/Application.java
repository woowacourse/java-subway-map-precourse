package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.*;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        initailize();
        while (true) {
            boolean isEndService = MainView.MainMenu();
            if (isEndService) break;
        }
    }

    public static void initailize() {
        initailizeStation();
        initailizeLine();
    }

    public static void initailizeStation() {
        String[] stationList = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String stationName : stationList) {
            Station newStation = new Station(stationName);
            StationRepository.addStation(newStation);
        }
    }

    public static void initailizeLine() {
        String[] lineList = {"2호선", "3호선", "신분당선"};
        String[][] stationOfLine = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};
        int idx = 0;
        for (String lineName : lineList) {
            Line newLine = new Line(lineName);
            for (String stationName : stationOfLine[idx]) {
                Station newStation = new Station(stationName);
                newLine.insertStationInLine(newStation);
            }
            LineRepository.addLine(newLine);
            idx++;
        }
    }
}

package subway;

import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

public class SubwayLineMapInitializer{
    private final List<String> stationsToAdd = Arrays
            .asList("교대역", "강남역", "역삼역", "남부터미녈역", "양재역", "매봉역", "양재시민의숲역");
    private final List<String> linesToAdd = Arrays.asList("2호선", "3호선", "신분당선");

    private StationController stationController = StationController.getStationController();
    private LineController lineController = LineController.getLineController();

    public void initialize(){
        try{
            addStations();
            addLines();
        }catch (Exception e){
            System.out.println("초기화 오류");
        }
    }

    private void addStations(){
        for(String stationName : stationsToAdd){
            stationController.addStation(stationName);
        }
    }

    private void addLines(){
        Station stationGyoDe = stationController.getStation(stationsToAdd.get(0));
        Station stationGangNam = stationController.getStation(stationsToAdd.get(1));
        Station stationYeokSam = stationController.getStation(stationsToAdd.get(2));
        Station stationNamBu = stationController.getStation(stationsToAdd.get(3));
        Station stationYangJe = stationController.getStation(stationsToAdd.get(4));
        Station stationMeBong = stationController.getStation(stationsToAdd.get(5));
        Station stationYangJeForest = stationController.getStation(stationsToAdd.get(6));
        lineController.addLine(linesToAdd.get(0), stationGyoDe, stationYeokSam);
        Line line2 = lineController.getLine(linesToAdd.get(0)).get();
        lineController.addStationInLineAtCertainPosition(stationGangNam, line2, 1);

        lineController.addLine(linesToAdd.get(1), stationGyoDe, stationMeBong);
        Line line3 = lineController.getLine(linesToAdd.get(1)).get();
        lineController.addStationInLineAtCertainPosition(stationNamBu, line3, 1);
        lineController.addStationInLineAtCertainPosition(stationYangJe, line3, 2);

        lineController.addLine(linesToAdd.get(2), stationGangNam, stationYangJeForest);
        Line lineShinBundang = lineController.getLine(linesToAdd.get(2)).get();
        lineController.addStationInLineAtCertainPosition(stationYangJe, lineShinBundang, 1);
    }
}

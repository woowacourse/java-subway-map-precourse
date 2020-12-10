package subway.domain;

import subway.view.MainMenu;
import subway.view.MainView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrainRouteMap {
    private List<String> stationNames= Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private List<String> lineNames=Arrays.asList("2호선", "3호선", "신분당선");
    private MainView mainView;
    private final Scanner scanner;

    public TrainRouteMap(Scanner scanner){
        this.scanner=scanner;
        this.mainView=new MainView();
        init();
    }

    public void run(){
        while(true){
            mainView.showMenu();
            MainMenu selected=mainView.selectMenu();
            if(selected==MainMenu.QUIT){
                break;
            }
            selected.request(selected.getKey());
        }
    }

    private void init(){
        stationNames.forEach(stationName->{StationRepository.addStation(new Station(stationName));});
        Line line=new Line(lineNames.get(0));//2호선 생성
        line.addAllStation(stationNames.get(0),stationNames.get(1),stationNames.get(2));
        LineRepository.addLine(line);
        line=new Line(lineNames.get(1));//3호선 생성
        line.addAllStation(stationNames.get(0),stationNames.get(3),stationNames.get(4),stationNames.get(6));
        LineRepository.addLine(line);
        line=new Line(lineNames.get(2));//신분당선 생성
        line.addAllStation(stationNames.get(1),stationNames.get(4),stationNames.get(5));
        LineRepository.addLine(line);
    }
}

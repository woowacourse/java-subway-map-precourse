package subway.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.view.Input;
import subway.view.Output;

public class SubwayController {
    public static boolean progress;
    public static Output output;
    
    public SubwayController(Scanner scanner) {
    	initialization();
        Input.scanner = scanner;
        output = new Output();
        progress = true;
    }
    
    public static void run() {
        while(progress) {
            output.printMainMenu();
            MainMenu.execute(Input.chooseFunction());
        }
    }
    
    public static void quit() {
        progress = false;
    }
    
    public void initialization() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
        for (String stationName : stations) {
            StationRepository.addStation(new Station(stationName));
        }
        for (String lineName : lines) {
            LineRepository.addLine(new Line(lineName));
        }
        LineRepository.addSection(LineRepository.getLineByName("2호선"), StationRepository.getStationByName("교대역"), 1);
        LineRepository.addSection(LineRepository.getLineByName("2호선"), StationRepository.getStationByName("강남역"), 2);
        LineRepository.addSection(LineRepository.getLineByName("2호선"), StationRepository.getStationByName("역삼역"), 3);
       
        LineRepository.addSection(LineRepository.getLineByName("3호선"), StationRepository.getStationByName("교대역"), 1);
        LineRepository.addSection(LineRepository.getLineByName("3호선"), StationRepository.getStationByName("남부터미널역"), 2);
        LineRepository.addSection(LineRepository.getLineByName("3호선"), StationRepository.getStationByName("양재역"), 3);
        LineRepository.addSection(LineRepository.getLineByName("3호선"), StationRepository.getStationByName("매봉역"), 4);
        
        LineRepository.addSection(LineRepository.getLineByName("신분당선"), StationRepository.getStationByName("강남역"), 1);
        LineRepository.addSection(LineRepository.getLineByName("신분당선"), StationRepository.getStationByName("양재역"), 2);
        LineRepository.addSection(LineRepository.getLineByName("신분당선"), StationRepository.getStationByName("양재시민의숲역"), 3);
    }
}
package subway.util;

import subway.domain.*;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class MainManager {
    StationManager stationManager = new StationManager();
    LineManager lineManager = new LineManager();
    SectionManager sectionManager = new SectionManager();

    public void appMain(Scanner scanner) {
        String inputString;
        init();
        while(true) {
            while(true) {
                try{
                    Constants.printMain();
                    inputString = scanner.nextLine().trim();
                    ErrorManager.checkInput(inputString);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            main(inputString, scanner);
        }
    }

    public void main(String input, Scanner scanner) {
            if (input.equals("Q")) {
                System.exit(0);
            } else if (input.equals("1")) {
                stationManager.stationMain(scanner);
            } else if (input.equals("2")) {
                lineManager.lineMain(scanner);
            } else if (input.equals("3")) {
                sectionManager.SectionMain(scanner);
            } else if (input.equals("4")) {
                printMap();
            }
    }

    public void printMap() {
        System.out.println(Constants.PRINT_MAP);
        for(Section section : SectionRepository.sections()) {
            System.out.println(section.getLine().getName());
            for(Station station : section.getStation()) {
                System.out.println(station.getName());
            }
            System.out.print("\n");
        }
    }

    public void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
        addSection("교대역", "2호선");
        addSection("강남역", "2호선");
        addSection("역삼역", "2호선");
        addSection("교대역", "3호선");
        addSection("남부터미널역", "3호선");
        addSection("양재역", "3호선");
        addSection("매봉역", "3호선");
        addSection("강남역", "신분당선");
        addSection("양재역", "신분당선");
        addSection("양재시민의숲역", "신분당선");
        System.out.println("hello");
    }

    public void addSection(String inputStation, String inputLine) {
        Station station = null;
        Line line = null;
        Section section = null;
        int check = 0;

        for(Section sec : SectionRepository.sections()) {
            if(sec.getLine().getName().equals(inputLine)) {
                section = sec;
                check = 1;
            }
        }
        for(Line ln : LineRepository.lines()) {
            if(ln.getName().equals(inputLine)) {
                line = ln;
            }
        }
        if(section == null) {
            section = new Section(line);
        }
        for(Station st : StationRepository.stations()) {
            if(st.getName().equals(inputStation)) {
                station = st;
            }
        }
        section.addStation(station);
        if(check == 0) {
            SectionRepository.addSection(section);
        }
    }

}

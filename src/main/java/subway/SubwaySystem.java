package subway;

import subway.line.LineService;
import subway.section.SectionService;
import subway.view.MainView;
import subway.view.PrintSubwayLineView;
import subway.view.line.LineDeleteView;
import subway.view.line.LineMenuView;
import subway.view.line.LineQueryView;
import subway.view.line.LineRegisterView;
import subway.view.section.SectionDeleteView;
import subway.view.section.SectionMenuView;
import subway.view.section.SectionRegisterView;
import subway.view.station.StationDeleteView;
import subway.view.station.StationMenuView;
import subway.view.station.StationQueryView;
import subway.view.station.StationRegisterView;

import java.util.Scanner;

public class SubwaySystem {

    private final Scanner scanner;

    public SubwaySystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        setDefaultValues();
        MainView mainView = setMainView();
        mainView.setVisible();
    }

    private void setDefaultValues() {
        LineService.registerLine("2호선", "교대역", "역삼역");
        SectionService.registerSection("2호선", "강남역", 2);

        LineService.registerLine("3호선", "교대역", "매봉역");
        SectionService.registerSection("3호선", "남부터미널역", 2);
        SectionService.registerSection("3호선", "양재역", 3);

        LineService.registerLine("신분당선", "강남역", "양재시민의숲역");
        SectionService.registerSection("신분당선", "양재역", 2);
    }

    private MainView setMainView() {
        MainView mainView = new MainView(scanner);
        mainView.add(setStationView());
        mainView.add(setLineView());
        mainView.add(setSectionView());
        mainView.add(new PrintSubwayLineView());
        return mainView;
    }

    private StationMenuView setStationView() {
        StationMenuView stationMenuView = new StationMenuView();
        stationMenuView.add(new StationRegisterView());
        stationMenuView.add(new StationDeleteView());
        stationMenuView.add(new StationQueryView());
        return stationMenuView;
    }

    private LineMenuView setLineView() {
        LineMenuView lineMenuView = new LineMenuView();
        lineMenuView.add(new LineRegisterView());
        lineMenuView.add(new LineDeleteView());
        lineMenuView.add(new LineQueryView());
        return lineMenuView;
    }

    private SectionMenuView setSectionView() {
        SectionMenuView sectionMenuView = new SectionMenuView();
        sectionMenuView.add(new SectionRegisterView());
        sectionMenuView.add(new SectionDeleteView());
        return sectionMenuView;
    }
}

package subway;

import subway.controller.MainController;
import subway.domain.*;

public class Application {

    public static void main(String[] args) {
        initiate();
        MainController.getInstance().action();
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

        Line 호선2 = LineRepository.findLine("2호선");
        Section 호선2구간 = new Section();
        호선2구간.initiateSection(StationRepository.findStation("교대역"),
                StationRepository.findStation("역삼역"));
        SectionRepository.addSection(호선2, 호선2구간);

        Line 호선3 = LineRepository.findLine("3호선");
        Section 호선3구간 = new Section();
        호선3구간.initiateSection(StationRepository.findStation("교대역"),
                StationRepository.findStation("매봉역"));
        SectionRepository.addSection(호선3, 호선3구간);
        호선3구간.getSection().add(1,StationRepository.findStation("양재역"));
        호선3구간.getSection().add(1,StationRepository.findStation("남부터미널역"));

        Line 신분당 = LineRepository.findLine("신분당선");
        Section 신분당구간 = new Section();
        신분당구간.initiateSection(StationRepository.findStation("강남역"),
                StationRepository.findStation("양재시민의숲역"));
        SectionRepository.addSection(신분당, 신분당구간);
        신분당구간.getSection().add(1,StationRepository.findStation("양재역"));
    }
}

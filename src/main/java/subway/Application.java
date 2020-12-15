package subway;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
	private static final String[] DEFAULT_STATIONS = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
	private static final String[] DEFAULT_LINES = { "2호선", "3호선", "신분당선" };

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: �봽濡쒓렇�옩 援ы쁽
		StationRepository stationRepositiory = new StationRepository();
		LineRepository lineRepositiory = new LineRepository();

		defaultStation(stationRepositiory, lineRepositiory);

		stationRepositiory.viewStations();
		System.out.println("=====================");
		lineRepositiory.viewLineRepository();

	}

	private static void defaultStation(StationRepository stationRepositiory, LineRepository lineRepositiory) {
		for (int defaultStation = 0; defaultStation < DEFAULT_STATIONS.length; defaultStation++) {
			createStation(stationRepositiory, DEFAULT_STATIONS[defaultStation]);
		}

		for (int defaultLine = 0; defaultLine < DEFAULT_LINES.length; defaultLine++) {
			createLine(lineRepositiory, DEFAULT_LINES[defaultLine]);
		}

		Line lineTwo = lineRepositiory.findStation("2호선");
		lineTwo.startStation(stationRepositiory.findStation("교대역"));
		lineTwo.endStation(stationRepositiory.findStation("역삼역"));
		lineTwo.addStation(stationRepositiory, "강남역", 2);

		Line lineThree = lineRepositiory.findStation("3호선");
		lineThree.startStation(stationRepositiory.findStation("교대역"));
		lineThree.endStation(stationRepositiory.findStation("매봉역"));
		lineThree.addStation(stationRepositiory, "남부터미널역", 2);
		lineThree.addStation(stationRepositiory, "양재역", 3);

		Line lineNewBundang = lineRepositiory.findStation("신분당선");
		lineNewBundang.startStation(stationRepositiory.findStation("강남역"));
		lineNewBundang.endStation(stationRepositiory.findStation("양재시민의숲역"));
		lineNewBundang.addStation(stationRepositiory, "양재역", 2);
	}

	public static StationRepository createStation(StationRepository stationRepositiory, String name) {
		Station station = new Station(name);
		stationRepositiory.addStation(station);
		return stationRepositiory;
	}

	public static LineRepository createLine(LineRepository lineRepositiory, String name) {
		Line line = new Line(name);
		lineRepositiory.addLine(line);
		return lineRepositiory;
	}
}
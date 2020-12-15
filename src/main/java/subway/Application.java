package subway;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
	private static final String[] DEFAULT_STATIONS = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
	private static final String[] DEFAULT_LINES = { "2호선", "3호선", "신분당선" };
	private static final String MAIN_SELECT_MESSAGE = "## 메인화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n"
			+ "4. 지하철 노선도 출력" + "\n" + "Q. 종료\n" + "\n" + "## 원하는 기능을 선택하세요.";
	private static final String STATION_SELECT_MESSAGE = "\n## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n"
			+ "B. 돌아가기" + "\n\n" + "## 원하는 기능을 선택하세요.";

	private static final String NEW_STATION_MESSAGE = "\n## 등록할 역 이름을 입력하세요.";
	private static final String CREATE_STATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.";
	private static final String ERROR_CREATE_STATION_MESSAGE = "[ERROR] 중복된 지하철역 이름이 등록있습니다.";
	private static final String ERROR_CREATE_STATION_LENGHT_MESSAGE = "[ERROR] 2글자 이상에 이름만 가능합니다.";
	private static final String DELETE_STATION_INPUT = "\n## 삭제할 역 이름을 입력하세요.";
	private static final String DELETE_STATION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.";
	private static final String ERROR_DELETE_STATION_MESSAGE = "[ERROR] 없는 지하철역 이름입니다.";
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요";
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: �봽濡쒓렇�옩 援ы쁽
		StationRepository stationRepositiory = new StationRepository();
		LineRepository lineRepositiory = new LineRepository();

		defaultStation(stationRepositiory, lineRepositiory);
		while (true) {
			System.out.println(MAIN_SELECT_MESSAGE);
			String Select = scanner.next();
			if (Select.equals("1")) {
				stationManagement(scanner, stationRepositiory, lineRepositiory);
			}
		}
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
		if(name.length()<2)
		{
			System.out.println(ERROR_CREATE_STATION_LENGHT_MESSAGE);
			return stationRepositiory;
		}
		Station station = new Station(name);
		stationRepositiory.addStation(station);
		System.out.println(CREATE_STATION_MESSAGE + "\n");
		return stationRepositiory;
	}

	public static LineRepository createLine(LineRepository lineRepositiory, String name) {
		Line line = new Line(name);
		lineRepositiory.addLine(line);
		return lineRepositiory;
	}

	public static void stationManagement(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		while (true) {
			System.out.println(STATION_SELECT_MESSAGE);
			String Select = scanner.next();
			if (Select.equals("1")) {
				newStation(scanner, stationRepositiory, lineRepositiory);
				return;
			}
			if (Select.equals("2")) {
				deleteStation(scanner, stationRepositiory, lineRepositiory);
				return;
			}
			if (Select.equals("3")) {
				statusStation(stationRepositiory);
				return;
			}
			if (Select.equals("B")) {
				return;
			}
			System.out.println(ERROR_INPUT_MESSAGE);
		}
	}

	public static void newStation(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		System.out.println(NEW_STATION_MESSAGE);
		String station = scanner.next();
		if(stationRepositiory.findStation(station)==null)
		{
			createStation(stationRepositiory, station);
			return;
		}
		System.out.println(ERROR_CREATE_STATION_MESSAGE+ "\n");
	}

	public static void deleteStation(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		System.out.println(DELETE_STATION_INPUT);
		String station = scanner.next();
		if(stationRepositiory.findStation(station)!=null)
		{
			stationRepositiory.deleteStation(station);
			System.out.println(DELETE_STATION_MESSAGE + "\n");
			return;
		}
		System.out.println(ERROR_DELETE_STATION_MESSAGE);
	}
	public static void statusStation(StationRepository stationRepositiory) {
		stationRepositiory.viewStations();
	}
}
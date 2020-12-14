package subway;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {
	private static final List<String> SECOND_LINE = Arrays.asList("교대역", "강남역", "역삼역");
	
	private static final List<String> THIRD_LINE = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
	
	private static final List<String> SINBUNDANG_LINE = Arrays.asList("강남역", "양재역", "양재시민의숲역");
	
	private static final List<String> INITIAL_STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
	
	private static final HashMap<String, List<String>> INITIAL_LINES = new HashMap<>() {
		{
			put("2호선", SECOND_LINE);
			put("3호선", THIRD_LINE);
			put("신분당선", SINBUNDANG_LINE);
		}
	};
	
	public static void run() {
		initStation();
		initLine();
	}
	
	private static void initStation() {
		for (String name: INITIAL_STATIONS) {
			StationRepository.addStation(new Station(name));
		}
	}
	
	private static void initLine() {
		for (Entry<String, List<String>> line: INITIAL_LINES.entrySet()) {
			LineRepository.addLine(new Line(line.getKey(), line.getValue()));
		}
	}
}

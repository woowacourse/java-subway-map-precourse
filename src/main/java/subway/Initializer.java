package subway;

import java.util.ArrayList;
import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {
	private static final List<String> INITIAL_STATIONS = new ArrayList<>() {
		{
			add("교대역");
			add("강남역");
			add("역삼역");
			add("남부터미널역");
			add("양재역");
			add("양재시민의숲역");
			add("매봉역");
		}
	};
	
	public static void run() {
		initStation();
	}
	
	private static void initStation() {
		for (String name: INITIAL_STATIONS) {
			StationRepository.addStation(new Station(name));
		}
	}
}

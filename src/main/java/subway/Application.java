package subway;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
	private static final String[] DEFAULT_STATIONS = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: �봽濡쒓렇�옩 援ы쁽
		StationRepository stationRepo = new StationRepository();
		
		defaultStation(stationRepo);
		
		stationRepo.viewStations();
	}

	private static void defaultStation(StationRepository stationRepo) {
		for (int defaultStation = 0; defaultStation < DEFAULT_STATIONS.length; defaultStation++) {
			createStation(stationRepo, DEFAULT_STATIONS[defaultStation]);
		}

	}

	public static StationRepository createStation(StationRepository stationRepo, String name) {
		Station station = new Station(name);
		stationRepo.addStation(station);
		return stationRepo;
	}

}
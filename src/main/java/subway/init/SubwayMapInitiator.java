package subway.init;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.StationNameVaildator;

public class SubwayMapInitiator {
	private static final Integer ZERO = 0;
	private static final String[] lineNames = { "2호선", "3호선", "신분당선" };
	private static final String[][] stationNames = { { "교대역", "강남역", "역삼역" }, { "교대역", "남부터미널역", "양재역" },
			{ "매봉역", "강남역", "양재역", "양재시민의숲역" } };

	public static void initiateRepository() {
		for (int row = ZERO; row < lineNames.length; row++) {
			Line line = new Line(lineNames[row]);
			for (int col = ZERO; col < stationNames[row].length; col++) {
				String stationName = stationNames[row][col];
				line.addStation(col, new Station(stationName));
				try {
					StationNameVaildator.check(stationName);
					StationRepository.addStation(new Station(stationName));
				} catch (IllegalArgumentException e) {
					// Do nothing
				}
			}
			LineRepository.addLine(line);
		}
	}
}

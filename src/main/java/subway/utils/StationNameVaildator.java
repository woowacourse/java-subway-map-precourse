package subway.utils;

import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationNameVaildator {
	private static final Integer MIN_NAME_LENGTH = 2;
	private static final String NOT_ENOUGH_LENGTH_MESSAGE = "역 이름은 2글자 이상 입력하셔야 합니다.";
	private static final String NOT_UNIQUE_MESSAGE = "이미 등록되어 있는 역입니다.";

	public static void check(String name) {
		if (!isEnoughLength(name)) {
			throw new IllegalArgumentException(NOT_ENOUGH_LENGTH_MESSAGE);
		}
		if (!isUniqueName(name)) {
			throw new IllegalArgumentException(NOT_UNIQUE_MESSAGE);
		}
	}

	private static boolean isUniqueName(String name) {
		List<Station> stations = StationRepository.stations();
		for (Station station : stations) {
			if (station.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isEnoughLength(String name) {
		if (name.length() < MIN_NAME_LENGTH) {
			return false;
		}
		return true;
	}
}

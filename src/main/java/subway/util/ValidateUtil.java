package subway.util;

import subway.domain.LineRepository;
import subway.domain.Station;

public class ValidateUtil {
    public static boolean canDeleteStation(Station station) {
        if (LineRepository.lines().containsStation(station)) {
            return true;
        }
        throw new IllegalStateException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
    }
}

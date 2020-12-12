package subway.service;

import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineService {
    private static final String DUPLICATE_ERROR = "[ERROR] 이미 등록된 노선 이름입니다.\n";
    private static final String NOT_DELETE_ERROR = "[ERROR] 삭제할 수 없습니다.\n";
    private static final String NOT_EXIST_ERROR = "[ERROR] 등록할 수 없습니다.\n";

    public static void register(String lineName, String upTrainLastStationName
        , String downTrainLastStationName) {
        if (hasSameName(lineName)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
        if(!StationService.hasSameName(upTrainLastStationName) && !StationService.hasSameName(downTrainLastStationName))
        {
            throw new IllegalArgumentException(NOT_EXIST_ERROR);
        }
        LineRepository.addLine(new Line(lineName),new Station(upTrainLastStationName)
            ,new Station(downTrainLastStationName));
    }

    public static void delete(String lineName){
        if(!LineRepository.deleteLineByName(lineName)){
            throw new IllegalArgumentException(NOT_DELETE_ERROR);
        }
    }

    public static boolean hasSameName(String lineName) {
        Optional<Line> findLine = LineRepository.findByName(lineName);
        return findLine.isPresent();
    }
}

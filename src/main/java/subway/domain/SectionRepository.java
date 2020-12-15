package subway.domain;

import subway.Constant;

import java.util.*;

public class SectionRepository {
    private static LineRepository lineRepository = new LineRepository();
    private static StationRepository stationRepository = new StationRepository();

    public static void addSection(String lineName, String stationName, int order) {
        if (!lineRepository.checkExistLine(lineName)) { // 존재하지 않는 노선
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_LINE_INFO));
            return;
        } else if (!stationRepository.checkExistStation(stationName)) { // 존재하지 않는 역
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_STATION_INFO));
            return;
        }
        try{
            Line targetLine = lineRepository.lines.stream().filter(l -> lineName.equals(l.getName())).findFirst().get();
            targetLine.stations.add(order, new Station(stationName));
        }catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
//            System.out.println(String.join(" ", Constant.ERROR_PREFIX, "추가할 수 없는 구간입니다."));
//            return;
        }
        System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_LINE_SUCCESS));
    }

    public static boolean deleteSection(String lineName, String stationName) {
        if (!lineRepository.checkExistLine(lineName)) { // 존재하지 않는 노선
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_LINE_INFO));
        }else if(!stationRepository.checkExistStation(stationName)){ // 존재하지 않는 역
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_STATION_INFO));
        }
        List<Station> stations = lineRepository.lines.stream().filter(l -> lineName.equals(l.getName())).findFirst().get().stations;
        return stations.removeIf(s -> Objects.equals(s.getName(), stationName));
    }


    public static void printMap(){
        for(int i=0; i<lineRepository.lines.size(); i++){
            System.out.print(String.join(" ", Constant.INFO_PREFIX, lineRepository.lines.get(i).getName()));
            for(int j=0; j<lineRepository.lines.get(i).stations.size(); j++){
                System.out.print(lineRepository.lines.get(i).stations.get(j).getName() + " " );
            }
        }
    }

}

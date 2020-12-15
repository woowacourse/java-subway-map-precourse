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
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, "추가할 수 없는 구간입니다."));
            return;
        }
        System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_LINE_SUCCESS));
    }

    public static boolean deleteSection(String lineName, String stationName) {
        if (!lineRepository.checkExistLine(lineName)) { // 존재하지 않는 노선
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_LINE_INFO));
        }else if(!stationRepository.checkExistStation(stationName)){ // 존재하지 않는 역
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_STATION_INFO));
        }

        return false;
    }

//    public static void printSections(){
//        map.entrySet().forEach(entry->{
//            System.out.println("key -> " + entry.getKey().getName());
////                    + " " + entry.getValue());
//            for(int i=0; i<entry.getValue().size(); i++){
//                System.out.print("value -> " + entry.getValue().get(i).getName() + " ");
//            }
//        });
//    }

}

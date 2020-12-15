package subway.domain;

import subway.view.OutputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
            stations.add(station);
    }
    public void initializeAddStation(String[] station){
        for(int i=0;i<station.length;i++){
            stations.add(new Station(station[i]));
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
    public static boolean lengthStationName(String name){

        if(name.length()<2){

            return false;
        }

        return true;
    }
    public static boolean duplicateStationName(String tmpSaveName){

        for(int i=0;i<stations.size();i++){
            if(stations.get(i).getName().equals(tmpSaveName)){
                return false;
            }
        }
        return true;
    }
    public static void print(){
        for(int i=0;i<stations.size();i++){
            System.out.println(stations.get(i).getName());
        }
    }
    public static boolean checkingStationName(String tmpSaveName){
        for(Station station:stations){
            if(station.getName().equals(tmpSaveName)){
                return true;
            }
        }
        return false;
    }
}

package subway;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: �봽濡쒓렇�옩 援ы쁽
        StationRepository stationRepo = new StationRepository();
        
        stationRepo.sizeStation();
        
        createStation(stationRepo, "교대역");
        
        stationRepo.sizeStation();
    }
    
    
    static public StationRepository createStation(StationRepository stationRepo, String name)
    {
    	Station station = new Station(name);
    	stationRepo.addStation(station);
    	return stationRepo;
    }
}
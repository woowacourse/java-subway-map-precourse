package output;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SubwayMap {
    public final static String HEAD = "## ";
    public final static String SUBWAY_MAP = "지하철 노선도";
    public final static String INFO = "[INFO] ";


    public static void visualize(){
        System.out.println(HEAD+ SUBWAY_MAP);
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO + line.getName());
            System.out.println("---");
            printLineStations(line);
        }
    }

    private static void printLineStations(Line line){
        for(Station station : line.getLineStations()){
            System.out.println(INFO + station.getName());
        }
    }
}

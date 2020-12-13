package output;

import exception.NullRepositoryException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SubwayMap {
    public final static String HEAD = "## ";
    public final static String SUBWAY_MAP = "지하철 노선도";
    public final static String INFO = "[INFO] ";
    public final static String CONTOUR = "---";


    public static void visualize(){
        if(LineRepository.lines().size() == 0)
            throw new NullRepositoryException();

        System.out.println(HEAD+ SUBWAY_MAP);
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO + line.getName());
            System.out.println(CONTOUR);
            printLineStations(line);
        }
    }

    private static void printLineStations(Line line){
        for(Station station : line.getLineStations()){
            System.out.println(INFO + station.getName());
        }
    }
}

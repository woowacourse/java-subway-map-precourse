package subway.domain;

import subway.view.OutputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Boolean addLine(Line line) {
        System.out.println("addline 실행");
        if(!(line.getName()==null)){
            lines.add(line);
        }
        System.out.println(line.getName());
        return false;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    public static void printLine(){
        for(int i=0;i<lines.size();i++){
            System.out.println("[INFO] "+lines.get(i).getName());
        }
    }
    public static boolean back(){
        return false;
    }
    public static Line getLine(String tmpSaveLine){
        for(int i=0;i<lines.size();i++){
            if(lines.get(i).getName().equals(tmpSaveLine)){
                return lines.get(i);
            }
        }
        return null;
    }
    public static void printAllLineInStation() {
        OutputMessage.stationInLineMessage();

        for (Line tmpLine : lines) {

            System.out.println("[INFO] "+tmpLine.getName());
            System.out.println("[INFO] ---");
            tmpLine.printAllStationInLine();

        }
    }
    public static boolean checkingAllLine(String tmpSaveStationName){
        for(Line line:lines){
            if(line.checkingAStationInLine(tmpSaveStationName)){
                return true;
            }
        }
        return false;
    }

}

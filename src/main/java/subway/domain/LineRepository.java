package subway.domain;

import subway.view.OutputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String INFO_MESSAGE="[INFO] ";
    private static final String DIVIDE_INFO_MESSAGE="[INFO] ---";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        lines.add(line);
        return false;
    }
    public static boolean duplicateLineName(Line line){
        for(int i=0;i<lines.size();i++){
            if(lines.get(i).getName().equals(line.getName())){
                return true;
            }
        }
        return false;
    }
    public static boolean lengthLineName(Line line){
        if(line.getName().length()<2){
            return true;
        }
        return false;
    }
    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    public static void printLine(){
        for(int i=0;i<lines.size();i++){
            System.out.println(INFO_MESSAGE+lines.get(i).getName());
        }
        System.out.println();
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
            System.out.println(INFO_MESSAGE+tmpLine.getName());
            System.out.println(DIVIDE_INFO_MESSAGE);
            tmpLine.printAllStationInLine();

        }
    }
    public static boolean checkingAllLine(String tmpSaveStationName){
        for(Line line:lines){
            if(line.getName().equals(tmpSaveStationName)){
                return true;
            }
        }
        return false;
    }

}

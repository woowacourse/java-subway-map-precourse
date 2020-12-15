package subway.domain;


import subway.view.OutputMessage;
import subway.domain.Station;
import java.util.ArrayList;
import java.util.List;
import subway.domain.StationRepository;
public class Line {
    private String name;
    private static final String INFO_MESSAGE="[INFO] ";
    OutputMessage outputMessage=new OutputMessage();
    private StationRepository stationRepository= new StationRepository();
    private List<Station> stationInLine=new ArrayList<>();

    private String tmpSaveDownStation;
    public Line(String name){
        this.name=name;
    }
    // 추가 기능 구현
    public Line(String name,String upStation,String downStation) {
            stationInLine.add(new Station(upStation));
            stationInLine.add(new Station(downStation));
            this.name = name;
    }
    public void initializeLine(String[] station){
        for(String tmpStation:station) {
            stationInLine.add(new Station(tmpStation));
        }

    }
    public String getName() {
        return name;
    }
    public void addSectionLine(String tmpSaveStation,int index){
        StationRepository.addStation(new Station(tmpSaveStation));
        stationInLine.add((index),new Station(tmpSaveStation));
    }
    public boolean deleteSectionLine(String tmpSaveStation){
        stationInLine.remove(findStation(tmpSaveStation));
        return true;
    }
    public Station findStation(String tmpSaveStation){
        for(Station station: stationInLine){
            if(station.getName().equals(tmpSaveStation)){
                return station;
            }
        }
        return null;
    }
    public void printAllStationInLine(){

        for(int i=0;i<stationInLine.size();i++){
            System.out.println(INFO_MESSAGE+stationInLine.get(i).getName());
        }
        System.out.println();
    }
    public boolean checkingAStationInLine(String tmpSaveStationName){
        for(Station station:stationInLine){
            if(station.getName().equals(tmpSaveStationName)){
                return true;
            }
        }
        return false;
    }
    public int getLineInStationNumber(){
        return stationInLine.size();
    }
}

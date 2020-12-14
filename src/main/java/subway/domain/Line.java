package subway.domain;


import subway.view.OutputMessage;
import subway.domain.Station;
import java.util.ArrayList;
import java.util.List;
import subway.domain.StationRepository;
public class Line {
    private String name;
    OutputMessage outputMessage=new OutputMessage();
    private StationRepository stationRepository= new StationRepository();
    private List<Station> stationInLine=new ArrayList<>();

    private String tmpSaveDownStation;
    public Line(String name){
        this.name=name;
    }
    public Line(String name,String upStation) {
        System.out.println("line생성");
        if(registerLineJongJum(upStation)){
            stationInLine.add(new Station(upStation));
            stationInLine.add(new Station(tmpSaveDownStation));
            this.name = name;
        }
        System.out.println("라인생성끝");
    }
    public void initializeLine(String[] station){
        for(String tmpStation:station)
        stationInLine.add(new Station(tmpStation));
    }
    public boolean registerLineJongJum(String upStation){

        if(stationRepository.containStationName(upStation)){
            tmpSaveDownStation=outputMessage.registerLineDownStation();
            if(stationRepository.containStationName(tmpSaveDownStation)){
                return true;
            }

        }
        System.out.println("작동안되지");
        return false;
    }
    public String getName() {
        return name;
    }
    public void addSectionLine(String tmpSaveStation,int index){
        StationRepository.addStation(new Station(tmpSaveStation));
        stationInLine.add((index),new Station(tmpSaveStation));
    }
    public boolean deleteSectionLine(String tmpSaveStation){
        if(stationInLine.size()<=2){
            return true;
        }
        StationRepository.deleteStation(tmpSaveStation);
        stationInLine.remove(tmpSaveStation);
        return true;
    }
    // 추가 기능 구현
}

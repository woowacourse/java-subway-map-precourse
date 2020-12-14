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
    private String tmpSaveUpStation;
    private String tmpSaveDownStation;
    public Line(String name) {
        System.out.println("line생성");
        if(registerLineJongJum()){
            stationInLine.add(new Station(tmpSaveUpStation));
            stationInLine.add(new Station(tmpSaveDownStation));
            this.name = name;
        }
        System.out.println("라인생성끝");
    }
    public boolean registerLineJongJum(){

        tmpSaveUpStation=outputMessage.registerLineUpStation();
        System.out.println("2323");
        if(stationRepository.containStationName(tmpSaveUpStation)){
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

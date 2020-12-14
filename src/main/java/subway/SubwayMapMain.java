package subway;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputMessage;
import java.util.Scanner;

public class SubwayMapMain {
    OutputMessage outputMessage=new OutputMessage();
    public SubwayMapMain(Scanner scanner){
        System.out.println("Ds");
        startSubwayMap();
    }
    public void startSubwayMap(){
        {
            initialize();
            while(true) {
                outputMessage.mainOutputMessage();
                MainFunctionChoice choice = MainFunctionChoice.mainFunctionInput();
                choice.doingFunction(choice.getChoiceNumber());
            }
        }
    }

    public void initialize(){
        StationRepository stationRepository =new StationRepository();
        String[] station={"교대역","강남역","역삼역","남부터미널역","양재역","양재시민의숲역","매봉역"};
        stationRepository.initializeAddStation(station);
        String[] line2={"교대역","강남역","역삼역"};
        String[] line3={"교대역","강남역","남부터미널역","양재역","매봉역"};
        String[] lineShin={"교대역","양재역","양재시민의숲역"};
        Line line = new Line("2호선");
        line.initializeLine(line2);
        LineRepository.addLine(line);
        line = new Line("3호선");
        line.initializeLine(line3);
        LineRepository.addLine(line);
        line = new Line("신분당선");
        line.initializeLine(lineShin);
        LineRepository.addLine(line);


    }





}

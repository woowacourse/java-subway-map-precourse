package subway.view;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagementScreen implements Screen{

    @Override
    public void start() {
        System.out.println("\n## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createUserSelectionInput(3,"B");

        if(userInput == 1){
            registerNewStation();
            return;
        }
        if(userInput == 2){
            deleteStation();
            return;
        }
        if(userInput == 3){
            System.out.println("\n## 역 목록");
            StationRepository.printStations();
            MainScreen mainScreen = new MainScreen();
            mainScreen.start();
        }
    }
    public void registerNewStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        try {
            StationRepository.addStation(new Station(InputUtils.createUserStationInput()));
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            registerNewStation();
            return;
        }
        MainScreen mainScreen = new MainScreen();
        mainScreen.start();
    }

    public void deleteStation(){
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        try{
            StationRepository.deleteStation(InputUtils.createUserStationInput());
        }
        catch (IllegalArgumentException e){
            System.err.println("[ERROR] 잘못된 입력입니다.");
        }
        finally {
            MainScreen mainScreen = new MainScreen();
            mainScreen.start();
        }
    }
}

package subway.view;

public class MainScreen implements Screen{

    @Override
    public void start() {
        System.out.println("\n## 메인 화면 \n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n");

        int userInput = InputUtils.createUserSelectionInput(4,"Q");

        if(userInput == 1){
            StationManagementScreen stationManagementScreen = new StationManagementScreen();
            stationManagementScreen.start();
            return;
        }
        if(userInput == 2){
            LineManagementScreen lineManagementScreen = new LineManagementScreen();
            lineManagementScreen.start();
            return;
        }
        if(userInput == 3){
            SectionManagementScreen sectionManagementScreen = new SectionManagementScreen();
            sectionManagementScreen.start();
            return;
        }
    }
}

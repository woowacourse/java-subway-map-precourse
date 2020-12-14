package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineManagementScreen;
import subway.view.MainScreen;
import subway.view.SectionManagementScreen;
import subway.view.StationManagementScreen;

public class Load {
    public static void loadMainScreen(){
        MainScreen mainScreen = MainScreen.getInstance();
        mainScreen.show();
    }

    public static void loadStationManagementScreen(){
        StationManagementScreen stationManagementScreen = StationManagementScreen.getInstance();
        stationManagementScreen.show();
    }

    public static void loadLineManagementScreen(){
        LineManagementScreen lineManagementScreen = LineManagementScreen.getInstance();
        lineManagementScreen.show();
    }

    public static void loadSectionManagementScreen(){
        SectionManagementScreen sectionManagementScreen = SectionManagementScreen.getInstance();
        sectionManagementScreen.show();
    }
}

package subway;

import subway.domain.InitSubway;
import subway.subwaymanager.MainSelectManager;

public class SubwayRun {
    public static void run() {
        InitSubway.initSubway();
        MainSelectManager.mainSelectManager();
    }
}

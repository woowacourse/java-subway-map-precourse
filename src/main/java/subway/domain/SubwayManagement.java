package subway.domain;

public class SubwayManagement {

    public void start() {
        InitSetting.initSetting();

        MainMenu.executeMain();
    }

}

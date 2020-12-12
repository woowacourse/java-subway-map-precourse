package subway;

public class Application {
    public static void main(String[] args) {
        StationManageConfig stationManageConfig = new StationManageConfig();
        DataInitService dataInitService = new DataInitService(stationManageConfig);
        dataInitService.init();

        StationManageApp stationManageApp = StationManageApp.of(stationManageConfig);
        stationManageApp.startManage();
    }
}

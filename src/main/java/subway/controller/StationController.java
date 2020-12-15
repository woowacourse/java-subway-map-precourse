package subway.controller;

public class StationController {
    private static StationController stationController;

    public static StationController getInstance() {
        if (stationController==null) {
            stationController = new StationController();
        }
        return stationController;
    }


    public Boolean registerStation() {
    }

    public Boolean deleteStation() {
    }

    public Boolean inquiryStation() {
    }

    public Boolean back() {
    }
}

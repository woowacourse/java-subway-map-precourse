package subway.controller;

import subway.domain.Station;
import subway.service.StationService;
import subway.view.Input;
import subway.view.Output;

public class StationController implements IController{

    private StationController() {}

    @Override
    public void save() {
        try {
            StationService.save(new Station(Input.input(Input.PLEASE_INPUT_STATION_MESSAGE)));
        } catch (IllegalArgumentException e) {
            Output.printNewLine();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove() {
        try{
            Output.printNewLine();
            StationService.remove(Input.input(Input.PLEASE_INPUT_REMOVE_STATION_NAME));
        } catch (IllegalArgumentException e) {
            Output.printNewLine();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getList() {
        Output.printByList(StationService.getAllStations());
    }

    public static StationController getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final StationController INSTANCE = new StationController();
    }
}

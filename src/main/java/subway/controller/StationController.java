package subway.controller;

import subway.domain.Station;
import java.util.List;

public class StationController implements IController{

    private StationController() {}

    @Override
    public void save() {
    }

    @Override
    public void remove() {
    }

    @Override
    public List<Station> getList() {
        return null;
    }

    public static StationController getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final StationController INSTANCE = new StationController();
    }
}

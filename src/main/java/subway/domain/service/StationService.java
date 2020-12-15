package subway.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Station;
import subway.domain.repository.StationRepository;
import utils.Category;
import utils.ScriptUtils;

public class StationService {
    private StationService() {}

    public static void createStation(String name) {
        try {
            if (duplicateName(name)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_DUPLICATE(Category.STATION));
            return;
        }
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public static void readStationList() {
        System.out.println(ScriptUtils.STATION_LIST);
        for (Station station : StationRepository.stations()) {
            System.out.println(ScriptUtils.INFO + station.getName());
        }
    }

    public static void deleteStation(String name) {
        try {
            if (!duplicateName(name)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_NO(Category.STATION));
            return;
        }
        StationRepository.deleteStation(name);
    }

    public static boolean duplicateName(String input) {
        boolean notDuplicate = StationRepository.findNoStation(input);
        if (notDuplicate) {
            return false;
        }
        return true;
    }

    public static Station readStation(String name) {
        return StationRepository.readStation(name).get(0);
    }
}

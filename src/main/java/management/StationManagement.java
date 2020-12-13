package management;

import exception.NoExistStationNameException;
import exception.NoneFunctionException;
import exception.NullRepositoryException;
import input.Input;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagement {
    public final static String ENROLL_STATION_NAME = "등록할 역 이름을 입력하세요.";
    public final static String DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    public final static String INFO = "[INFO] ";
    public final static String[] BUTTON = {"1", "2", "3", "B"};


    public static void stationManagement(String answer, Input input) {
        if (answer.equals(BUTTON[0]))
            insert(input);
        if (answer.equals(BUTTON[1]))
            delete(input);
        if (answer.equals(BUTTON[2]))
            allList();
        checkFunctionButton(answer);
    }

    private static void insert(Input input) {
        System.out.println(ENROLL_STATION_NAME);
        StationRepository.addStation(new Station(input.inputStationName()));
    }

    private static void delete(Input input) {
        System.out.println(DELETE_STATION_NAME);
        if (!StationRepository.deleteStation(input.inputStationName())) {
            throw new NoExistStationNameException();
        }
    }

    private static void allList() {
        if (StationRepository.stations().size() == 0) {
            throw new NullRepositoryException();
        }
        for (Station station : StationRepository.stations()) {
            System.out.println(INFO + station.getName());
        }
        System.out.println();
    }

    private static boolean checkFunctionButton(String answer) {
        if (answer.equals(BUTTON[0]) || answer.equals(BUTTON[1]) || answer.equals(BUTTON[2]) || answer.equals(BUTTON[3]))
            return true;
        throw new NoneFunctionException();
    }
}

package subway.domain.management;

import subway.Constant;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;


public class StationManager extends ServiceManager {

    public StationManager(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void doStationManagement() {
        OutputView.printManagementView(ServiceList.STATION, menuList);
        String inputData = getInputData(scanner);

        try {
            if(inputData.equals(ManagementMenu.REGISTER.getOrder())){
                registerStation();
                return;
            }
            if(inputData.equals(ManagementMenu.FIND.getOrder())){
                findStation();
                return;
            }
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            doStationManagement();
        }

    }

    private void findStation() {
        OutputView.printStationList(StationRepository.stations(), ServiceList.STATION.getName());
    }

    private void registerStation() {
        String name = getStationName();
        Station station = new Station(name);
        List<Station> stations = StationRepository.stations();

        if(stations.contains(station)){
            OutputView.printErrorWithFormat(Constant.REGISTER_DUPLICATE_DATA_ERROR_FORMAT, ServiceList.STATION.getName());
            return;
        }

        StationRepository.addStation(station);
        OutputView.printFunctionResult(Constant.REGISTER_RESULT_FORMAT, ServiceList.STATION.getName());
        return;
    }

    private String getStationName() {
        OutputView.printInputData(Constant.INPUT_DATA_REGISTER_FORMAT, ServiceList.STATION.getName());
        String data = InputView.inputData(scanner);
        return data;
    }


    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.FIND);
        menuList.add(ManagementMenu.BACK);
    }
}

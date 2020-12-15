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
            checkInputData(inputData);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            doStationManagement();
        }

    }

    private void checkInputData(String inputData) {
        if(inputData.equals(ManagementMenu.REGISTER.getOrder())){
            registerStation(ManagementMenu.REGISTER);
            return;
        }
        if(inputData.equals(ManagementMenu.DELETE.getOrder())){
            deleteStation(ManagementMenu.DELETE);
            return;
        }
        if(inputData.equals(ManagementMenu.FIND.getOrder())){
            findStation();
            return;
        }
    }

    private void deleteStation(ManagementMenu menu) {
        String name = getStationName(menu);

        for(Station savedStation : StationRepository.stations()){
            if(savedStation.getName().equals(name)){
                OutputView.printFunctionResult(Constant.DELETE_RESULT_FORMAT, ServiceList.STATION.getName());
                StationRepository.deleteStation(name);
                return;
            }
        }

        OutputView.printErrorWithFormat(Constant.DELETE_DATA_ERROR_FORMAT, ServiceList.STATION.getName());
        return;
    }

    private void findStation() {
        OutputView.printStationList(StationRepository.stations(), ServiceList.STATION.getName());
    }

    private void registerStation(ManagementMenu menu) {
        String name = getStationName(menu);

        for(Station savedStation : StationRepository.stations()){
            if(savedStation.getName().equals(name)){
                OutputView.printErrorWithFormat(Constant.REGISTER_DUPLICATE_DATA_ERROR_FORMAT, ServiceList.STATION.getName());
                return;
            }
        }

        Station station = new Station(name);
        StationRepository.addStation(station);
        OutputView.printFunctionResult(Constant.REGISTER_RESULT_FORMAT, ServiceList.STATION.getName());
        return;
    }

    private String getStationName(ManagementMenu menu) {
        if(menu.equals(ManagementMenu.REGISTER)) {
            OutputView.printInputData(Constant.INPUT_DATA_REGISTER_FORMAT, ServiceList.STATION.getName());
        }
        if(menu.equals(ManagementMenu.DELETE)) {
            OutputView.printInputData(Constant.INPUT_DATA_DELETE_FORMAT, ServiceList.STATION.getName());
        }
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

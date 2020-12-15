package subway.domain.management;

import subway.Constant;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;


public class StationManager extends ServiceManager {

    private Scanner scanner;
    public StationManager(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void doStationManagement() {
        OutputView.printManagementView(ServiceList.STATION, menuList);
        String inputData = getInputData(scanner);

        if(inputData.equals(ManagementMenu.REGISTER.getOrder())){
            registerStation();
            return;
        }
    }

    private void registerStation() {
        String name = getStationName();

    }

    private String getStationName() {
        try{
            OutputView.printInputData(Constant.INPUT_DATA_REGISTER_FORMAT, ServiceList.STATION.getName());
            return InputView.inputData(scanner);
        }catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getStationName();
        }
    }


    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.FIND);
        menuList.add(ManagementMenu.BACK);
    }
}

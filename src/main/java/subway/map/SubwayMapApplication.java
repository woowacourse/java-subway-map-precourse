package subway.map;

import subway.controller.SubwayMapController;
import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayMapApplication {

    private final InputView inputView;
    private final SubwayMapController subwayMapController;

    public SubwayMapApplication(InputView inputView, SubwayMapController subwayMapController) {
        this.inputView = inputView;
        this.subwayMapController = subwayMapController;
    }

    public void run() {
        ManagementType managementType = ManagementType.initiate();
        while (managementType.isRunning()) {
            OutputView.printMainDisplay();
            managementType = inputView.inputManagementType();
            executeExceptionHandler(managementType);
        }
    }

    private void executeExceptionHandler(ManagementType managementType) {
        try {
            executeManagementFunction(managementType);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            executeExceptionHandler(managementType);
        }
    }

    private void executeManagementFunction(ManagementType managementType) {
        if (managementType == ManagementType.EXIT) {
            return;
        }
        if (managementType == ManagementType.SUBWAY_MAP_PRINT) {
            return;
        }
        OutputView.printManagementDisplay(managementType);
        FunctionType functionType = inputView.inputFunctionType(managementType);
        selectManagementFunction(managementType, functionType);
    }

    private void selectManagementFunction(ManagementType managementType, FunctionType functionType) {
        if (functionType == FunctionType.BACK) {
            return;
        }
        if (managementType == ManagementType.STATION) {
            executeStationManagement(functionType);
        }
    }

    private void executeStationManagement(FunctionType functionType) {
        if (functionType == FunctionType.READ) {
            List<String> stationNames = subwayMapController.getStationNames();
            OutputView.printStationNames(stationNames);
            return;
        }
        String stationName = inputView.inputStationName(functionType);
        if (functionType == FunctionType.REGISTER) {
            subwayMapController.addStationByName(stationName);
        }
        if (functionType == FunctionType.DELETE) {
            subwayMapController.deleteStationByName(stationName);
        }
        OutputView.printStationManagementSuccessMessage(functionType);
    }
}

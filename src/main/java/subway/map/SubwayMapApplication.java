package subway.map;

import subway.controller.ControllerMapper;
import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapApplication {

    private final InputView inputView;
    private final ControllerMapper controllerMapper;

    public SubwayMapApplication(InputView inputView, ControllerMapper controllerMapper) {
        this.inputView = inputView;
        this.controllerMapper = controllerMapper;
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
        if (!isDetailManagementDisplayRequired(managementType)) {
            return;
        }
        try {
            activateDetailManagementDisplay(managementType);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            executeExceptionHandler(managementType);
        }
    }

    private boolean isDetailManagementDisplayRequired(ManagementType managementType) {
        if (managementType == ManagementType.EXIT) {
            return false;
        }
        if (managementType == ManagementType.PRINT_SUBWAY_MAP) {
            controllerMapper.delegateRequestToController(managementType, FunctionType.READ);
            return false;
        }
        return true;
    }

    private void activateDetailManagementDisplay(ManagementType managementType) {
        OutputView.printManagementDisplay(managementType);
        FunctionType functionType = inputView.inputFunctionType(managementType);
        if (functionType == FunctionType.BACK) {
            return;
        }
        controllerMapper.delegateRequestToController(managementType, functionType);
        OutputView.printSuccessMessage(managementType, functionType);
    }
}

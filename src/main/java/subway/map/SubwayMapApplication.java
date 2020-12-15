package subway.map;

import subway.controller.ControllerMapper;
import subway.view.InputView;
import subway.view.OutputView;
import subway.vo.FunctionType;
import subway.vo.ManagementType;

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
        if (managementType == ManagementType.EXIT) {
            return;
        }
        try {
            activateDetailManagementDisplay(managementType);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            executeExceptionHandler(managementType);
        }
    }

    private void activateDetailManagementDisplay(ManagementType managementType) {
        if (managementType == ManagementType.PRINT_SUBWAY_MAP) {
            controllerMapper.delegateRequestToController(managementType, FunctionType.READ);
            return;
        }
        OutputView.printManagementDisplay(managementType);
        FunctionType functionType = inputView.inputFunctionType(managementType);
        controllerMapper.delegateRequestToController(managementType, functionType);
        if (isSuccessMessageRequired(functionType)) {
            OutputView.printSuccessMessage(managementType, functionType);
        }
    }

    private boolean isSuccessMessageRequired(FunctionType functionType) {
        return functionType != FunctionType.BACK && functionType != FunctionType.READ;
    }
}

package subway.controller;

import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;

import java.util.List;

public class ControllerMapper {

    private final List<SubwayMapController> subwayMapControllers;

    public ControllerMapper(List<SubwayMapController> subwayMapControllers) {
        this.subwayMapControllers = subwayMapControllers;
    }

    public void delegateRequestToController(ManagementType managementType, FunctionType functionType) {
        SubwayMapController subwayMapController = findSubwayMapController(managementType);
        if (managementType == ManagementType.SUBWAY_MAP_PRINT) {
            subwayMapController.readSubwayMap();
            return;
        }
        execute(subwayMapController, functionType);
    }

    private SubwayMapController findSubwayMapController(ManagementType managementType) {
        if (managementType == ManagementType.STATION) {
            return getSubwayMapController(StationController.class);
        }
        if (managementType == ManagementType.SECTION) {
            return getSubwayMapController(SectionController.class);
        }
        return getSubwayMapController(LineController.class);
    }

    private SubwayMapController getSubwayMapController(Class<? extends SubwayMapController> targetClass) {
        return subwayMapControllers.stream()
                .filter(subwayMapController -> subwayMapController.getClass() == targetClass)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void execute(SubwayMapController subwayMapController, FunctionType functionType) {
        if (functionType == FunctionType.REGISTER) {
            subwayMapController.register();
        }
        if (functionType == FunctionType.DELETE) {
            subwayMapController.delete();
        }
        if (functionType == FunctionType.READ) {
            subwayMapController.readNames();
        }
    }
}

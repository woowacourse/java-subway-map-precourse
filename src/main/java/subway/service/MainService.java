package subway.service;

import subway.ServiceValidator;
import subway.constant.Information;
import subway.constant.Service;
import subway.exception.InvalidInputException;

import java.util.Scanner;

public class MainService {

    private Scanner scanner;
    private ServiceValidator serviceValidator = new ServiceValidator();
    private boolean isContinue = true;

    private StationService stationService;
    private LineService lineService;
    private AreaService areaService;
    private MapService mapService;

    public MainService(Scanner scanner) {
        this.scanner = scanner;
        stationService = new StationService(scanner);
        lineService = new LineService(scanner);
        areaService = new AreaService(scanner);
        mapService = new MapService();
    }


    public void start() {
        while (isContinue)
            runService();
    }

    private void runService() {
        try {
            String selectedService = selectService();
            runSelectedService(selectedService);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String selectService() {
        String line = getServiceInput();
        serviceValidator.validate(line);
        return line;
    }

    private String getServiceInput() {
        System.out.println(Information.MAIN_INFO);
        return scanner.nextLine();
    }

    private void runSelectedService(String selectedFunction) {
        if (selectedFunction.equals(Service.STATION.getCode()))
            stationService.run();
        if (selectedFunction.equals(Service.LINE.getCode()))
            lineService.run();
        if (selectedFunction.equals(Service.AREA.getCode()))
            areaService.run();
        if (selectedFunction.equals(Service.MAP.getCode()))
            mapService.run();
    }
}

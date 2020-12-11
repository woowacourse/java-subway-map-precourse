package subway.service;

import subway.constant.Information;
import subway.constant.Service;
import subway.exception.InvalidInputException;

import java.util.Scanner;

public class MainService {

    private Scanner scanner;
    private boolean isContinue = true;

    private StationService stationService;
    private LineService lineService;
    private LinkService linkService;
    private PrintService printService;

    public MainService(Scanner scanner) {
        this.scanner = scanner;
        initServices(scanner);
    }

    private void initServices(Scanner scanner) {
        stationService = new StationService(scanner);
        lineService = new LineService(scanner);
        linkService = new LinkService(scanner);
        printService = new PrintService();
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
        Service.validate(line);
        return line;
    }

    private String getServiceInput() {
        System.out.println(Information.MAIN_INFO);
        return scanner.nextLine();
    }

    private void runSelectedService(String selectedService) {
        if (selectedService.equals(Service.STATION.getCode()))
            stationService.run();
        if (selectedService.equals(Service.LINE.getCode()))
            lineService.run();
        if (selectedService.equals(Service.LINK.getCode()))
            linkService.run();
        if (selectedService.equals(Service.PRINT.getCode()))
            printService.run();
        if (selectedService.equals(Service.QUIT.getCode()))
            isContinue = false;
    }
}

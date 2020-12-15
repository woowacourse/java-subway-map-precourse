package subway.service;

import subway.constant.Service;
import subway.exception.InvalidInputException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.constant.Information.MAIN_INFO;

public class MainService implements MapService {

    private boolean isContinue = true;

    private InputView inputView;
    private OutputView outputView;

    private StationService stationService;
    private LineService lineService;
    private LinkService linkService;
    private PrintService printService;

    public MainService(Scanner scanner) {
        initViews(scanner);
        initServices();
    }

    private void initServices() {
        stationService = new StationService(inputView, outputView);
        lineService = new LineService(inputView, outputView);
        linkService = new LinkService(inputView, outputView);
        printService = new PrintService(outputView);
    }

    private void initViews(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }


    @Override
    public void run() {
        while (isContinue)
            runService();
    }

    private void runService() {
        try {
            String selectedService = getSelectedService();
            Service.validate(selectedService);
            runSelectedService(selectedService);
        } catch (InvalidInputException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private String getSelectedService() {
        outputView.printInformation(MAIN_INFO);
        return inputView.getSelectedServiceInput();
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

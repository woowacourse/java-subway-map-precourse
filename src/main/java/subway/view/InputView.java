package subway.view;

import subway.domain.Line;
import subway.domain.Link;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static subway.constant.Information.*;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFunctionInput(String information) {
        System.out.println(information);
        return scanner.nextLine();
    }


    public String getSelectedServiceInput() {
        System.out.println(MAIN_INFO);
        return scanner.nextLine();
    }


    public Station getNewStationInput() {
        System.out.println(ADD_STATION_INFO);
        return new Station(scanner.nextLine());
    }


    public Station getTargetStationInput() {
        System.out.println(DELETE_STATION_INFO);
        return new Station(scanner.nextLine());
    }


    public Line getNewLineInput() {
        String name = getNewLineName();
        List<Station> endStations = getNewLineEndStations();
        return new Line(name, endStations);
    }

    private String getNewLineName() {
        System.out.println(ADD_LINE_INFO);
        return scanner.nextLine();
    }

    private List<Station> getNewLineEndStations() {
        Station upEnd = getNewLineUpEnd();
        Station downEnd = getNewLineDownEnd();
        return new ArrayList<>(Arrays.asList(upEnd, downEnd));
    }

    private Station getNewLineUpEnd() {
        System.out.println(ADD_LINE_INFO_UP_END);
        return new Station(scanner.nextLine());
    }

    private Station getNewLineDownEnd() {
        System.out.println(ADD_LINE_INFO_DOWN_END);
        return new Station(scanner.nextLine());
    }


    public String getTargetLineNameInput() {
        System.out.println(DELETE_LINE_INFO);
        return scanner.nextLine();
    }


    public Link getNewLinkInput() throws NumberFormatException {
        String lineName = getLineNameOnAdd();
        String stationName = getStationNameOnAdd();
        int order = getOrderOnAdd();
        return new Link(lineName, stationName, order);
    }

    private String getLineNameOnAdd() {
        System.out.println(ADD_LINK_INFO_LINE);
        return scanner.nextLine();
    }

    private String getStationNameOnAdd() {
        System.out.println(ADD_LINK_INFO_STATION);
        return scanner.nextLine();
    }

    private int getOrderOnAdd() throws NumberFormatException {
        System.out.println(ADD_LINK_INFO_ORDER);
        return Integer.parseInt(scanner.nextLine()) - 1;
    }


    public Link getTargetLinkInput() {
        String targetLineName = getTargetLineNameOnDelete();
        String targetStationName = getTargetStationNameOnDelete();
        return new Link(targetLineName, targetStationName);
    }

    private String getTargetLineNameOnDelete() {
        System.out.println(DELETE_LINK_INFO_LINE);
        return scanner.nextLine();
    }

    private String getTargetStationNameOnDelete() {
        System.out.println(DELETE_LINK_INFO_STATION);
        return scanner.nextLine();
    }

}

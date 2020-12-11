package subway.service;

import subway.constant.Information;
import subway.domain.Line;
import subway.domain.Link;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Scanner;

import static subway.constant.Constant.MIN_ORDER;
import static subway.constant.Constant.MIN_STATIONS_IN_LINE;

public class LinkService extends CrudService {

    private Scanner scanner;

    public LinkService(Scanner scanner) {
        super(scanner, Information.LINK_INFO);
        this.scanner = scanner;
    }

    @Override
    public void add() {
        try {
            Link newLink = getNewLinkInput();
            validateNewLink(newLink);
            addNewLink(newLink);
            System.out.println(Information.ADD_LINK_SUCCESS);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NON_NUMBER_INPUT);
        }
    }

    private Link getNewLinkInput() throws NumberFormatException {
        String lineName = getLineNameOnAdd();
        String stationName = getStationNameOnAdd();
        int order = getOrderOnAdd();
        return new Link(lineName, stationName, order);
    }

    private String getLineNameOnAdd() {
        System.out.println(Information.ADD_LINK_INFO_LINE);
        return scanner.nextLine();
    }

    private String getStationNameOnAdd() {
        System.out.println(Information.ADD_LINK_INFO_STATION);
        return scanner.nextLine();
    }

    private int getOrderOnAdd() throws NumberFormatException {
        System.out.println(Information.ADD_LINK_INFO_ORDER);
        return Integer.parseInt(scanner.nextLine()) - 1;
    }

    private void validateNewLink(Link newLink) {
        validateLineExists(newLink.getLineName());
        validateStationExists(newLink.getStationName());
        validateOrderInRange(newLink);
    }

    private void validateLineExists(String lineName) {
        Line line = new Line(lineName);
        if (!LineRepository.lines().contains(line))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_LINE);
    }

    private void validateStationExists(String stationName) {
        Station station = new Station(stationName);
        if (!StationRepository.stations().contains(station))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }

    private void validateOrderInRange(Link newLink) {
        Line line = getTargetLineByName(newLink.getLineName());
        if (newLink.getOrder() < MIN_ORDER || newLink.getOrder() > line.getStations().size())
            throw new InvalidInputException(InvalidInputException.ExceptionCode.OUT_OF_LINE_RANGE);
    }

    private Line getTargetLineByName(String lineName) {
        return LineRepository.getLineByName(lineName);
    }

    private void addNewLink(Link newLink) {
        Line line = getTargetLineByName(newLink.getLineName());
        line.addNewLink(newLink);
    }


    @Override
    public void delete() {
        Link targetLink = getTargetLinkInput();
        validateTargetLink(targetLink);
        deleteTargetLink(targetLink);
        System.out.println(Information.DELETE_LINK_SUCCESS);
    }

    private Link getTargetLinkInput() {
        String targetLineName = getTargetLineNameOnDelete();
        String targetStationName = getTargetStationNameOnDelete();
        return new Link(targetLineName, targetStationName);
    }

    private String getTargetLineNameOnDelete() {
        System.out.println(Information.DELETE_LINK_INFO_LINE);
        return scanner.nextLine();
    }

    private String getTargetStationNameOnDelete() {
        System.out.println(Information.DELETE_LINK_INFO_STATION);
        return scanner.nextLine();
    }

    private void validateTargetLink(Link targetLink) {
        validateLineExists(targetLink.getLineName());
        validateStationExists(targetLink.getStationName());
        validateLineLength(targetLink.getLineName());
    }

    private void validateLineLength(String lineName) {
        Line targetLine = getTargetLineByName(lineName);
        if (targetLine.getStations().size() < MIN_STATIONS_IN_LINE)
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_LINK_AVAILABLE);
    }

    private void deleteTargetLink(Link targetLink) {
        Line targetLine = getTargetLineByName(targetLink.getLineName());
        targetLine.deleteTargetLink(targetLink);
    }


    @Override
    public void show() {
        throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }
}

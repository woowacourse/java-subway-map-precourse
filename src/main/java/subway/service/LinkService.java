package subway.service;

import subway.constant.Information;
import subway.domain.Line;
import subway.domain.Link;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Scanner;

public class LinkService extends CrudService {

    private Scanner scanner;

    public LinkService(Scanner scanner) {
        super(scanner, Information.LINK_INFO);
        this.scanner = scanner;
    }

    @Override
    public void add() {
        Link newLink = getNewLinkInput();
        validateNewLink(newLink);
    }

    private Link getNewLinkInput() {
        String lineName = getLineName();
        String stationName = getStationName();
        int order = getOrder();
        return new Link(lineName, stationName, order);
    }

    private String getLineName() {
        System.out.println(Information.ADD_LINK_INFO_LINE);
        return scanner.nextLine();
    }

    private String getStationName() {
        System.out.println(Information.ADD_LINK_INFO_STATION);
        return scanner.nextLine();
    }

    private int getOrder() {
        System.out.println(Information.ADD_LINK_INFO_ORDER);
        return Integer.parseInt(scanner.nextLine());
    }

    private void validateNewLink(Link newLink) {
        validateLineExists(newLink.getLineName());
    }

    private void validateLineExists(String lineName) {
        Line line = new Line(lineName);
        if (!LineRepository.lines().contains(line))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_LINE);
    }

    @Override
    public void delete() {
        System.out.println(Information.DELETE_LINK_INFO_LINE);
    }

    @Override
    public void show() {
        throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }
}

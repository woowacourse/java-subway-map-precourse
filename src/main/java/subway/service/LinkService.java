package subway.service;

import subway.constant.Information;
import subway.exception.InvalidInputException;

import java.util.Scanner;

public class LinkService extends CrudService {

    private Scanner scanner;

    public LinkService(Scanner scanner) {
        super(scanner, Information.LINK_INFO);
        this.scanner = scanner;
    }

    @Override
    public void add() {
        System.out.println(Information.ADD_LINK_INFO_LINE);
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

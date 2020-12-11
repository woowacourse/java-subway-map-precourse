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

    }

    @Override
    public void delete() {

    }

    @Override
    public void show() {
        throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }
}

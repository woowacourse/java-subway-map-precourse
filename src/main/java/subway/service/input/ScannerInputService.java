package subway.service.input;

import subway.exception.ErrorCode;
import subway.exception.InputServiceException;

import java.util.Scanner;

public class ScannerInputService implements InputService {
    private final Scanner scanner;

    private ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ScannerInputService of(Scanner scanner) {
        return new ScannerInputService(scanner);
    }

    @Override
    public String getName() {
        String name = getNextLine();
        return name;
    }

    @Override
    public int getMainOption() {
        String inputOption = getNextLine();
        if (isQuit(inputOption)) {
            return OPTION_QUIT;
        }
        int option = stringToInt(inputOption);
        validateMainOption(option);
        return option;
    }

    @Override
    public int getManageStationOption() {
        String inputOption = getNextLine();
        if (isBack(inputOption)) {
            return OPTION_BACK;
        }
        int option = stringToInt(inputOption);
        validateManageStationOption(option);
        return option;
    }

    @Override
    public int getManageRouteOption() {
        String inputOption = getNextLine();
        if (isBack(inputOption)) {
            return OPTION_BACK;
        }
        int option = stringToInt(inputOption);
        validateManageRouteOption(option);
        return option;
    }

    @Override
    public int getManageSectionOption() {
        String inputOption = getNextLine();
        if (isBack(inputOption)) {
            return OPTION_BACK;
        }
        int option = stringToInt(inputOption);
        validateManageSectionOption(option);
        return 0;
    }

    private boolean isBack(String inputOption) {
        if (inputOption.equals(MAIN_OPTION_BACK)) {
            return true;
        }
        return false;
    }

    private boolean isQuit(String inputOption) {
        if (inputOption.equals(MAIN_OPTION_QUIT)) {
            return true;
        }
        return false;
    }

    private void validateManageSectionOption(int option) {
        checkOption(option, ADD, DELETE, OPTION_BACK);
    }

    private void validateManageRouteOption(int option) {
        checkOption(option, ADD, DELETE, FIND);
    }

    private void validateManageStationOption(int option) {
        checkOption(option, ADD, DELETE, FIND);
    }

    private void checkOption(int option, int add, int delete, int find) {
        if (option == add) {
            return;
        }
        if (option == delete) {
            return;
        }
        if (option == find) {
            return;
        }
        throw new InputServiceException(ErrorCode.CANNOT_CHOOSE_OPTION);
    }

    private void validateMainOption(int option) {
        if (option == MANAGE_STATION) {
            return;
        }
        if (option == MANAGE_ROUTE) {
            return;
        }
        if (option == MANAGE_SECTION) {
            return;
        }
        if (option == MANAGE_MAP) {
            return;
        }
        throw new InputServiceException(ErrorCode.CANNOT_CHOOSE_OPTION);
    }

    private int stringToInt(String inputMainOption) {
        try {
            return Integer.parseInt(inputMainOption);
        } catch (IllegalArgumentException IllegalArgumentException) {
            throw new InputServiceException(ErrorCode.CANNOT_CHOOSE_OPTION);
        }
    }

    private String getNextLine() {
        return scanner.nextLine();
    }
}

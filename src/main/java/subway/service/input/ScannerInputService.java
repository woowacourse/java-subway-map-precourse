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
    public int getManageLineOption() {
        String inputOption = getNextLine();
        if (isBack(inputOption)) {
            return OPTION_BACK;
        }
        int option = stringToInt(inputOption);
        validateManageLineOption(option);
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
        return option;
    }

    @Override
    public int getSequence() {
        String inputValue = getNextLine();
        int sequence = stringToInt(inputValue);
        validateSequence(sequence);
        return sequence;
    }

    private String getNextLine() {
        return scanner.nextLine();
    }

    private int stringToInt(String inputMainOption) {
        try {
            return Integer.parseInt(inputMainOption);
        } catch (IllegalArgumentException IllegalArgumentException) {
            throw new InputServiceException(ErrorCode.CANNOT_CHOOSE_OPTION);
        }
    }

    private boolean isBack(String inputOption) {
        String toUpperOption = inputOption.toUpperCase();
        if (toUpperOption.equals(MAIN_OPTION_BACK)) {
            return true;
        }
        return false;
    }

    private boolean isQuit(String inputOption) {
        String toUpperOption = inputOption.toUpperCase();
        if (toUpperOption.equals(MAIN_OPTION_QUIT)) {
            return true;
        }
        return false;
    }

    private void validateManageSectionOption(int option) {
        checkOption(option, ADD, DELETE, OPTION_BACK);
    }

    private void validateManageLineOption(int option) {
        checkOption(option, ADD, DELETE, FIND);
    }

    private void validateManageStationOption(int option) {
        checkOption(option, ADD, DELETE, FIND);
    }

    private void validateMainOption(int option) {
        if (option == MANAGE_STATION) {
            return;
        }
        if (option == MANAGE_LINE) {
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

    private void validateSequence(int sequence) {
        if (sequence < 1) {
            throw new InputServiceException(ErrorCode.INVALID_SEQUENCE);
        }
    }
}

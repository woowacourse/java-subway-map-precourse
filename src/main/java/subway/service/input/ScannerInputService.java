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
    public String getStationName() {
        String stationName = getNextLine();
        return stationName;
    }

    @Override
    public int getMainOption() {
        String inputOption = getNextLine();
        if (isQuit(inputOption)) {
            return OPTION_QUIT;
        }
        int option = stringToInt(inputOption);
        validateOption(option);
        return option;
    }

    private boolean isQuit(String inputOption) {
        if (inputOption.equals(MAIN_OPTION_QUIT)) {
            return true;
        }
        return false;
    }

    private void validateOption(int option) {
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

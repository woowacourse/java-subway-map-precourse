package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.exception.DuplicatedInputException;
import subway.domain.menu.exception.DuplicatedStationInLineException;
import subway.domain.menu.exception.NotAccptedDeleteInputException;
import subway.domain.menu.exception.NotAccptedInputException;
import subway.domain.menu.exception.NotAccptedInputLengthException;
import subway.domain.menu.exception.NotRegisterStationException;
import subway.domain.menu.exception.TerminalStationNameEqualException;

public class InputView {
    private Scanner scanner;
    private Validate validate;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        validate = new Validate();
    }

    public char inputMenu(List<Character> selMenu) {
        char sel;
        while (true) {
            try {
                System.out.println(CommonMessage.SELECT_MESSAGE);
                sel = validate.isAccptedInput(selMenu, scanner.nextLine().charAt(0));
                System.out.println();
                break;
            } catch(NotAccptedInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return sel;
    }

    public String inputRegister(String category) {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedRegisterInput(scanner.nextLine(), category);
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(DuplicatedInputException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return name;
    }

    public String inputTerminalStation() {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedInputTerminalStation(scanner.nextLine());
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(NotRegisterStationException e) {
                System.out.println(e.getMessage());
            } 
            break;
        }
        return name;
    }

    public String inputTerminalStation(String upwardStation) {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedInputTerminalStation(scanner.nextLine(), upwardStation);
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(NotRegisterStationException e) {
                System.out.println(e.getMessage());
            } catch(TerminalStationNameEqualException e) {
                System.out.println(e.getMessage());
            }
            break; 
        }
        return name;
    }

    public String inputDelete(String category) {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedDeleteInput(scanner.nextLine(), category);
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(DuplicatedStationInLineException e) {
                System.out.println(e.getMessage());
            } catch(NotAccptedDeleteInputException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return name;
    }

    // 임시 - 잠시 컴파일 에러 방지하기 위함.
    public Scanner getScanner() {
        return scanner;
    }
}

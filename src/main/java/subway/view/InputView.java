package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.exception.DuplicatedInputException;
import subway.domain.menu.exception.DuplicatedStationInLineException;
import subway.domain.menu.exception.ExcessSectionOrderInputException;
import subway.domain.menu.exception.NotAccptedDeleteInputException;
import subway.domain.menu.exception.NotAccptedDeleteSectionStationInputException;
import subway.domain.menu.exception.NotAccptedInputException;
import subway.domain.menu.exception.NotAccptedInputLengthException;
import subway.domain.menu.exception.NotAccptedSectionOrderInputException;
import subway.domain.menu.exception.NotAccptedSectionStationInputException;
import subway.domain.menu.exception.NotRegisterSectionException;
import subway.domain.menu.exception.NotRegisterStationException;
import subway.domain.menu.exception.StationInLineMinNumException;
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

    public String inputSectionLine() {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedInputSectionLine(scanner.nextLine());
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(NotRegisterSectionException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return name;
    }

    public String inputSectionStation(String input, Line line) {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedInputSectionStation(input, line);
            } catch(NotAccptedSectionStationInputException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return name;
    }

    public String inputSectionOrder(Line line) {
        String order = CommonMessage.ERROR;
        while (true) {
            try {
                order = validate.isAccptedInputSectionOrder(scanner.nextLine(), line);
                System.out.println();
            } catch(NotAccptedSectionOrderInputException e) {
                System.out.println(e.getMessage());
            } catch(ExcessSectionOrderInputException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return order;
    }

    public String inputSectionDeleteStation(Line line) {
        String name = CommonMessage.ERROR;
        while (true) {
            try {
                name = validate.isAccptedInputSectionDeleteStation(scanner.nextLine(), line);
                System.out.println();
            } catch(NotAccptedInputLengthException e) {
                System.out.println(e.getMessage());
            } catch(NotAccptedDeleteSectionStationInputException e) {
                System.out.println(e.getMessage());
            } catch(StationInLineMinNumException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
        return name;
    }
}

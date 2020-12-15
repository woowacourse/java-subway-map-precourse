package subway.domain;

public class Errors {
    public static void checkSameStation(String name) {
        if (StationRepository.isExist(name)) {
            ErrorMessage.displayErrorMessage(Constants.ALREADY_EXIST_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameLine(String name) {
        if (LineRepository.isExist(name)) {
            ErrorMessage.displayErrorMessage(Constants.ALREADY_EXIST_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameName(String firstName, String lastName) {
        if (firstName.equals(lastName)) {
            ErrorMessage.displayErrorMessage(Constants.SAME_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkTextLength(String name) {
        if (name.length() < 2) {
            ErrorMessage.displayErrorMessage(Constants.NAME_LENGTH_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExistStation(String name) {
        if (!StationRepository.isExist(name)) {
            ErrorMessage.displayErrorMessage(Constants.NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExistLine(String name) {
        if (!LineRepository.isExist(name)) {
            ErrorMessage.displayErrorMessage(Constants.NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkInLine(String name) {
        for (Line line : LineRepository.lines())
            if (line.hasStation(name)) {
                ErrorMessage.displayErrorMessage(Constants.HAS_IN_LINE_ERROR);
                throw new IllegalArgumentException();
            }
    }

    public static Line checkInSpecificLine(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        if (line.hasStation(stationName)) {
            ErrorMessage.displayErrorMessage(Constants.HAS_IN_SPECIFIC_LINE_ERROR);
            throw new IllegalArgumentException();
        }
        return line;
    }

    public static void checkNotInSpecificLine(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        if (!line.hasStation(stationName)) {
            ErrorMessage.displayErrorMessage(Constants.HAS_NOT_IN_SPECIFIC_LINE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidIndex(Line line, String index) {
        try {
            int intIndex = Integer.parseInt(index);
            int size = line.getSize();
            if (intIndex < 1 || intIndex > size+1)
                throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            ErrorMessage.displayErrorMessage(Constants.UNVALID_INDEX_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidLine(String name) {
        Line line = LineRepository.getLineByName(name);
        if (line.getSize() < 3) {
            ErrorMessage.displayErrorMessage(Constants.CANT_DELETE_SECTION_ERROR);
            throw new IllegalArgumentException();
        }
    }
}

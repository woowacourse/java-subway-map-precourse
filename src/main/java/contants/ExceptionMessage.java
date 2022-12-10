package contants;

public enum ExceptionMessage {
    STATION_DUPLICATION("이미 존재하는 역입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

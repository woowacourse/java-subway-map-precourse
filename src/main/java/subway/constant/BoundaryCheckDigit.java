package subway.constant;

public enum BoundaryCheckDigit {
        STATION_ADD_LIMIT_MINIMUM(2),
    ;

    private final int digit;

    BoundaryCheckDigit(int digit){
        this.digit = digit;
    }

    public int getBoundaryCheckDigit(){
        return this.digit;
    }
}

package subway.domain;

public class PositiveNumber implements Comparable<PositiveNumber> {
    private int number;

    public PositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_SINGLE_DIGIT_POSITIVE_NUMBER);
        }
        this.number = number;
    }

    public PositiveNumber(String number) {
        for (int i=0; i<number.length(); i++) {
            if (number.charAt(i) - '0' < Constants.SINGLE_DIGIT_MIN
                    || number.charAt(i) - '0' > Constants.SINGLE_DIGIT_MAX) {
                throw new IllegalArgumentException(Constants.ERROR_ONLY_SINGLE_DIGIT_POSITIVE_NUMBER);
            }
        }
        int orderNumber = Integer.parseInt(number);
        if (orderNumber <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_SINGLE_DIGIT_POSITIVE_NUMBER);
        }
        this.number = orderNumber;
    }

    @Override
    public int compareTo(PositiveNumber anotherNumber) {
        return number - anotherNumber.number;
    }

    public int getNumber() {
        return number;
    }
}

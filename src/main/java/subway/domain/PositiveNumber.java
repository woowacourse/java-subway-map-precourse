package subway.domain;

public class PositiveNumber implements Comparable<PositiveNumber> {
    private int number;

    public PositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수만 가능. 다시 입력하세요.");
        }
        this.number = number;
    }

    public PositiveNumber(String number) {
        for (int i=0; i<number.length(); i++) {
            if (number.charAt(i) - '0' < 0 || number.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException("[ERROR] 양의 정수만 가능. 다시 입력하세요.");
            }
        }
        int orderNumber = Integer.parseInt(number);
        if (orderNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수만 가능. 다시 입력하세요.");
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

package subway.domain;

import subway.Constants;

/*
 * PositiveNumber
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
public class PositiveNumber implements Comparable<PositiveNumber> {
    private int number;

    public PositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_ONLY_POSITIVE_NUMBER);
        }
        this.number = number;
    }

    @Override
    public int compareTo(PositiveNumber anotherNumber) {
        return number - anotherNumber.number;
    }

    public int getNumber() {
        return number;
    }
}

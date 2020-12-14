package Enum;

public enum Operation {

    INSERT('1'), DELETE('2'), TRAVERSAL('3'),  GO_TO_MAIN('B');

    Operation(final char choice) {
        this.choice = choice;
    }

    private final char choice;
    private static Operation[] allOperations = values();

    public char getChoice() {
        return choice;
    }

    public static Operation fromLetter(char letter) {
        return allOperations[letter];
    }

    public boolean isGoBack() {
        return this == Operation.GO_TO_MAIN;
    }

}

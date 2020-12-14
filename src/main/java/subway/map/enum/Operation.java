package subwaymapenum;

public enum Operation {

    INSERT('1'), DELETE('2'), TRAVERSAL('3'),  PRINT_SUBWAY_MAP('4'), GO_TO_MAIN('B');

    Operation(final char choice) {
        this.choice = choice;
    }

    private final char choice;
    private static Operation[] allOperations = values();

    public char getChoice() {
        return choice;
    }

    public static Operation fromCommand(char command) {
        for(Operation operation: allOperations) {
            if(operation.choice == command) {
                return operation;
            }
        }
        return null;
    }

    public boolean isGoBack() {
        return this == Operation.GO_TO_MAIN;
    }

    public boolean isPrintMap() {
        return this == Operation.PRINT_SUBWAY_MAP;
    }

}

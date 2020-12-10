package subway.service.output;

public class StringBuilderOutputService implements OutputService {
    private static final int START_INDEX = 0;

    private static StringBuilder sb;

    private StringBuilderOutputService(StringBuilder sb) {
        this.sb = sb;
    }

    public static StringBuilderOutputService of(StringBuilder sb) {
        return new StringBuilderOutputService(sb);
    }

    @Override
    public void printMain() {
        sb.append(MAIN);
        sb.append(MAIN_ONE);
        sb.append(MAIN_TWO);
        sb.append(MAIN_THREE);
        sb.append(MAIN_FOUR);
        sb.append(MAIN_QUIT);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    private void clearSb() {
        sb.delete(START_INDEX, sb.length());
    }
}

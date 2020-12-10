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
        sb.append(ENTER);
        sb.append(MAIN).append(ENTER);
        sb.append(MAIN_ONE).append(ENTER);
        sb.append(MAIN_TWO).append(ENTER);
        sb.append(MAIN_THREE).append(ENTER);
        sb.append(MAIN_FOUR).append(ENTER);
        sb.append(MAIN_QUIT).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printStationManage() {
        sb.append(ENTER);
        sb.append(STATION_MAIN).append(ENTER);
        sb.append(STATION_ONE).append(ENTER);
        sb.append(STATION_TWO).append(ENTER);
        sb.append(STATION_THREE).append(ENTER);
        sb.append(BACK).append(ENTER);
        sb.append(ENTER);
        sb.append(CHOOSE_FUNCTION);
        System.out.println(sb.toString());
        clearSb();
    }

    private void clearSb() {
        sb.delete(START_INDEX, sb.length());
    }
}

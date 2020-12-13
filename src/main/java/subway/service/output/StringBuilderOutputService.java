package subway.service.output;

import subway.view.Prefix;

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
    public void printOptions(String[] options) {
        sb.append(Prefix.ENTER.getPrefix());
        for (String option : options) {
            sb.append(option).append(Prefix.ENTER.getPrefix());
        }
        sb.append(Prefix.ENTER.getPrefix());
        sb.append(Prefix.CHOOSE_FUNCTION.getPrefix());
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printEnter() {
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printInfo(String string) {
        sb.append(Prefix.ENTER.getPrefix());
        sb.append(Prefix.INFO.getPrefix());
        sb.append(string);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printInfos(String string) {
        sb.append(Prefix.INFO.getPrefix());
        sb.append(string);
        System.out.println(sb.toString());
        clearSb();
    }

    @Override
    public void printSharp(String string) {
        sb.append(Prefix.ENTER.getPrefix());
        sb.append(Prefix.SHARP.getPrefix());
        sb.append(string);
        System.out.println(sb.toString());
        clearSb();
    }

    private void clearSb() {
        sb.delete(START_INDEX, sb.length());
    }
}

package subway.view;

import java.util.Scanner;

public abstract class AbstractView implements View{

    protected static final String VIEW_TEXT_PREFIX = "## ";
    protected static Scanner scanner;

    protected String name;

    public AbstractView() {
        initViewName();
    }

    protected abstract void initViewName();

    @Override
    public String getName() {
        return this.name;
    }

    protected void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    protected void println() {
        System.out.println();
    }

    protected void println(String text) {
        System.out.println(text);
    }
}

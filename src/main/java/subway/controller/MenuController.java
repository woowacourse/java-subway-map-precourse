package subway.controller;

public abstract class MenuController {

    public String TITLE = null;

    public abstract IOption[] getOptions();
}
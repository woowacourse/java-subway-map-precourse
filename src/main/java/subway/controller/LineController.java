package subway.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.service.LineService;
import subway.domain.service.StationService;
import subway.view.DetailView;
import utils.Category;
import utils.ScriptUtils;

public class LineController {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    public static final int GET_LIST = 3;

    public static DetailView lineView = new DetailView(Category.LINE);

    private LineController() {}

    public static void manageLine(Scanner scanner, int selection) {
        String name = lineView.ask(scanner, selection);
        if (name == null) {
            return;
        }
        if (selection == DELETE) {
            LineService.deleteLine(name);
            return;
        }
        addLine(scanner, name);
    }

    private static void addLine(Scanner scanner, String name) {
        try {
            if (LineService.duplicateName(name)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_DUPLICATE(Category.LINE));
            }
            addTerminals(scanner, name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addTerminals(Scanner scanner, String name) {
        List<Station> terminals = new ArrayList<>();
        for (int i = 0; i < ScriptUtils.ASK_ADD_LINE.length; i++) {
            String terminalName = lineView.additionalAsk(scanner, ScriptUtils.ASK_ADD_LINE[i]);
            try {
                if (!StationService.duplicateName(terminalName)) {
                    throw new IllegalArgumentException(ScriptUtils.ERROR_NO(Category.STATION));
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            terminals.add(StationService.readStation(terminalName));
        }
        LineService.createLine(name, terminals);
    }
}

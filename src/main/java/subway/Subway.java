package subway;
/*
 * Subway
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.domain.Constants;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subway {
    private Scanner scanner;
    private Map<String, Object> menus = new HashMap<>();

    public Subway(Scanner scanner) {
        this.scanner = scanner;
        initSubway();
        StationRepository.init();
        LineRepository.init();
    }

    public String selectState() {
        System.out.println(Constants.MAIN_MENU);
        String menu = scanner.next();
        try {
            if (!menus.containsKey(menu)) {
                throw new IllegalArgumentException(Constants.WRONG_STATE_TRY_AGAIN);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectState();
        }
        return menu;
    }

    private void initSubway() {
        menus.put(Constants.ONE, new InputStationManager(scanner));
        menus.put(Constants.TOW, new InputLineManager(scanner));
        menus.put(Constants.THREE, new InputSectionManager(scanner));
        menus.put(Constants.FOUR, Constants.FOUR);
        menus.put(Constants.APPLICATION_QUIT, Constants.APPLICATION_QUIT);
        SubwayManager.initSubwayManager(menus);
    }

    public Object getMenus(String name) {
        return menus.get(name);
    }

}
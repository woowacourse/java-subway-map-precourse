package subway.util;

import subway.domain.*;

import java.util.Scanner;

public class SectionManager {
    public void SectionMain(Scanner scanner) {
        while(true) {
            Constants.printSection();
            String inputString = scanner.nextLine().trim();
            try {
                if(inputString.equals("B")) {
                    return;
                } else if(inputString.equals("1")) {
                    addSection(scanner);
                    break;
                } else if(inputString.equals("2")) {
                    removeSection(scanner);
                    break;
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return;
    }

    public void addSection(Scanner scanner) {
        String inputLine, inputStation, inputOrder;
        System.out.println(Constants.ASK_SECTION_ADD_LINE);
        inputLine = scanner.nextLine().trim();
        if(!ErrorManager.isLineExist(inputLine)) {
           throw new IllegalArgumentException(Constants.LINE_NOT_EXIST);
        }
        System.out.println(Constants.ASK_SECTION_ADD_NAME);
        inputStation = scanner.nextLine().trim();
        if(!ErrorManager.isStationExist(inputStation)) {
            throw new IllegalArgumentException(Constants.STATION_NOT_EXIST);
        }
        System.out.println(Constants.ASK_SECTION_ADD_ORDER);
        inputOrder = scanner.nextLine().trim();

        for(int i = 0; i < inputOrder.length(); i++) {
            char tmp = inputOrder.charAt(i);

            if(!Character.isDigit(tmp)) {
                throw new IllegalArgumentException(Constants.ORDER_MUST_INT);
            }
        }

        int order = Integer.parseInt(inputOrder);

        Station station = null;
        for(Station st : StationRepository.stations()) {
            if(st.getName().equals(inputStation)) {
                station = st;
            }
        }
        for(Section section : SectionRepository.sections()) {
            if(section.getLine().getName().equals(inputLine)) {
                section.addStation(order, station);
            }
        }
        System.out.println(Constants.SECTION_ADD_COMPLETE);
    }

    public void removeSection(Scanner scanner) {
        String inputLine, inputStation;
        System.out.println(Constants.ASK_SECTION_REMOVE_LINE);
        inputLine = scanner.nextLine().trim();
        if(!ErrorManager.isLineExist(inputLine)) {
            throw new IllegalArgumentException(Constants.LINE_NOT_EXIST);
        }
        System.out.println(Constants.ASK_SECTION_REMOVE_STATION);
        inputStation = scanner.nextLine().trim();
        if(!ErrorManager.isStationExist(inputStation)) {
            throw new IllegalArgumentException(Constants.STATION_NOT_EXIST);
        }
        if(!SectionRepository.deleteSection(inputStation, inputLine)) {
            throw new IllegalArgumentException(Constants.SECTION_REMOVE_FAIL);
        } else {
            System.out.println(Constants.SECTION_REMOVE_COMPLETE);
        }
    }
}

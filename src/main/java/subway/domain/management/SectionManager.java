package subway.domain.management;

import subway.Constant;
import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionManager extends ServiceManager {

    public SectionManager(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void doStationManagement() {
        OutputView.printManagementView(ServiceList.SECTION, menuList);
        String inputData = getInputData(scanner);

        try {
            checkInputData(inputData);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            doStationManagement();
        }
    }

    private void checkInputData(String inputData) {
        if (inputData.equals(ManagementMenu.REGISTER.getOrder())) {
            //registerStation(ManagementMenu.REGISTER);
            return;
        }
        if (inputData.equals(ManagementMenu.DELETE.getOrder())) {
            deleteSection(ManagementMenu.DELETE);
            return;
        }
    }

    private void deleteSection(ManagementMenu menu) {
        Line line = getLineName(menu);
        Station station = getStationName(line, menu);

        line.deleteSection(station.getName());
    }

    private Line checkValidLineName(String lineName) {
        for (Line savedLine : LineRepository.lines()) {
            if (savedLine.getName().equals(lineName)) {
                return savedLine;
            }
        }
        throw new IllegalArgumentException("등록되지 않은 노선입니다.");
    }

    private Station checkValidStationName(Line line, String stationName) {
        for (Station station : line.getStations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        throw new IllegalArgumentException("해당 구간에 등록되지 않은 노선입니다.");
    }

    private Line getLineName(ManagementMenu menu) {
        try {
            if (menu.equals(ManagementMenu.REGISTER)) {
                OutputView.printInputData(Constant.INPUT_SECTION_LINE_DATA_REGISTER_FORMAT, ServiceList.SECTION.getName());
            }
            if (menu.equals(ManagementMenu.DELETE)) {
                OutputView.printInputData(Constant.INPUT_SECTION_LINE_DATA_DELETE_FORMAT, ServiceList.SECTION.getName());
            }
            String data = InputView.inputData(scanner);
            return checkValidLineName(data);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getLineName(menu);
        }
    }

    private Station getStationName(Line line, ManagementMenu menu) {
        try{
            if (menu.equals(ManagementMenu.REGISTER)) {
                OutputView.printInputData(Constant.INPUT_SECTION_STATION_DATA_REGISTER_FORMAT, ServiceList.SECTION.getName());
            }
            if (menu.equals(ManagementMenu.DELETE)) {
                OutputView.printInputData(Constant.INPUT_SECTION_STATION_DATA_DELETE_FORMAT, ServiceList.SECTION.getName());
            }
            String data = InputView.inputData(scanner);
            return checkValidStationName(line, data);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getStationName(line, menu);
        }
    }

    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.BACK);
    }
}

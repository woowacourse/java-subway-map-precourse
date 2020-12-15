package subway.domain.management;

import subway.Constant;
import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.menu.ManagementMenu;
import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineManager extends ServiceManager{

    public LineManager(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void doStationManagement() {
        OutputView.printManagementView(ServiceList.LINE, menuList);
        String inputData = getInputData(scanner);

        try {
            checkInputData(inputData);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            doStationManagement();
        }
    }

    private void checkInputData(String inputData) {
        if(inputData.equals(ManagementMenu.REGISTER.getOrder())){
            registerLine(ManagementMenu.REGISTER);
            return;
        }
        if(inputData.equals(ManagementMenu.DELETE.getOrder())){
            deleteLine(ManagementMenu.DELETE);
            return;
        }
        if(inputData.equals(ManagementMenu.FIND.getOrder())){
            findLine();
            return;
        }
    }

    private void registerLine(ManagementMenu menu) {
        String name = getLineName(menu);

        for(Line savedLine : LineRepository.lines()){
            if(savedLine.getName().equals(name)){
                OutputView.printErrorWithFormat(Constant.REGISTER_DUPLICATE_DATA_ERROR_FORMAT, ServiceList.LINE.getName());
                return;
            }
        }

        Line line = new Line(name);
        LineRepository.addLine(line);
        OutputView.printFunctionResult(Constant.REGISTER_RESULT_FORMAT, ServiceList.LINE.getName());
        return;
    }

    private void deleteLine(ManagementMenu menu) {
        String name = getLineName(menu);

        for(Line savedLine : LineRepository.lines()){
            if(savedLine.getName().equals(name)){
                OutputView.printFunctionResult(Constant.DELETE_RESULT_FORMAT, ServiceList.LINE.getName());
                LineRepository.deleteLineByName(name);
                return;
            }
        }

        OutputView.printErrorWithFormat(Constant.DELETE_DATA_ERROR_FORMAT, ServiceList.LINE.getName());
        return;
    }

    private void findLine() {
        OutputView.printLineList(LineRepository.lines(), ServiceList.LINE.getName());
    }

    private String getLineName(ManagementMenu menu) {
        if(menu.equals(ManagementMenu.REGISTER)) {
            OutputView.printInputData(Constant.INPUT_DATA_REGISTER_FORMAT, ServiceList.LINE.getName());
        }
        if(menu.equals(ManagementMenu.DELETE)) {
            OutputView.printInputData(Constant.INPUT_DATA_DELETE_FORMAT, ServiceList.LINE.getName());
        }
        String data = InputView.inputData(scanner);
        return data;
    }

    @Override
    protected void initMenuList() {
        menuList.add(ManagementMenu.REGISTER);
        menuList.add(ManagementMenu.DELETE);
        menuList.add(ManagementMenu.FIND);
        menuList.add(ManagementMenu.BACK);
    }
}

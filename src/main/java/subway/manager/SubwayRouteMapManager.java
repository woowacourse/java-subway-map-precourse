package subway.manager;

import subway.domain.line.service.LineService;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayRouteMapManager implements Manager{

    @Override
    public void execute(Scanner scanner) {
        OutputView.printSubwayRouteMap(LineService.findAll());
        new MainManager().execute(scanner);
    }
}

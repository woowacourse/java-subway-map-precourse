package subway.common;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;

import static subway.repository.LineRepository.addLine;
import static subway.repository.LineRepository.addSection;
import static subway.repository.StationRepository.addStation;


public class TestCase {
    public static void testCaseCreate(InputView inputView) {
        Station kyodae = new Station("교대역");
        Station kangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station terminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station forest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");
        addStation(kyodae);
        addStation(kangnam);
        addStation(yeoksam);
        addStation(terminal);
        addStation(yangjae);
        addStation(forest);
        addStation(maebong);

        Line line2 = new Line("2호선", kyodae, yeoksam);
        Line line3 = new Line("3호선", kyodae, maebong);
        Line lineSinbundang = new Line("신분당선", kangnam, forest);
        addLine(line2);
        addLine(line3);
        addLine(lineSinbundang);

        addSection(line2, kangnam, 1);
        addSection(line3, yangjae, 1);
        addSection(line3, terminal, 1);
        addSection(lineSinbundang, yangjae, 1);
    }
}

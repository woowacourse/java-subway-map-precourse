package subway.domain.line;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("지하철 노선 LineRepositoryTest")
public class LineRepositoryTest {
    private final String lineName="lineName";
    private final String upward="상행역";
    private final String downward="하행역";
    private final Line line=new Line(lineName);
    @BeforeEach
    void before(){
        line.addAllStation(upward,downward);
        LineRepository.addLine(line);
    }

    @AfterEach
    void after(){
        LineRepository.deleteAll();
    }

    @DisplayName("지하철 노선 등록")
    @Test
    void addLine(){
        String name="test";
        Line line=new Line(name);
        line.addAllStation(upward,downward);
        LineRepository.addLine(line);
        int expectSize=2;
        assertEquals(LineRepository.lines().size(),expectSize);
    }

    @DisplayName("지하철 노선에 역 추가(구간 등록)")
    @Test
    void addStationSavedLine(){
        String name="test";
        int position=1;
        int expectStationSize=3;
        line.addStation(position,name);
        Line findLine=LineRepository.findByName(lineName);
        assertEquals(findLine.getStations().size(),expectStationSize);
    }

    @DisplayName("지하철 노선 이름으로 삭제")
    @Test
    void deleteLineByName(){
        LineRepository.deleteLineByName(lineName);
        int expectSize=0;
        assertEquals(LineRepository.lines().size(),expectSize);
    }

    @DisplayName("지하철 노선에 등록된 역 제거(구간 삭제)")
    @Test
    void deleteStationSavedLine(){
        String name="test";
        int position=1;
        int expectStationSize=3;
        line.addStation(position,name);//역 3개
        Line findLine=LineRepository.findByName(lineName);
        assertEquals(findLine.getStations().size(),expectStationSize);
        LineRepository.deleteStationByName(line,name);
        assertEquals(findLine.getStations().size(),expectStationSize-1);
    }

    @DisplayName("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.(구간 삭제)")
    @Test
    void deleteStationByName(){
        String name="test";
        int position=1;
        int expectStationSize=2;
        LineRepository.deleteStationByName(line,name);
        Line findLine=LineRepository.findByName(lineName);
        assertEquals(findLine.getStations().size(),expectStationSize);
    }

    @DisplayName("중복된 지하철 노선 이름이 등록될 수 없다.")
    @Test
    void cannotAddDuplicateLineByName(){
        Line line=new Line(lineName);
        line.addAllStation(upward,downward);
        LineRepository.addLine(line);
        int expectSize=1;
        assertEquals(LineRepository.lines().size(),expectSize);
    }

    @DisplayName("지하철 노선 조회")
    @Test
    void findAllLine(){
        List<Line> lines=LineRepository.findAll();
        int expectSize=1;
        assertEquals(lines.size(),expectSize);
    }
}

package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import subway.exception.AlreadyRegisteredLineNameException;

public class LineTest {

    String newLine = "새로운노선";
    String newStation1 = "역1";
    String newStation2 = "역2";

    @Before
    public void setUp() throws Exception {
        LineRepository.deleteAll();
    }

    @Test
    public void of() {
    }

    @Test
    public void getLineByName() {
    }

    @Test
    public void save_성공() {
        Line.of(newLine, Station.from(newStation1), Station.from(newStation2)).save();
        assertThat(LineRepository.exists(newLine)).isTrue();
    }

    @Test(expected = AlreadyRegisteredLineNameException.class)
    public void save_실패_이미_존재하는_노선() {
        Line.of(newLine, Station.from(newStation1), Station.from(newStation2)).save();
        Line.of(newLine, Station.from(newStation1), Station.from(newStation2)).save();
    }

    @Test(expected = AlreadyRegisteredLineNameException.class)
    public void save_실패_지연된_save_호출() {
        Line line1 = Line.of(newLine, Station.from(newStation1), Station.from(newStation2));
        Line line2 = Line.of(newLine, Station.from(newStation1), Station.from(newStation2));
        line1.save();
        line2.save();
    }
}
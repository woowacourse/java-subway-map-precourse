package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SectionRepositoryTest {
    @Test
    public void testAddNewSection() {
        SectionRepository.addNewSection(new Line("경중선"), new Station("야당"), new Station("용산"));
        for (Line line : SectionRepository.stations().keySet()) {
            System.out.println(line.getName());
            SectionRepository.stations().get(line).stream().map(station-> station.getName()).forEach(System.out::println);
        }
    }
}
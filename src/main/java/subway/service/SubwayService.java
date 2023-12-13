package subway.service;

import java.util.List;

public interface SubwayService {

    void addAll(List<String> elements);

    void add(String element);

    void delete(String element);
}

package subway.util;

import java.util.Arrays;
import java.util.List;

public enum FeatureGroup {
    MAIN_SCREEN(Arrays.asList("1", "2", "3", "4", "Q")),
    STATION_MANAGEMENT_SCREEN(Arrays.asList("1", "2", "3", "B")),
    LINE_MANAGEMENT_SCREEN(Arrays.asList("1", "2", "3", "B")),
    SECTION_MANAGEMENT_SCREEN(Arrays.asList("1", "2", "B"));

    private List<String> features;

    FeatureGroup(List<String> features) {
        this.features = features;
    }

    public boolean hasFeature(String featureCode) {
        return features.stream()
            .anyMatch(feature -> feature.equals(featureCode));
    }
}


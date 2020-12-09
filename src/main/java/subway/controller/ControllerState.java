package subway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ControllerState {
    protected static Map<String, Integer> featureRequiredInputNumMap = new HashMap<>();

    public abstract void printMain();

    public abstract void doFeature(String feature, int order, String param, ControllerState controllerState);

    public boolean isValidFeature(String feature) {
        if(Optional.of(featureRequiredInputNumMap.get(feature)).isPresent()){
            return true;
        }
        return false;
    }

    public int getRequiredInputNum(String feature){
        return featureRequiredInputNumMap.get(feature);
    }
}

package subway.domain.function;

import java.util.HashMap;

public class Functions {
    private HashMap<String, Function> functions = new HashMap<>();

    Functions(HashMap<String, Function> functions) {
        this.functions = functions;
    }

    public HashMap<String, Function> getFunctions () {
        return functions;
    }

    public Function selectFunction(String functionNumber) {
        return functions.get(functionNumber);
    }
}

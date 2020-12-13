package subway.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorPool {

    private ValidatorPool() {}

    public static Validator getValidator(Class<? extends Validator> validator) {
        return ValidatorFactory.validatorPool.get(validator);
    }

    private static class ValidatorFactory {

        private static final Map<Class<? extends Validator>, Validator> validatorPool =
                new HashMap<>();

        static {
            validatorPool.put(IndexValidator.class, new IndexValidator());
            validatorPool.put(LineNameValidator.class, new LineNameValidator());
            validatorPool.put(StationNameValidator.class, new StationNameValidator());
            validatorPool.put(Validator.class, new Validator());
        }
    }
}

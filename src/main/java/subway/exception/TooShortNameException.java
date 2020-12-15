package subway.exception;

import subway.domain.DomainNamingForm;

public class TooShortNameException extends IllegalArgumentException {
    private static final String MESSAGE = "%s 이름은 %d자 이상이어야 합니다. (input: \"%s\")";

    public TooShortNameException(String inputName, DomainNamingForm namingForm) {
        super(String.format(
                MESSAGE, namingForm.getDomainName(), namingForm.getMinimumLength(), inputName));
    }
}

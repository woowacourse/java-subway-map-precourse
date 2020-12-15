package subway.exception;

import subway.domain.DomainNamingForm;

public class InvalidSuffixException extends IllegalArgumentException {
    private static final String MESSAGE = "%s 이름은 %s(으)로 끝나야 합니다. (input: \"%s\")";

    public InvalidSuffixException(String name, DomainNamingForm namingForm) {
        super(String.format(
                MESSAGE, namingForm.getDomainName(), namingForm.getSuffixesAsString(), name));
    }
}

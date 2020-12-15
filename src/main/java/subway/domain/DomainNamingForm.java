package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public enum DomainNamingForm {
    STATION("역", 2, Arrays.asList("역")),
    LINE("노선", 2, Arrays.asList("선", "전철", "철도", "라인"));

    private static final String DELIMITER = ", ";
    private static final String QUOTE_FORMAT = "\"%s\"";
    
    private String domainName;
    private int minimumLength;
    private List<String> validSuffixes;

    private DomainNamingForm(String domainName, int minimumLength, List<String> validSuffixes) {
        this.domainName = domainName;
        this.minimumLength = minimumLength;
        this.validSuffixes = validSuffixes;
    }

    public String getDomainName() {
        return domainName;
    }

    public int getMinimumLength() {
        return minimumLength;
    }

    public boolean isSuffixValid(String input) {
        for (String suffix : validSuffixes) {
            if (input.endsWith(suffix)) {
                return true;
            }
        }

        return false;
    }

    public String getSuffixesAsString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String suffix : validSuffixes) {
            stringJoiner.add(String.format(QUOTE_FORMAT, suffix));
        }

        return stringJoiner.toString();
    }
}

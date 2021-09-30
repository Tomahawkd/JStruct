package io.tomahawkd.jstruct.xml.types;

import java.util.regex.Pattern;

public class Condition {

    private final String regex;

    public Condition(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public Pattern regexPattern() {
        return Pattern.compile(regex);
    }
}

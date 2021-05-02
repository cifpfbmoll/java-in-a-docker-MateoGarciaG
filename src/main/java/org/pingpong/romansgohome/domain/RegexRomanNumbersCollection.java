package org.pingpong.romansgohome.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RegexRomanNumbersCollection {

    private final Map<String, String> regexDictionary = new HashMap<String, String>();


    public void addRegex(String key, String value) {
        this.regexDictionary.put(key, value);
    }

    public Map<String, String> getRegexDictionary() {
        return regexDictionary;
    }

    public String getRegexValue(String key) {
        String value = this.regexDictionary.get(key);

        return (value == null) ? "This Regex was not found" : value;
    }

    public Collection<String> getAllRegex() {
        return this.regexDictionary.values();
    }

    public long sizeRegexDictionary() {
        return this.regexDictionary.size();
    }


}

package org.pingpong.romansgohome.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslatorRomanNumbers {

    private String romanNumber = null;
    // Short due to we want optimizies the memory
    private short decimalNumber = 0;

    private RegexRomanNumbersCollection regexDictionary = new RegexRomanNumbersCollection();

    public TranslatorRomanNumbers() {
    }

    public TranslatorRomanNumbers(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public void setRegexDictionary(RegexRomanNumbersCollection newCollection) {
        this.regexDictionary = newCollection;
    }

    public RegexRomanNumbersCollection getregexDictionary() {
        return this.regexDictionary;
    }

    public String getRomanNumber() {
        return this.romanNumber;
    }

    public void setDecimalNumber(short decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public short getDecimalNumber() {
        return this.decimalNumber;
    }

    public void initRegexDictionary() {
        this.getregexDictionary().addRegex("grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        this.getregexDictionary().addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");
    }

    public void addRegex(String description, String regex) {
        this.getregexDictionary().addRegex(description, regex);
    }

    public List<String> getAllRegex() {
        return new ArrayList<String>(this.getregexDictionary().getAllRegex());
    }

    private Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(this.romanNumber);
    }

    private short decimalValue(String romanNumber) {
        //RomansSymbols symbol = Enum.valueOf(RomansSymbols.class, romanNumber);
        RomansSymbols symbol = RomansSymbols.valueOf(romanNumber);
        return (short) symbol.getDecimalValue();

    }

    private void addRomanNumberToDecimal(Matcher matcher) {
        while (matcher.find()) {
            /*
            * Matcher.group() retorna subsecuencia aquellos strings
            * que coinciden con el regex. group() retorna un iterador por cada
            * resultado que haya obtenido el regex sobre ese string, en vez de retornan una
            * colección, sino que devuelve un iterador. Dando lugar a que para obtener
            * todos los resultados tengamos que usar el while con el find()
            * De esta forma, por cada resultado que saca el group(), el cual representa un
            * simbolo o número básico romano, lo convertimos a decimal con el método
            * decimalValue() method y acumulamos la suma en la variable: this.decimalNumber
            * */
            this.decimalNumber += decimalValue(matcher.group());
        }
    }

    public short toDecimal() {

        getregexDictionary().getAllRegex()
                .forEach(regex -> {
                    /*
                    * Get Regex Matcher Compile, ready to use and search
                    * which characters from a string matches the string
                    * */
                    Matcher matcher = createMatcher(regex);
                    /*
                    * Add all roman numbers values to decimal number,
                    * which were gotten by the regex from Matcher.
                    * */
                    this.addRomanNumberToDecimal(matcher);

                });
        /* Return decimal number with all roman numbers added to this number*/
        return getDecimalNumber();
    }


}

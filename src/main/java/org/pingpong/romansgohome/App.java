package org.pingpong.romansgohome;

import org.pingpong.romansgohome.domain.TranslatorRomanNumbers;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String test = "MMMDCCCLXXXVIII"; // 3888
        test = "MMDCCLXXVII";  // 2777
        test = "CDXLIV"; // 444
        test = "CDXXXIX"; // 439

        TranslatorRomanNumbers romanNumber = new TranslatorRomanNumbers(test);
        //romanNumber.initRegexDictionary();
        romanNumber.addRegex("grupoSumatorio", "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        romanNumber.addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");

        assertThat(romanNumber.toDecimal()).isEqualTo((short) 439);

        System.out.println((romanNumber.getDecimalNumber() != 0) ? romanNumber.getRomanNumber() + " = " +  romanNumber.toDecimal() : "The roman number is incorrect");

    }
}

package org.pingpong.romansgohome.domain;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.pingpong.romansgohome.domain.TranslatorRomanNumbers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * @author @dfleta GitHub is the author of this test cases which according to Romans Go Home kata we can use to test our classes
 */

public class TranslatorRomanNumbersTest {

    private TranslatorRomanNumbers translator = null;

    @Before
    public void setUp() {
        this.translator = new TranslatorRomanNumbers();
        this.translator.initRegexDictionary();
    }

    @Test
    public void sumatoriesGroupTest() {

        Map<String, Short> dataSumatory = new HashMap<>();
        dataSumatory.put("I", (short)1);
        dataSumatory.put("II", (short)2);
        dataSumatory.put("III", (short)3);
        dataSumatory.put("V",(short)5);
        dataSumatory.put("VI",(short)6);
        dataSumatory.put("VII",(short)7);
        dataSumatory.put("VIII",(short)8);
        dataSumatory.put("XI",(short)11);
        dataSumatory.put("XII",(short)12);
        dataSumatory.put("XIII",(short)13);
        dataSumatory.put("XV",(short)15);
        dataSumatory.put("XX",(short)20);
        dataSumatory.put("XXI",(short)21);


        dataSumatory.forEach((key, value) -> {
            this.translator.setRomanNumber(key);
            this.translator.setDecimalNumber((short)0);
            assertThat(this.translator.toDecimal()).isEqualTo(value.shortValue());
        });


    }

    @Test
    public void subtractGroupTest() {

        Map<String, Short> dataSubstract = new HashMap<>();
        dataSubstract.put("IV", (short)4);
        dataSubstract.put("IX", (short)9);
        dataSubstract.put("IXX", (short)19);
        dataSubstract.put("XL",(short)40);
        dataSubstract.put("XLIV",(short)44);
        dataSubstract.put("XLV",(short)45);
        dataSubstract.put("XLIX",(short)49);
        dataSubstract.put("XC",(short)90);
        dataSubstract.put("XCIV",(short)94);
        dataSubstract.put("XCV",(short)95);
        dataSubstract.put("XCIX",(short)99);
        dataSubstract.put("CD",(short)400);
        dataSubstract.put("CM",(short)900);


        dataSubstract.forEach((key, value) -> {
            this.translator.setRomanNumber(key);
            this.translator.setDecimalNumber((short)0);
            assertThat(this.translator.toDecimal()).isEqualTo(value.shortValue());
        });


    }

}



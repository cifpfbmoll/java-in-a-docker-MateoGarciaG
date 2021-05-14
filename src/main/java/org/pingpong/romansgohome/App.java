package org.pingpong.romansgohome;

import org.pingpong.romansgohome.domain.TranslatorRomanNumbers;

import java.util.Scanner;

//import static org.assertj.core.api.Assertions.assertThat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String test = "MMMDCCCLXXXVIII"; // 3888
        //test = "MMDCCLXXVII";  // 2777
        //test = "CDXLIV"; // 444
        test = "CDXXXIX"; // 439

        // TranslatorRomanNumbers romanNumber = new TranslatorRomanNumbers(test);
        // //romanNumber.initRegexDictionary();
        // romanNumber.addRegex("grupoSumatorio", "((?<!C)[DM]|(?<!X)[LC](?![DM]))|((?<!I)[VX](?![LC])|I(?![VX]))");
        // // Para verlo de una mejor forma:
        // // ( (?<!C)[DM] | (?<!X)[LC](?![DM]) ) | ( (?<!I)[VX](?![LC]) | I(?![VX]) )
        // romanNumber.addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");
        // //romanNumber.initRegexDictionary();
        // //assertThat(romanNumber.toDecimal()).isEqualTo((short) 439);
        // System.out.printf("%s = %d", romanNumber.getRomanNumber(), romanNumber.toDecimal());
        // La linea siguiente dará error debido a que ya previamente habiamos llamado al método toDecimal()
        //System.out.println((romanNumber.toDecimal() != 0) ? romanNumber.getRomanNumber() + " = " +  romanNumber.toDecimal() : "The roman number is incorrect");

        TranslatorRomanNumbers romanNumberTranslator = new TranslatorRomanNumbers();

        romanNumberTranslator.addRegex("grupoSumatorio", "((?<!C)[DM]|(?<!X)[LC](?![DM]))|((?<!I)[VX](?![LC])|I(?![VX]))");
        // Para verlo de una mejor forma:
        // ( (?<!C)[DM] | (?<!X)[LC](?![DM]) ) | ( (?<!I)[VX](?![LC]) | I(?![VX]) )
        romanNumberTranslator.addRegex("grupoSustractivo", "(C[DM])|(X[LC])|(I[VX])");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Ingrese el número Romano: ");

            String romanNumber = sc.nextLine();

            romanNumberTranslator.setRomanNumber(romanNumber);

            System.out.printf("%s = %d", romanNumberTranslator.getRomanNumber(), romanNumberTranslator.toDecimal());


            System.out.println("\nDesea ingresar un nuevo número romano?: 1)Si 2)No");
            String reload = sc.nextLine();

            if(reload.equals("2")) {
                break;
            }
        }


        

    }
}

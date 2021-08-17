/*
 * Roman Numeral Integer to Numeral Converter
 * Code provided by Ben-Hur Langoni Junior via Stack Overflow
 * Author Username: https://stackoverflow.com/users/1420681/ben-hur-langoni-junior
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 * Date Answered: 11-03-13
 */

package tools;

import java.util.TreeMap;

public class RomanNumeral {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

}
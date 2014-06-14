/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.users;

import java.util.Arrays;

/**
 *
 * @author alexkurocha
 */

public class NameValidator implements IntStringValidator {
    // array contains all restricted names in upper case
    private final static String[] notAllowNames = {"KING", "LADY", "LORD", "QUEEN", "SIR"};// in alphabetical order for binary search
    // the arrey contains all restricted inthe end of the name chars
    private final static char[] romanNumerals = {'C', 'D', 'I', 'L', 'M', 'V', 'X'};// in alphabetical order for binary search

//validates a name
    @Override
    public boolean isValid(String text) {
        if (text == null || text.trim().length() == 0) {
            return false;
        }
        boolean isValid = false;
        if (Arrays.binarySearch(notAllowNames, text.toUpperCase()) < 0) { // the name not in the list
            if (Arrays.binarySearch(romanNumerals, text.charAt(text.length()-1)) < 0) {
                isValid = true;
            }
            
        }
        return isValid;
    }
    
}

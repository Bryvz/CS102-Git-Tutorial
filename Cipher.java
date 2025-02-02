// This class is used for encrypting or decrypting strings using character mapping
public class Cipher   
{
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET =   "dfxyhrklvwuasgimnojpqetbcz";

    public String encrypt(String inputString) {
        
        // output string will be collected in this variable, one char at a time
        String outputString = "";
        
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++)   
        {
            char ch = inputString.charAt(i);
            outputString += replaceChar(ch, true); // !!! corrected the char encryption
        }

        return outputString;
    }

    public String decrypt(String inputString) {
        
        String outputString = "";

        for (int i = 0; i < inputString.length(); i++) {
            outputString += replaceChar(inputString.charAt(i), false);
        }

        return outputString;
    }
    
    
    private char replaceChar(char inputChar, boolean isEncrypt) {
        
        if (isEncrypt) {
            int index = ORIGINAL_ALPHABET.indexOf(inputChar);
            if (index != -1) {
                return CIPHER_ALPHABET.charAt(index);
            }
        } 
        
        else {
            int index = CIPHER_ALPHABET.indexOf(inputChar);
            if (index != -1) {
                return ORIGINAL_ALPHABET.charAt(index);
            }
        }
        return inputChar;
    }
}
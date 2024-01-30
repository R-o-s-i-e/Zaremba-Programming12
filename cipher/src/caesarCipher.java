//package mycountwords

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.*;

class CaesarCipherClass {
	
	String lettersLowerCase = new String ("abcdefghijklmnopqrstuvwxyz");
	String lettersUpperCase = new String ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");	
	
    public static final int MAX_SHIFTS = 25;
    public static final int MAX_CHARS = 26;	
	
	private int key_id;
	
	Map<Integer, String> encryptMapLowerCase, encryptMapUpperCase;
	Map<Integer, String> decryptMapLowerCase, decryptMapUpperCase;
	
	public CaesarCipherClass (Integer key) {
		key_id = key % MAX_SHIFTS; // Ensure the key is valid.	
		
		// Now create the map
		encryptMapLowerCase = new HashMap<Integer, String>();
		decryptMapLowerCase = new HashMap<Integer, String>();
		encryptMapUpperCase = new HashMap<Integer, String>();
		decryptMapUpperCase = new HashMap<Integer, String>();		

        for (int i = 0; i < MAX_CHARS; i++) {		// i is the key
			String valueEncryptLowerCase = new String();
			String valueDecryptLowerCase = new String();
			String valueEncryptUpperCase = new String();
			String valueDecryptUpperCase = new String();

			for (int j = 0; j < MAX_CHARS; j++) {   // j is the index of the string
                valueEncryptLowerCase += lettersLowerCase.charAt((i + j)% MAX_CHARS);
				valueDecryptLowerCase += lettersLowerCase.charAt((MAX_CHARS + j - i)% MAX_CHARS);
				valueEncryptUpperCase += lettersUpperCase.charAt((i + j)% MAX_CHARS);
				valueDecryptUpperCase += lettersUpperCase.charAt((MAX_CHARS + j - i)% MAX_CHARS);                				
			}
			encryptMapLowerCase.put(i, valueEncryptLowerCase);
			decryptMapLowerCase.put(i, valueDecryptLowerCase);
			encryptMapUpperCase.put(i, valueEncryptUpperCase);
			decryptMapUpperCase.put(i, valueDecryptUpperCase);			
		}
		
		//System.out.print(encryptMapLowerCase + "\n");
		//System.out.print(decryptMapLowerCase + "\n");
		//System.out.print(encryptMapUpperCase + "\n");
		//System.out.print(decryptMapUpperCase + "\n");		
	}

    public String Encrypt(String plainText) {
		String valueEncrypt = new String();
        for (int i = 0; i < plainText.length(); i++) {

            char orgChar = plainText.charAt(i);
			if (Character.isLowerCase(orgChar)) {
			    valueEncrypt += encryptMapLowerCase.get(key_id).charAt(orgChar - 'a');
			}
			else if (Character.isUpperCase(orgChar)) {
			    valueEncrypt += encryptMapUpperCase.get(key_id).charAt(orgChar - 'A');	
			}				
			else {
				valueEncrypt += orgChar; // Non alphabet, just copy over
			}
		}
		return valueEncrypt;
	}
	
    public String Decrypt(String cipherText) {
		String valueDecrypt = new String();
        for (int i = 0; i < cipherText.length(); i++) {
			
            char orgChar = cipherText.charAt(i);			
			if (Character.isLowerCase(orgChar)) {
			    valueDecrypt += decryptMapLowerCase.get(key_id).charAt(orgChar - 'a');
			}
			else if (Character.isUpperCase(orgChar)) {
				valueDecrypt += decryptMapUpperCase.get(key_id).charAt(orgChar - 'A');
			}
			else {
				valueDecrypt += orgChar; // Non alphabet, just copy over
			}			
		}
		return valueDecrypt;		
	}		
	
}

public class caesarCipher {
	
	static boolean isInt(String s)
	{
		try {
			int i = Integer.parseInt(s); 
			return true; 
		}
		catch(NumberFormatException er) {
			return false; 
		}
	}	
	
    public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer key = 0;
		boolean loop = false;
		
		// Allow user to input the key, validate the user input
		if (args.length > 0 && args[0].equals("1")) {
			loop = true;
			System.out.println("Press Ctrl + C to exit any time. \n");
		}
		
		do {
			
			System.out.println("Input the key [0-25]: ");			
			while (scanner.hasNext()) {
   				String keyStr = scanner.nextLine();
				
				if (isInt(keyStr)) {
					key = Integer.valueOf(keyStr);
				}
				else {
					System.out.println("Input the key [0-25]: ");
					continue;
				}
				
				if (key >= 0 && key <= CaesarCipherClass.MAX_SHIFTS) {
					break;
				}
				else {
					System.out.printf("Maximum key is %d\n", CaesarCipherClass.MAX_SHIFTS);
					System.out.println("Input the key [0-25]: ");					
					continue;
				}
			}				
			 
		
			String testContent = new String ();
			System.out.println("Input the plaintext to Encrypt: ");			
			while (scanner.hasNext()) {
				testContent = scanner.nextLine();
				if (testContent.isEmpty()) {
					System.out.println("Input the plaintext to Encrypt: ");
					continue;
				}
				else {
					break;
				}
			}
			
			CaesarCipherClass cc = new CaesarCipherClass(key);
			
			String encrypted = cc.Encrypt (testContent);
			String decrypted = cc.Decrypt (encrypted);
			System.out.printf ("Plaitext:  " + testContent + "\n");			
			System.out.printf ("Encrypted: " + encrypted + "\n");
			System.out.printf ("Decrypted: " + decrypted + "\n");	
			
			if (decrypted.equals(testContent)) {			
				System.out.printf("Passed Test\n");
			}
			else {
				System.out.printf("Failed Test\n");
			}
		} while (loop);
	}
}
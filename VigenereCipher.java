package vigenerecipher;
import java.util.Arrays;
import java.util.Scanner;

public class VigenereCipher
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String plainText = sc.nextLine();
        String key=sc.nextLine();
        char[] plainTextChar = plainText.toUpperCase().toCharArray();
        char[] keyChar = Arrays.copyOf(key.toUpperCase().toCharArray(),plainTextChar.length);
        int i=0;
        for(int j=key.toCharArray().length;j<keyChar.length;j++)
        {
            keyChar[j]=keyChar[i];
            i++;
        }
        char[] cipherTextChar = new char[keyChar.length];
        for(i=0;i<cipherTextChar.length;i++)//Encryption
            cipherTextChar[i] = (char)(((int)plainTextChar[i] + (int)keyChar[i] - 130) % 26 + 65);// converting 2 ASCII value to normal index so -65 -65 = -130
        System.out.println("Cipher Text="+String.valueOf(cipherTextChar));
        char[] recoveredPlainTextChar = new char[cipherTextChar.length];
        for(i=0;i<recoveredPlainTextChar.length;i++)//Decryption
            recoveredPlainTextChar[i] = (char)(((int)cipherTextChar[i] - (int)keyChar[i] + 26) % 26 + 65);// we doesnot need and value to make it normal, since ASCII with another ASCII subtraction handle them self with same result, +26 is added since some value may exceed/deeced the parameter of mod26(when negative value is found during subtraction).  
        System.out.println("Recovered Plain Text="+String.valueOf(recoveredPlainTextChar).toLowerCase());
    }
}
/*
run:
wearediscoveredsaveyourself
deceptive
Cipher Text=ZICVTWQNGRZGVTWAVZHCQYGLMGJ
Recovered Plain Text=wearediscoveredsaveyourself
BUILD SUCCESSFUL (total time: 32 seconds)
*/

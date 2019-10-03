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
        //Making length of Key same as length of Plain Text message
        for(int j=key.toCharArray().length;j<keyChar.length;j++)
        {
            keyChar[j]=keyChar[i];
            i++;
        }
        char[] cipherTextChar = new char[keyChar.length];
        //Encryption
        for(i=0;i<cipherTextChar.length;i++)
        {
            cipherTextChar[i]=(char)(int) ((plainTextChar[i]+keyChar[i]-130)%26+65);
        }
        System.out.println("Cipher Text="+String.valueOf(cipherTextChar));
        char[] recoveredPlainTextChar = new char[cipherTextChar.length];
        //Decryption
        for(i=0;i<recoveredPlainTextChar.length;i++)
        {
            recoveredPlainTextChar[i] = (char)(int) ((cipherTextChar[i]-keyChar[i]+26)%26+65);
        }
        System.out.println("Recovered Plain Text="+String.valueOf(recoveredPlainTextChar).toLowerCase());
    }
}

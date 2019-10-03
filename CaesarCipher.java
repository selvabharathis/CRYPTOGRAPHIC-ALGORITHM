package caesarcipher;
import java.util.Scanner;
public class CaesarCipher 
{
    public static StringBuffer encrypt(String text, int s) //encryption
    { 
        StringBuffer result= new StringBuffer(); 
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) { 
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65); 
                result.append(ch); } 
            else { 
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97); 
                result.append(ch); } 
        } 
        return result; 
    } 
    public static StringBuffer decrypt(String text, int s) //decryption
    { 
        StringBuffer result= new StringBuffer(); 
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) { 
                char ch = (char)(((int)text.charAt(i) - s - 65) % 26 + 65); 
                result.append(ch); } 
            else { 
                char ch = (char)(((int)text.charAt(i) - s - 97) % 26 + 97); 
                result.append(ch); } 
        } 
        return result; 
    } 
    public static void main(String[] args) 
    {
        Scanner ip = new Scanner(System.in);
        String message = new String();
        System.out.println("Enter the string for encryption=");
        message = ip.next();
        System.out.println("CipherText is "+encrypt(message,3));
        System.out.println("DecryptedText is "+decrypt(encrypt(message,3).toString(),3));
    }
}

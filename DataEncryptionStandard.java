package des;
import com.sun.crypto.provider.SunJCE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DES 
{
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, IllegalBlockSizeException, BadPaddingException 
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Security.addProvider(new SunJCE());
        System.out.println("Enter the plaintext message");//Getting PlainText Message From User
        String plainMessage = br.readLine();
        byte[] input = plainMessage.getBytes();
        BigInteger b = new BigInteger(1, input);
        System.out.println("PlainText in the binary form: " + b.toString(2));
        Cipher cipher = Cipher.getInstance("DES");
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key=keyGen.generateKey();
        System.out.println("The Key is:"+ Base64.getEncoder().encodeToString(key.getEncoded()));//Base64 works in Java 8 only
        //Encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(input);
        BigInteger b2 = new BigInteger(1, cipherText);
        System.out.println("CipherText in the binary form: " + b2.toString(2));
        //Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(cipherText);
        System.out.println();
        System.out.println("Recovered PlainText : " + new String(plainText));
    }
}
/*
run:
Enter the plaintext message
how are you
PlainText in the binary form: 110100001101111011101110010000001100001011100100110010100100000011110010110111101110101
The Key is:mEC86oZKufg=
CipherText in the binary form: 11011000010011100010101111111100101100010010000101100000001010101110100101101001101101001111111001000011001000011110110101011100

Recovered PlainText : how are you
BUILD SUCCESSFUL (total time: 46 seconds)
*/

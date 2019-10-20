package md5;
import com.sun.crypto.provider.SunJCE;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;
public class MD5 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Security.addProvider(new SunJCE());
        System.out.println("Enter the message");
        String message=br.readLine();
        byte[] input = message.getBytes();
        System.out.println("Message: " + new String(input));
        MessageDigest md = MessageDigest.getInstance("MD5");     // Message Digest 5 Algorithm
        //MessageDigest md = MessageDigest.getInstance("SHA-1"); // SHA 1 Algorithm
        md.update(input);
        byte[] hash = md.digest();
        BigInteger b=new BigInteger(1,hash);
        String hashValue=b.toString(16);
        System.out.println("MessageDigest in HexaDecimal Format: " + hashValue);
    }
}
/*
run:
Enter the message
Rahul Dravid is the best
Message: Rahul Dravid is the best
MessageDigest in HexaDecimal Format: a4f9986fd57fb74ae3a9ef7c66fddf1a
BUILD SUCCESSFUL (total time: 14 seconds)
*/

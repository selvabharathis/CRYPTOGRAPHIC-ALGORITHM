package rsa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class RSA 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Encryption Constant:");
        BigInteger e = new BigInteger(br.readLine());
        System.out.println("Enter Prime Number 1:");
        BigInteger p = new BigInteger(br.readLine());
        System.out.println("Enter Prime Number 2:");
        BigInteger q = new BigInteger(br.readLine());
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(phi);
        System.out.println("Enter PlainText Message:");
        BigInteger plainText = new BigInteger(br.readLine());
        BigInteger cipherText = plainText.modPow(e, n);
        System.out.println("CipherText:" + cipherText);
        BigInteger recoveredPlainText = cipherText.modPow(d, n);
        System.out.println("Recovered PlainText:" + recoveredPlainText);
    }
}
/*
run:
Enter Encryption Constant:
17
Enter Prime Number 1:
7
Enter Prime Number 2:
11
Enter PlainText Message:
8
CipherText:57
Recovered PlainText:8
BUILD SUCCESSFUL (total time: 31 seconds)
*/

package diffie.hellman;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class DiffieHellman 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the prime number:");
        BigInteger primeNumber = new BigInteger(br.readLine());
        System.out.println("Enter the primitive root of prime number:");
        BigInteger primitiveRoot = new BigInteger(br.readLine());
        System.out.println("Enter the private key of A:");
        BigInteger privateKeyA = new BigInteger(br.readLine());
        System.out.println("Enter the private key of B:");
        BigInteger privateKeyB = new BigInteger(br.readLine());
        BigInteger publicKeyA = primitiveRoot.modPow(privateKeyA, primeNumber);
        BigInteger publicKeyB = primitiveRoot.modPow(privateKeyB, primeNumber);
        System.out.println("Public Key of A:" + publicKeyA);
        System.out.println("Public Key of B:" + publicKeyB);
        BigInteger sharedSecretKeyB = publicKeyA.modPow(privateKeyB, primeNumber);
        BigInteger sharedSecretKeyA = publicKeyB.modPow(privateKeyA, primeNumber);
        System.out.println("Shared Secret Key Computed By A:" + sharedSecretKeyA);
        System.out.println("Shared Secret Key Computed By B:" + sharedSecretKeyB);
    }
}
/*
run:
Enter the prime number:
353
Enter the primitive root of prime number:
3
Enter the private key of A:
45
Enter the private key of B:
50
Public Key of A:143
Public Key of B:155
Shared Secret Key Computed By A:197
Shared Secret Key Computed By B:197
BUILD SUCCESSFUL (total time: 23 seconds)
*/

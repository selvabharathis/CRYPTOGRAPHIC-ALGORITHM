package digitalsignaturestandard;
import com.sun.crypto.provider.SunJCE;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
public class DigitalSignatureStandard 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Security.addProvider(new SunJCE());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
        keyGen.initialize(512, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        Signature signature = Signature.getInstance("SHA1withDSA", "SUN");
        signature.initSign(keyPair.getPrivate(), new SecureRandom());
        String inputMessage = br.readLine();
        byte[] message = inputMessage.getBytes();
        signature.update(message);
        byte[] sigBytes = signature.sign();
        BigInteger signedMessage = new BigInteger(1, sigBytes);
        System.out.println("Digital Signature in HEX Format:"+signedMessage.toString(16));
        signature.initVerify(keyPair.getPublic());
        signature.update(message);
        if(signature.verify(sigBytes)==true)
            System.out.println("Signature is verified");
        else
            System.out.println("Signature is not matching");
    }
}

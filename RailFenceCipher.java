package railfencecipher;
public class RailFenceCipher
{
    int numRails;
    public RailFenceCipher(int numRails)
    {
	this.numRails = numRails;
    }
    String getDecryptedData(String data) 
    {
	char[] decrypted = new char[data.length()];
	int n = 0;
	for(int k = 0 ; k < numRails; k ++) 
        {
            int index = k;
            while(index < data.length() )
            {
                decrypted[index] = data.charAt(n++);
                if(k == 0 || k == numRails - 1) 
                    index = index + 2 * (numRails - 1);
            }
        }
        return new String(decrypted);
    }
    String getEncryptedData(String data) 
    {
	char[] encrypted = new char[data.length()];
	int n = 0;
	for(int k = 0 ; k < numRails; k ++) 
        {
            int index = k;
            while(index < data.length() ) 
            {
		encrypted[n++] = data.charAt(index);
		if(k == 0 || k == numRails - 1) 
                    index = index + 2 * (numRails - 1);
            }
	}
        return new String(encrypted);
    }
    public static void main(String[] args) 
    {
        String data = "meetmeaftertogaparty";
	RailFenceCipher railFenceCipher = new RailFenceCipher(2);
	String encrypted =railFenceCipher.getEncryptedData(data);
	System.out.println("encryption = "+encrypted);
	String decrypted = railFenceCipher.getDecryptedData(encrypted);
	System.out.println("decryption = "+decrypted);
    }
}
/*
run:
encryption = mematroaatetefetgpry
decryption = meetmeaftertogaparty
BUILD SUCCESSFUL (total time: 0 seconds)
*/

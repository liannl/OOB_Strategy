import javax.crypto.*;
import java.security.*;
public class SignatureCryptography implements Encryption{
    public String execute(final String data) throws Exception {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = SecureRandom.getInstanceStrong();
        generator.initialize(2048, random);
        KeyPair keyPair = generator.generateKeyPair();
        // Digital Signature
        Signature dsa = Signature.getInstance("SHA256withRSA");
        dsa.initSign(keyPair.getPrivate());
        // Update and sign the data
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] text = cipher.doFinal(data.getBytes());
        dsa.update(text);
        return new String(text);
    }
}

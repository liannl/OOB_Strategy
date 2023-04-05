import javax.crypto.*;
import java.security.*;
public class PublicKeyCryptography implements Encryption{

    public String execute(final String data) throws Exception {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        // Encrypt with PRIVATE KEY
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] text = cipher.doFinal(data.getBytes());

        return new String(text);
    }
}

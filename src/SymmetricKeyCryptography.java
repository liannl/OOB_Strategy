import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

public class SymmetricKeyCryptography implements Encryption{
    public String execute(final String data)  throws Exception {
        // Generate new key
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        Key key = keygen.generateKey();
        // Encrypt with key
        String transformation = "AES/ECB/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return DatatypeConverter.printHexBinary(encrypted);
    }
}


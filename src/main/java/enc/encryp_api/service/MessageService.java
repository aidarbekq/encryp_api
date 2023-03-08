package enc.encryp_api.service;

import enc.encryp_api.crypto.KeyPairGeneratorRSA;
import enc.encryp_api.crypto.RSAEncryption;
import enc.encryp_api.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Service
public class MessageService {

    private final KeyPair keyPair;

    @Autowired
    public MessageService() throws Exception {
        keyPair = KeyPairGeneratorRSA.generateRSAKeyPair();
    }

    public MessageDTO encryptMessage(String message) throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        PublicKey publicKey = keyPair.getPublic();
        byte[] encryptedData = RSAEncryption.encryptData(message, publicKey);
        messageDTO.setMessage(Base64.getEncoder().encodeToString(encryptedData));
        return messageDTO;
    }

    public MessageDTO decryptMessage(String encryptedMessage) throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encryptedData = Base64.getDecoder().decode(encryptedMessage);
        messageDTO.setMessage(RSAEncryption.decryptData(encryptedData, privateKey));
        return messageDTO;
    }
}


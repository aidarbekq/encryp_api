package enc.encryp_api.controller;

import enc.encryp_api.dto.MessageDTO;
import enc.encryp_api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) throws Exception {
        String message = messageDTO.getMessage();
        MessageDTO encryptedMessage = messageService.encryptMessage(message);
        return new ResponseEntity<>(encryptedMessage, HttpStatus.OK);
    }

    @PostMapping("/receiveMessage")
    public ResponseEntity<?> receiveMessage(@RequestBody MessageDTO encryptedMessageDTO) throws Exception {
        String encryptedMessage = encryptedMessageDTO.getMessage();
        MessageDTO decryptedMessage = messageService.decryptMessage(encryptedMessage);
        return new ResponseEntity<>(decryptedMessage, HttpStatus.OK);
    }
}

# encryp_api
**Encryption API**  
**Algorithm - "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"**  


This is a simple API that provides encryption and decryption functionalities for messages using RSA encryption algorithm.  
**The application will start running on `http://localhost:8082/api`**  
  
  
This API has two endpoints. One encrypts message, second decrypts encrypted message.  

**POST /sendMessage**  
`http://localhost:8082/api/sendMessage`  
`{
"message": "message"
}`  


**POST /receiveMessage**  
`http://localhost:8082/api/receiveMessage`  
`{
"message": "encrypted message"
}`  



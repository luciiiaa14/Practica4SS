package es.unican.ss.helloWorld;
 
import com.sun.xml.wss.impl.callback.PasswordValidationCallback;
 
public class PlainTextPasswordValidator implements PasswordValidationCallback.PasswordValidator {
 
    PasswordValidationCallback.PlainTextPasswordRequest plainTextPasswordRequest = null;
  
    public boolean validate(PasswordValidationCallback.Request request) throws PasswordValidationCallback.PasswordValidationException {
 
        plainTextPasswordRequest = (PasswordValidationCallback.PlainTextPasswordRequest) request;
        System.out.println("Voy a validar");
 
        // here actually we can integrate with database or LDAP server for authentication
        System.out.println("Username: "+plainTextPasswordRequest.getUsername());
        System.out.println("Password: "+plainTextPasswordRequest.getPassword());
        
        if(plainTextPasswordRequest.getUsername().equals("patri") && 
        		plainTextPasswordRequest.getPassword().equals("patri")) {
            return true;
        }
        return false;
    }
}
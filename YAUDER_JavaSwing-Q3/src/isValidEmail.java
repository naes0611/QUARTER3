
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ihub27
 */
public class isValidEmail {
    private static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        ArrayList<String> emails = new ArrayList<>();
        
        emails.add("johndoe@gmail.com");
        
        emails.add("johndoe.emal.com");
        
        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " is " + (matcher.matches() ? "valid" : "invalid"));
        }
    }
}

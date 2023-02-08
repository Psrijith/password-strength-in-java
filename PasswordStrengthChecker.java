import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class PasswordStrengthChecker {
    public static String checkPasswordStrength(String password) {
        Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern upperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        
        Matcher hasSpecialChar = specialCharPatten.matcher(password);
        Matcher hasUpperChar = upperCasePatten.matcher(password);
        Matcher hasLowerChar = lowerCasePatten.matcher(password);
        Matcher hasDigit = digitCasePatten.matcher(password);
        
        boolean strongPassword = password.length() >= 8 && hasSpecialChar.find() && hasUpperChar.find() && hasLowerChar.find() && hasDigit.find();
        boolean averagePassword = password.length() >= 8 && (hasSpecialChar.find() || hasUpperChar.find()) && (hasLowerChar.find() && hasDigit.find());
        
        if (strongPassword) {
            return "Good";
        } else if (averagePassword) {
            return "Average";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        System.out.println(checkPasswordStrength(s));
    }
}

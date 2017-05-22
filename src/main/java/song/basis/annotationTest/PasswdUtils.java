package song.basis.annotationTest;

import java.util.List;

/**
 * Created by Song on 2016/10/25.
 */

public class PasswdUtils {
    @UseCase(id=47,description = "Passwords must contains one numeric")
    public boolean validatePassword(String passwd){
        return passwd.matches("\\w*\\d\\w*");
    }
    @UseCase(id = 48)
    public String encryptPassword(String passwd){
        return new StringBuilder(passwd).reverse().toString();
    }
    public boolean checkForNewPasswd(List<String> prevPasswds, String passwd){
        return !prevPasswds.contains(passwd);
    }
}

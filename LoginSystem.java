import java.util.HashMap;
public class LoginSystem {
    public static void main(String[] args) throws Exception {
       IdandPasswords idandPasswords = new IdandPasswords();
       LoginInfo loginInfo = new LoginInfo(idandPasswords.getLoginInfo());
    }
}

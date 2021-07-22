import java.util.HashMap;
public class IdandPasswords{
    HashMap <String, String> loginInfo = new HashMap<String,String>();
    IdandPasswords(){
        loginInfo.put("Ritaja","ABC123");
        loginInfo.put("Anaranya","ABC@123");
        loginInfo.put("Subradeep","ABC#123");
    }
    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
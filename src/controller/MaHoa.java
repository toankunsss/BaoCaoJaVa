package controller;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Toan
 */
public class MaHoa {
    public static String toSHAL(String mk){
        String salt="sadasdasdasdasda%##&@d;93";
        String result=null;
        mk=mk+salt;
        try {
            byte[] dataByes=mk.getBytes("UTF-8");
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            result=Base64.encodeBase64String(md.digest(dataByes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(toSHAL("123"));
    }
}

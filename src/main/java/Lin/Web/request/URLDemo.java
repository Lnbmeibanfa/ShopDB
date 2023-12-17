package Lin.Web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "张三";
        String encode = URLEncoder.encode(username,"utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode,"ISO-8859-1");
        System.out.println(decode);

        byte[] bytes = decode.getBytes("ISO-8859-1");
        String s =  new String(bytes,"UTF-8");
        System.out.println(s);
    }
}

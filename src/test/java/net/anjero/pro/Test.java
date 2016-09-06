package net.anjero.pro;

import net.anjero.pro.core.TestApi;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by Anjero on 16/8/25.
 */
public class Test extends TestApi {


    public static void main(String[] args) {
        System.out.println(new Md5PasswordEncoder().encodePassword("123456", "admin"));
    }
}

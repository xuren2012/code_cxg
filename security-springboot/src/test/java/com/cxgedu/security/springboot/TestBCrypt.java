package com.cxgedu.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by YTF
 * 2019/12/9
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt(){
       //对密码进行加密
        String hashpw = BCrypt.hashpw("456", BCrypt.gensalt());
        System.out.println("===========================:"+hashpw);
       //校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$J6TkQTozaTkkjUA7QqgvvewhvHO7OBbA0fYVLpwR18nC.BJIr/ZFK");
        System.out.println(checkpw);
    }
}

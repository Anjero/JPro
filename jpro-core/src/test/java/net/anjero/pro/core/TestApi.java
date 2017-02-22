package net.anjero.pro.core;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * <p>pinsolution Create by 14/12/22 下午4:49</p>
 *
 * @author :anjero
 * @version :1.0
 */

@RunWith(Junit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:mybatis.xml",
        "classpath:spring.xml",
        "classpath:spring-mybatis.xml",
})
public class TestApi extends AbstractTransactionalJUnit4SpringContextTests {


}

package net.anjero.pro.core;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * <p>maxpoint Create by 15/4/2 上午12:15</p>
 *
 * @author :anjero
 * @version :1.0
 * @company:MAXPOINT
 */


public class Junit4ClassRunner extends SpringJUnit4ClassRunner {


    static {
        try {
            Log4jConfigurer.initLogging("classpath:lo4j.xml");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    /**
     * Constructs a new {@code SpringJUnit4ClassRunner} and initializes a
     * {@link org.springframework.test.context.TestContextManager} to provide Spring testing functionality to
     * standard JUnit tests.
     *
     * @param clazz the test class to be run
     * @see #createTestContextManager(Class)
     */
    public Junit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}

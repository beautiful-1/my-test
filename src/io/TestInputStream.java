package io;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static junit.framework.TestCase.assertEquals;

/**
 * @author LZN
 * @Title TestInputStream
 * @ProjectName pattern
 * @Description
 * @date 2022-11-15 16:45
 **/
public class TestInputStream {
    private InputStream inputStream;
    private static final String CONTENT = "Hello World";

    @Before
    public void setUp() throws Exception {
        this.inputStream = TestInputStream.class.getResourceAsStream("/input.text");
    }

    @Test
    public void testReadAllBytes() throws Exception{
        final String content=new String(this.inputStream.readAllBytes());
        assertEquals(CONTENT, content);

    }

}

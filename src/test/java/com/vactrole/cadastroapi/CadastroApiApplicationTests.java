package com.vactrole.cadastroapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CadastroApiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testStrings() {

        String string1 = "um";
        String string2 = "dois";
        String string3 = "um";

        Assertions.assertNotEquals(string1,string2);
        Assertions.assertEquals(string1,string3);

    }

}

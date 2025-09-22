package com.ansut;

import org.testng.annotations.*;

import com.ansut.Login.LoginAnsut;

public class CreateTicket {

    private LoginAnsut loginAnsut;

    @BeforeClass
    public void setUp() {
        loginAnsut = new LoginAnsut();
        loginAnsut.setUp();
    }

    @Test
    public void testLoginSuccess() {
        // loginAnsut.login("jukon", "jukon");
    }

    // @AfterClass
    // public void tearDown() {
    //     loginAnsut.tearDown();
    // }
}

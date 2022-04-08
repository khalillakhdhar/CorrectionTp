package com.th;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CorrectionTpApplicationTests {
AdminValidation adv;
GlobaleValidation gv;
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init()
	{
		
		adv=new AdminValidation();
		gv=new GlobaleValidation();
		
	}
	@Test
	public void verifEmpty()
	{
		assertTrue(gv.verifEmpty(""));
		
	}
	@Test
	public void verifPass()
	{
		assertTrue(adv.validPassword("teste123", "khalil"));
	}
}

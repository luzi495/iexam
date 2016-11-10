package org.luzi.soft2.iexam.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luzi.soft2.iexam.service.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestUnitController2 {
	@Autowired
	WebApplicationContext applicationContext;

	@Before
	public void before() {
	}

	@Test
	public void test() throws Exception {
		assertNotNull(this.applicationContext.getBean(UnitRepository.class));
	}
}

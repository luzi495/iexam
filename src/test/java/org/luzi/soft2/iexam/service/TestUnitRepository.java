package org.luzi.soft2.iexam.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luzi.soft2.iexam.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUnitRepository {
	@Autowired
	private UnitRepository ur;

	@Before
	public void before() {
		Unit p = new Unit();
		p.title = "p1";
		Unit c1 = new Unit();
		c1.title = "c1";
		Unit c2 = new Unit();
		c2.title = "c2";
		p.children.add(c1);
		p.children.add(c2);
		//
		ur.save(p);
	}
	@Test
	public void test() throws Exception {
		assertNotNull(ur);
		List<Unit> ll = ur.findAll();
		assertTrue(ll.size()>0);
	}
}

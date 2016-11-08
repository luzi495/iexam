package org.luzi.soft2.iexam.web;

import static com.alibaba.fastjson.JSON.toJSONString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luzi.soft2.iexam.domain.Unit;
import org.luzi.soft2.iexam.service.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
//@WebAppConfiguration
public class TestUnitController {
	@Autowired
	private MockMvc mvc;
//	 @Autowired
//	 WebApplicationContext applicationContext;
	 @MockBean
	 private UnitRepository service;
	private Unit p;

	@Test
	public void add() throws Exception {
		this.mvc.perform(post("/unit").contentType(MediaType.APPLICATION_JSON).content(toJSONString(p)))
		.andExpect(status().isOk()).andDo(print()).andReturn();
	}

//	 @Test
//	 public void all() throws Exception {
//	 this.mvc.perform(get("/unit")).andExpect(content().string("[]")).andExpect(status().isOk());
//	 }
	//
//	@Test
//	public void shouldHaveRealService() throws Exception {
//		assertThat(this.applicationContext.getBean(UnitRepository.class)).isNotNull();
//	}

	@Before
	public void before() {
//		mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();  //初始化MockMvc对象
		
		p = new Unit();
		p.title = "p1";
		Unit c1 = new Unit();
		c1.title = "c1";
		Unit c2 = new Unit();
		c2.title = "c2";
		p.children.add(c1);
		p.children.add(c2);
	}
	// @Test
	// public void getHello() throws Exception {
	// mvc.perform(MockMvcRequestBuilders.get("/unit").accept(MediaType.APPLICATION_JSON))
	// .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	// }
	// @Test
	// public void test() throws Exception {
	// mvc.perform(MockMvcRequestBuilders.post("/unit",
	// p).accept(MediaType.APPLICATION_JSON))
	// .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	// }
}

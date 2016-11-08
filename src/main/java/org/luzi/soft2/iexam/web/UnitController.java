package org.luzi.soft2.iexam.web;

import java.util.List;

import org.luzi.soft2.iexam.domain.Unit;
import org.luzi.soft2.iexam.service.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	private UnitRepository ur;

	/** 列表 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Unit> all() {
		System.out.println("=======" + ur);
		return ur.findAll();
	}

	/** 进入新增 */
	@RequestMapping("/new")
	public String _new() {
		return null;
	}

	/** 显示 */
	@RequestMapping(value = "/{id}")
	public String show(@PathVariable Long id) {
		return null;
	}

	/** 保存新增 */
	@RequestMapping(method = RequestMethod.POST)
	public Unit create(@RequestBody Unit u) {
		u = ur.save(u);
		System.out.println("create====");
		return u;
	}

	/** 保存更新 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Unit update(@PathVariable Long id, Unit u) {
		return u;
	}

	/** 删除 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {

	}

	/** 批量删除 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void batchDelete() {

	}
}
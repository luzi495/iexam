
package org.luzi.soft2.iexam.service;

import java.util.List;

import org.luzi.soft2.iexam.domain.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Long> {
	public List<Unit> findAll();
}
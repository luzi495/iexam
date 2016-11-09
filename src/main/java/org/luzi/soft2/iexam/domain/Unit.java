package org.luzi.soft2.iexam.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	public Long id;
	
	@Column(nullable = false)
	public String title;
	
	@Column
	public String description;
	
	@Column
	public String icon;

	/** 父组织 */
	@ManyToOne
	@JoinColumn(name = "parent_id")
	public Unit parent;

	/** 子组织 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Set<Unit> children = new HashSet<Unit>();

}

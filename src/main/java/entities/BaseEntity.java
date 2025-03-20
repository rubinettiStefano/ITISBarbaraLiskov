package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;

	public BaseEntity()	{	}

	public BaseEntity(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
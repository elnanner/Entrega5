package clasesDAO;

public interface GenericDAO<T> {

	public T update(T entity);
	public void delete(T entity);
	//public T borrar(Long id);
	public boolean exists(Long id);
	public T persist(T entity);
	public T get(Long id);
	public Integer getCount();
	
}

package repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface of repository classes to manager database registers
 */

public interface IRepository<I, T> {
    /* 
     * To save/update entity on database
     * @param entity - entity data to persist on database
     * @return new entity saved/updated on database
     */
    T save(T entity);
    /**
     * Trying find register by id on database
     * @param id
     * @return when founded entity return it otherwise empty
     */
    
    Optional<T> findById(I id);

    /**
     * List all entities on database
     * @return all entities
     */

    List<T> findAll();
}

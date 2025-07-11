package repository;

import java.util.Optional;

public interface IRepository<I, T> {
    T save(T entity);
    
    Optional<T> findById(I id);
}

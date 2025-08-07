package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Product;

/**
 * Repository of product table
 */

public class ProductRepository implements IRepository<Long, Product> {
    // fake database
    private static final List<Product> FAKE_DATABASE = new ArrayList<>();
    // fake last_insert_id()
    private static long currentId = 1l;

    @Override
    public Product save(Product entity) {
        var isUpdate = entity.getId() != null && entity.getId() > 0;

        if (isUpdate) {
            for (int i = 0; i < FAKE_DATABASE.size(); i++) {
                if (FAKE_DATABASE.get(i).getId().longValue() == entity.getId().longValue()) {
                    FAKE_DATABASE.set(i, entity);
                }
            }

            var newEntity = new Product();
            newEntity.setName(entity.getName());
            newEntity.setStock(entity.getStock());
            newEntity.setValue(entity.getValue());
            newEntity.setId(entity.getId());

            return newEntity;

        } else {
            var newEntity = new Product();
            newEntity.setName(entity.getName());
            newEntity.setStock(entity.getStock());
            newEntity.setValue(entity.getValue());
            newEntity.setId(currentId);
            currentId++;

            FAKE_DATABASE.add(newEntity);
            return newEntity;
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        var product = FAKE_DATABASE.stream().filter(p -> p.getId() == id).findFirst();
        return product;
    }

    @Override
    public List<Product> findAll() {
        var clone = new ArrayList<Product>();

        FAKE_DATABASE.stream().forEach(clone::add);

        return clone;
    }
}

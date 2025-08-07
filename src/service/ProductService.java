package service;

import java.util.List;
import java.util.Optional;

import model.Product;
import repository.ProductRepository;

/**
 * The bridge between {@link ProductRepository} and owner app surface
 */
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * To persist a new register on database
     * 
     * @param product
     * @return new product on database with id
     */
    public Product insert(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    /**
     * To persist update data from register on database
     * 
     * <p>
     * <b>Attention: {@code id} is required</b>
     * </p>
     * 
     * @param product
     * @return new product instance of data on database
     */
    public Product update(Product product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("Entity id is required");
        }

        return productRepository.save(product);
    }

    /**
     * To get all register on database
     * 
     * @return
     */
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * Trying find product by id on database
     * 
     * @param id
     * @return when founded product return it otherwise empty
     */
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }
}

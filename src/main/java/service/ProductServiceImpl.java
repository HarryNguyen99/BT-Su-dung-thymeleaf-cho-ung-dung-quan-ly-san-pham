package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static  Map<Integer, Product> products;
    private static int size = 1;
    static {
        products = new HashMap<>();
        products.put(size++, new Product(1, "Iphone X pro max", 1500, 100, "phone"));
        products.put(size++, new Product(2, "Ipad 4", 500, 500, "tablet"));
        products.put(size++, new Product(3, "Hp 8570p", 300, 150, "laptop"));
        products.put(size++, new Product(4, "Aripod 2", 350, 1000, "headphone"));
        products.put(size++, new Product(5, "Tổ Ong", 5, 1102, "Dép"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}

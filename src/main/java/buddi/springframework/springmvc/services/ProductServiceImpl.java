package buddi.springframework.springmvc.services;

import buddi.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer,Product> products;

    public ProductServiceImpl() {
       loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) { return products.get(id); }

    @Override
    public Product saveOrUpdateProduct(Product product) {

        if(product != null){
            if(product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);
            return product;
        } else {
            throw new RuntimeException("Product can't be null");
        }

    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private Integer getNextKey() {
        return Collections.max(products.keySet()) +1;
    }

    private void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("testing url");

        products.put(1,product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("product 2");
        product2.setPrice(new BigDecimal("13.99"));
        product2.setImageUrl("testing url2");

        products.put(2,product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("product 3");
        product3.setPrice(new BigDecimal("14.99"));
        product3.setImageUrl("testing url3");

        products.put(3,product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("product 4");
        product4.setPrice(new BigDecimal("15.99"));
        product4.setImageUrl("testing url4");

        products.put(4,product4);


    }


}

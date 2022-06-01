package buddi.springframework.springmvc.services;

import buddi.springframework.springmvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();
}

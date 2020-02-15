package com.cg.pms.dao;
import java.util.*;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductDao 
{
public int addProduct(Product product)throws ProductException;
public Product findProductId(int productId) throws ProductException;
public Product deleteProductId(int productId)throws ProductException;
public List<Product> findAllProduct()throws ProductException;

}

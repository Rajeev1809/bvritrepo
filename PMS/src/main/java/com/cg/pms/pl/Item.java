package com.cg.pms.pl;
import java.util.*;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;

public class Item {
	public static void main(String[] args) {
		
	
Scanner scan=new Scanner(System.in);
ProductService productService=new ProductServiceImpl();
int choice=0;
Product product=null;
List<Product> list=null;
while(choice!=5)
{
	System.out.println("1. Add Product");
	System.out.println("2. search Product");
	System.out.println("3. Delete Product");
	System.out.println("4. list all Product");
	System.out.println("5. Exit");
	System.out.println("enter choice");
	choice=scan.nextInt();
	switch(choice)
	{
	case 1:
		System.out.println("Enter Name");
		scan.nextLine();
		String Name=scan.nextLine();
		System.out.println("Enter price");
		double price=scan.nextDouble();
		product=new Product();
		product.setProductName(Name);
		product.setPrice(price);
		try
		{
			int id=productService.addProduct(product);
			System.out.println("product id="+id);
		}catch(ProductException e)
		{
			System.err.println(e.getMessage());
		}
		
		break;
	case 2:
		System.out.println("enter product id");
		int id=scan.nextInt();
		try 
		{
			product=productService.findProductId(id);
		System.out.println("name ="+product.getProductName());
		System.out.println("price="+product.getPrice());
		}catch(ProductException e)
		{
			System.err.println(e.getMessage());
		}
		
		break;
	case 3:
		
		System.out.println("enter product id");
		 id=scan.nextInt();
		try 
		{
			product=productService.deleteProductId(id);
		
		}catch(ProductException e)
		{
			System.err.println(e.getMessage());
		}
		
		
		break;
	case 4:
		try
		{
			list=productService.findAllProduct();
		
	for(Product pro:list)
	{
	 id=pro.getProductId();
	 Name=pro.getProductName();
	price=pro.getPrice();
	 System.out.println(id+" "+Name+" "+price);
	}
	}catch(ProductException e)
		{
		System.err.println(e.getMessage());
		}
		
		
		break;
	case 5:System.out.println("thank you");
	return;
	}
}

}

}
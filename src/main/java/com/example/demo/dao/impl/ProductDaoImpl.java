package com.example.demo.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.ProductModel;

public class ProductDaoImpl implements ProductDao {





	ArrayList<ProductModel> list=new ArrayList<>();  
	
	public ProductDaoImpl() {
		
		list.add(new ProductModel(1l, "pen", 1500d , 100, new Date(2022, 12, 15), new Date(202, 12, 15), new Date(202, 12, 18)));
		list.add(new ProductModel(2l, "apple", 2000d , 100, new Date(2022, 12, 15), new Date(202, 12, 15), new Date(202, 12, 18)));
		list.add(new ProductModel(3l, "book", 10d , 100, new Date(2022, 12, 15), new Date(202, 12, 15), new Date(202, 12, 18)));
		
		
	} 


	@Override
	public int addProduct(ProductModel productmodel) {
		// TODO Auto-generated method stub

		int status=0;

		for (ProductModel existingProduct : list) {

			if (productmodel.getProductname().equals(existingProduct.getProductname())) {
				status=2;
				break;
			}
		}
			if(status!=2) {
				try {list.add(productmodel);
				status=1;

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					status=3;
				}

			}

		


		for (ProductModel product : list) {
			System.out.println(product);
		}

		return status;
	}


	@Override
	public int DeleteProductByID(long ProductId) {
		
		int status=0;
		for (ProductModel productModel1 : list) {
			
			
			if(productModel1.getProductid()==ProductId)
			{
				list.remove(ProductId);
				return status=1;
			}

			if(status!=1) {
				try {
				status=2;

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					status=3;
				}

			}

			
		}
		
		
		return status;
	}


	@Override
	public ProductModel getProductById(long ProductId) {
	
		for (ProductModel productModel : list) {
			
			if (productModel.getProductid()==ProductId)
			{
				return productModel;
			}
			
			
		}
		
		
		
		return null;
	}


	@Override
	public int UpdateProduct(ProductModel productmodel) {
		int status=0;
	
	try {for (ProductModel databaseProduct : list) {
		
	if ( productmodel.getProductid()== databaseProduct.getProductid()  )
	{
		list.set(list.indexOf(databaseProduct), productmodel);
		
		
		return status=1;
	}
	}
	}
	 catch (Exception e) {
		return status=3;
	}	
		
	
	
		
		
		return 0;
		
	}
		
		
		
		
		
		
		
		
		
		
	


	@Override
	public List<ProductModel> GetallProducts() {
	
		
		
		return list;
	}


	//@Override
	//public List<ProductModel> getProductInAscendingOrder() {
		
		
		//ArrayList<ProductModel>productlist=new ArrayList<>();
		
		
		
		
		
		
		
		
	


	@Override
	public List<ProductModel> getProductInAscendingOrderofPrice() {
		
		
		ArrayList<ProductModel>productlist=new ArrayList<>(list);
		
		Collections.sort(productlist ,Comparator.comparing(ProductModel::getProductprice));
		
		return productlist;
	}


	@Override
	public List<ProductModel> getProductInAscendingOrderofName() {
		// TODO Auto-generated method stub
		
Collections.sort(list ,Comparator.comparing(ProductModel::getProductname));
		
		
		

		return list;
		
		
	}


	@Override
	public ProductModel GetProductByName(String productname) {
	
		for (ProductModel productModel : list) {
			
			if(productModel.getProductname().equals(productname))
			{
				return productModel;
			}
		}
		
		
		return null;
	}


	@Override
	public ArrayList<ProductModel> PriceGreaterThan(int price) {
		// TODO Auto-generated method stub
		
		ArrayList<ProductModel>productsWithGreaterPrice=new ArrayList<>();
		
		for (ProductModel productModel : list) {
			
			if(productModel.getProductprice()>price)
			{
				
				productsWithGreaterPrice.add(productModel);
				
			}
			
		}
		
		
		
		
		return productsWithGreaterPrice;
		
		
		
	}


	@Override
	public ProductModel ProductWithMaxPrice() {

		ProductModel maxProdPrice=list.get(0);
		
		for (ProductModel productModel : list) {
			
		if(productModel.getProductprice()>maxProdPrice.getProductprice())
		{
			maxProdPrice=productModel;
			
			
		}
		
			
		}
		
		
		return maxProdPrice;
		
	}


	@Override
	public ArrayList<ProductModel> getProductsInPriceRange(int low, int high) {
		// TODO Auto-generated method stub
		
		ArrayList<ProductModel>ProductsWithinRange=new ArrayList<>();
		
		for (ProductModel productModel : list) {
			
		if(productModel.getProductprice()>low && productModel.getProductprice()<high) {
			
			ProductsWithinRange.add(productModel);
		}
			
			
		}
		
		
		
		
		return ProductsWithinRange ;
		
		
		
		
		
		
	}


	@Override
	public ArrayList<ProductModel> sortProducts(String orderType, String propertyName ) {
		// TODO Auto-generated method stub
		
		
		
		
		if (orderType.equals("ascending") && propertyName.equals("price"))
		{	
         ArrayList<ProductModel>productlist=new ArrayList<>(list);
		
		Collections.sort(productlist ,Comparator.comparing(ProductModel::getProductprice));
		
		
		return productlist;
		}
		
		else if (orderType.equals("ascending") && propertyName.equals("name"))
		
		{
			 ArrayList<ProductModel>productlist=new ArrayList<>(list);
			Collections.sort(productlist ,Comparator.comparing(ProductModel::getProductname));
			
			return productlist;
		}
		
		else if((orderType.equals("descending") && propertyName.equals("price")))
		{
			 ArrayList<ProductModel>productlist=new ArrayList<>(list);
				
				Collections.sort(productlist ,Comparator.comparing(ProductModel::getProductprice).reversed());
				
				
				return productlist;
			
		}
		else if((orderType.equals("descending") && propertyName.equals("name")))
		{

			 ArrayList<ProductModel>productlist=new ArrayList<>(list);
			Collections.sort(list ,Comparator.comparing(ProductModel::getProductname).reversed());
			
			return productlist;
			
		}
		else return null;
		
	}
	
	
	
	
	
	
	
	
}
		



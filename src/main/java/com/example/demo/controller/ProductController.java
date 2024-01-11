package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.ProductServiceimpl;

@RestController
public class ProductController {

	ProductService service=new ProductServiceimpl();
	
	
	@PostMapping("addProduct")
	public String addProduct(@RequestBody @Valid  ProductModel productModel) {

		
		int status = service.addProduct(productModel);
		if(status==1) {
			return "added sussessfully";
		}
		
		else if(status==2)
		{
			return "product name already exists  "+productModel.getProductname();
		}
		else {
			return "something went wrong";
		}
		
	}
	
		@DeleteMapping("/delete-Product-by-id/{ProductId}")
		
		public String DeleteProductByID(@PathVariable long ProductId) {
			
			int status = service.DeleteProductByID(ProductId);
			if(status==1) {
				return "deleted successfully";
			}
			
			else if(status==2)
			{
				return "product id does not exists  "+ProductId;
			}
			else {
				return "something went wrong";
			}
			
			
		}
		
		
	@GetMapping("/get-product-by-id/{productId}")	
	public Object getProductById(@PathVariable long productId )
	{
		
		
		
		
		ProductModel productModel = service.getProductById(productId);
		if(productModel!=null) {
			return productModel;
		}
		else {
			return "product not found with id "+productId;
		}
		
		
		
	}
	


	@PutMapping("/update-product-by-id") 
	
	public Object UpdateProduct(@RequestBody @Valid  ProductModel productModel  ) 
	{
		
		
		int status    =service.UpdateProduct(productModel);
		
	
		if(status==1) {
			return "updated successfully";
		}
		
		else if(status==2)
		{
			return "product id does not exists  ";
		}
		else {
			return "something went wrong";
		}
		
	}
	
	
	@GetMapping("/Get-all-products")
	
	public Object GetallProducts()
	{
		
		List<ProductModel> productModel =service.GetallProducts();
		
		//ArrayList<ProductModel>alist=new ArrayList();
		
		
		
		if (productModel!=null && !productModel.isEmpty())
		{
			
			
			return productModel;
		}
		else { return "list is empty" ;  }
		
		 
	}	
		
		
	@GetMapping("/Get-all-products-in-ascending-by-price")
		
	public Object getProductInAscendingOrder()
		    {
		
		 
		
List<ProductModel> productModel =service.getProductInAscendingOrderofPrice();
		
		if (productModel!=null && !productModel.isEmpty())
		{
			
			
			return productModel;
			
			
		}
		else { return "list is empty" ;  }
		
		    }
		
		@GetMapping("/Get-all-products-in-ascending-by-name")
		
		public Object getProductInAscendingOrderbyName()
		{
		List<ProductModel> productModel1 =service.getProductInAscendingOrderofName();
		
		if (productModel1!=null && !productModel1.isEmpty())
		{
			
			
			return productModel1;
		}
		else { return "list is empty" ;  }
		
		
		
	}
	
	
	@GetMapping("/get-product-by-name/{productname}")	
	
	public Object GetProductByName(@PathVariable String productname )
	{
		
		
		
		ProductModel productModel =service.GetProductByName(productname);
		
		if(productModel!=null) {
			return productModel;
		}
		else {
			return "product not found with name "+productname;
		}
		
	}
		
		
		
		@GetMapping("/price-Greater-than/{price}")
		
		public Object PriceGreaterThan(@PathVariable int price)
		{
			
			
			ArrayList<ProductModel>  products =service.PriceGreaterThan(price);
			
			
			
			
			if(products!=null) {
				return products;
			}
			else {
				return "product not found with price greater than "+price;
			}
			
		}	
			
			@GetMapping("/get-Product-with-max-Price")
			
		public Object ProductWithMaxPrice()	
		{
				
				ProductModel maxPrice	=service.ProductWithMaxPrice();
				
						
			if(maxPrice!=null) {
				return maxPrice;
			}
			else {
				return "product not found with maximum price ";
			}	
		}
			
			
			
			@GetMapping("products-within-price-range/{low}/{high}")
			public Object getProductsInPriceRange(@PathVariable int low , @PathVariable int high)
			{
				
				ArrayList<ProductModel> priceRange=service.getProductsInPriceRange(low,high);
				
				
				
				if(priceRange!=null) {
					return priceRange;				}
				 
				else {
					return "product not found within price range "+low +" "+high;
				}	
				
				 
				
				
				
				
			}
				
		
		@GetMapping("sort-products/{orderType}/{propertyName}")
			public Object sortProducts(@PathVariable String orderType,@PathVariable String propertyName ) {
			
			
			ArrayList<ProductModel>	 orderedProducts =service.sortProducts(orderType ,propertyName);
			
			if(orderedProducts!=null) {
				return orderedProducts;				}
			 
			else {
				return "something went wrong";
			}	
			
	        
}	

}
	

		
		
		
		

		
	
	
	
	
	



package com.sathya.mvc.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.repository.ProductRepository;

@Service
public class ProductService {
		@Autowired
		ProductRepository productRepository;
		public void saveProductData(ProductModel productModel)
		{
			double price =productModel.getProPrice();
			String category=productModel.getProCategory();
			double dprice=0.0;
						 switch (category) {
	         case "Mobile":
	             dprice = price * 0.1; 
	             break;
	         case "Laptop":
	        	 dprice = price * 0.15;
	             break;
	         case "Washing Machine":
	        	 dprice = price * 0.25;
	             break;
			 }
						 ProductEntity productEntity=new ProductEntity();
						 productEntity.setProName(productModel.getProName());
						 productEntity.setProCategory(productModel.getProCategory());
						 productEntity.setProDescription(productModel.getProDescription());
						 productEntity.setProPrice(productModel.getProPrice());
						 productEntity.setProBrand(productModel.getProBrand());
			 
						productEntity.setProDisPrice(dprice);
						productEntity.setCreatedAt(LocalDateTime.now());
						productEntity.setCreatedBy(System.getProperty("user.name"));
		 
		 
			 productRepository.save(productEntity);	 
			
		}
		
		public List<ProductEntity> getAllproducts()
		{
			List<ProductEntity> products=productRepository.findAll();
			return products;			
		}

		public void deleteById(Long proId) {
			   productRepository.deleteById(proId);			
		}

		public Optional<ProductEntity> editById(Long id)
		{
			 return productRepository.findById(id);	
		}

		
		public void updateProduct(Long proId, ProductEntity product) {
			Optional<ProductEntity> existingProduct = productRepository.findById(proId);
					if(existingProduct.isPresent())
					  {
					   double price = product.getProPrice();
					   String category = product.getProCategory();
					   double disPrice = 0.0;
					   
					   switch(category) {
					   case "Mobile":
					    disPrice = price*0.1;
					    break;
					   case "Computer":
					    disPrice = price*0.2;
					    break;
					   case "CPU":
					    disPrice = price*0.15;
					    break;
					   }
					ProductEntity productUpdate =existingProduct.get();
					productUpdate.setProName(product.getProName());
					productUpdate.setProPrice(product.getProPrice());
					productUpdate.setProBrand(product.getProBrand());
					productUpdate.setProDescription(product.getProDescription());
					productUpdate.setProCategory(product.getProCategory());
			
			productRepository.save(productUpdate);

		}
		}
}
	


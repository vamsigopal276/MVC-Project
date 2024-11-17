package com.sathya.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;

@Controller
public class ProductController {

	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		ProductModel productModel=new ProductModel();
		model.addAttribute("pm", productModel);
		productModel.setProBrand("vamsi");
		return "add-product";	
	}

	@Autowired
	ProductService productService;
@PostMapping("/product/save")
public String saveProduct(ProductModel productModel)
{
	productService.saveProductData(productModel);
	return "success";
}

@GetMapping("/getproductdata")
public String getProducts(Model model)
{
	List<ProductEntity> products=productService.getAllproducts();
	model.addAttribute("products",products);
	return "productlist";
}
@GetMapping("/delete/{id}")
public String deleteProduct(@PathVariable("id") Long proId)
{
    productService.deleteById(proId);
    return "redirect:/getproductdata";
}

@GetMapping("/edit/{id}")
public String editForm(@PathVariable("id") Long id, Model model) 
	{
	Optional<ProductEntity> product=productService.editById(id);
	model.addAttribute("product",product);
    return "Edit";
	}

@PostMapping("/update")
public String  updateProduct(@ModelAttribute Long id,ProductEntity productEntity) {
 productService.updateProduct(id,productEntity);
    return "redirect:/getproductdata";
}
}





 
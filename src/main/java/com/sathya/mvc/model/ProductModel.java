package com.sathya.mvc.model;

import com.sathya.mvc.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductModel
{

	private String proName;
	private String proBrand;
	private double proPrice;
	private String proDescription;
	private String proCategory;
	
}

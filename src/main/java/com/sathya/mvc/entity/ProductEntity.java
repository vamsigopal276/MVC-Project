package com.sathya.mvc.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String proDescription;
	private String proImage;
	private String proCategory;
	private LocalDateTime createdAt;
	private String createdBy;
	private double proDisPrice;
	
}

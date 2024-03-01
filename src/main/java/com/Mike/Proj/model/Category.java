package com.Mike.Proj.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Car_Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Category_Name")
	private @NotNull String categoryName;
	@Column(length = 1000)
	private @NotNull String description;
	@Column(length = 10000)
	private @NotNull String imageUrl;

	public Category(Integer id, String categoryName, String description, String imageUrl){
		this.id = id; // added this line to assign the id parameter to the id field
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}


	public Category(){
		// added some default values for the fields with @NotNull annotation
		this.id = 0;
		this.categoryName = "Unknown";
		this.description = "No description";
		this.imageUrl = "no_image.jpg";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}

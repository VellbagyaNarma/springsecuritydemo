package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="Food")
	public class Food {
		@Id
		
		private Long id;
		private String foodname;
		private String foodcolor;
		private String foodtype;
		
		
		
		public Food()
		{
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFoodname() {
			return foodname;
		}
		public void setFoodname(String foodname) {
			this.foodname = foodname;
		}
		public String getFoodcolor() {
			return foodcolor;
		}
		public void setFoodcolor(String foodcolor) {
			this.foodcolor = foodcolor;
		}
		public String getFoodtype() {
			return foodtype;
		}
		public void setFoodtype(String foodtype) {
			this.foodtype = foodtype;
		}
		

	}




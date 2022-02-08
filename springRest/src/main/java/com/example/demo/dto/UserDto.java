package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private String address;
	
	public int getId() {
		return id;
		}
		public void setId(int id) {
		this.id = id;
		}
		public String getName() {
		return name;
		}
		public void setName(String name) {
		this.name = name;
		}
		public String getAddress() {
		return address;
		}
		public void setAddress(String address) {
		this.address = address;
		}
		@Override
		public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
		}


}

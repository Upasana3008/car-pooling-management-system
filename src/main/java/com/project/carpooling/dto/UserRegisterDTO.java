package com.project.carpooling.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

	@NotBlank(message = "Name cannot be empty!")
    private String name;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Use right email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password should be atleast 4 characters")
    private String password;

    @NotBlank(message = "Phone number is required!")
    @Size(min = 10, max = 10, message = "Phone number exact 10 digits required")
    private String phone;
    
    
 // Default Constructor
    public UserRegisterDTO() {}
    
    
 // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

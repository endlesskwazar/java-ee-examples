package validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class User {
	@NotNull(message = "Поле ім'я обов'язкове.")
	@NotBlank(message = "Поле ім'я обов'язкове.")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Email(message = "Невалідний Email")
	private String email;
	
	@Positive(message = "Вік повинен бути позитивним")
	private Integer age;
}

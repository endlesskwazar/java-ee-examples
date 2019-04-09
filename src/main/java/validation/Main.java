package validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		User user = new User();
		user.setName("");
		user.setAge(-12);
		user.setEmail("qwe");
		
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		
		if(violations.isEmpty()) {
			//valid, can save
		}
		else {
			for (ConstraintViolation<User> violation : violations) {
				System.out.println(violation.getMessage());
			}
		}
	}

}

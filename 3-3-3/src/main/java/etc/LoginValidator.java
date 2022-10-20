package etc;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}//검증의 대상이 되는 객체를 설정한다.

	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if( ! StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
		}
		if( ! StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}

}

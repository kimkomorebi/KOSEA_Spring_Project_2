package etc;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}//검증의 대상이 되는 객체를 설정한다.

	public void validate(Object target, Errors errors) {//모든 자바 객체의 조상 객체 : Object
		User user = (User)target;
		if( ! StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");//에러 메세지 출력
			//StringUtils 문자열을 검사할 때 쓰는 객체
			//있는지 없는지 검사하는 메서드 hasLength >> 리턴 타입 boolean
		}
		if( ! StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}

}

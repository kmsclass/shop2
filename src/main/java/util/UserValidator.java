package util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class UserValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz); //유효성 검사를위한 객체의 자료형 검증
	}
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		String group = "error.required";
		if(user.getUserid() == null || user.getUserid().length() == 0) {
			errors.rejectValue("userid", group); //error.required.userid 오류등록
		}
		if(user.getPassword() == null || user.getPassword().length() == 0) {
			errors.rejectValue("password", group);
		}
		if(user.getUsername() == null || user.getUsername().length() == 0) {
			errors.rejectValue("username", group);
		}
		if(user.getPhoneno() == null || user.getPhoneno().length() == 0) {
			errors.rejectValue("phoneno", group);
		}
		if(user.getPostcode() == null || user.getPostcode().length() == 0) {
			errors.rejectValue("postcode", group);
		}
		if(user.getAddress() == null || user.getAddress().length()==0) {
			errors.rejectValue("address", group);
		}
		if(user.getEmail() == null || user.getEmail().length()==0) {
			errors.rejectValue("email", group);
		}
		if(errors.hasErrors()) { //오류 존재?
			errors.reject("error.input.user"); //글로벌 오류
		}		
	}
}
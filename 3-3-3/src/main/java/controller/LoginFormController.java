package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import etc.LoginValidator;
import model.User;

@Controller
public class LoginFormController {
		private UserDao userDao;
		private LoginValidator loginValidator;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		public void setLoginValidator(LoginValidator loginValidator) {
			this.loginValidator = loginValidator;
		}

		@ModelAttribute // 유저 객체 주입 (객체 생성을 해줌)
		public User setup() {
			return new User();
		}
		
		@RequestMapping(method=RequestMethod.GET) //콜백 메서드 선언
		public String loginform() {
			return "login";
		}
		
		@RequestMapping(method=RequestMethod.POST) //콜백 메서드 선언
		public ModelAndView loginDo() {
			return null;
		}
	
}

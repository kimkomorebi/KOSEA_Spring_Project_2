package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

		@ModelAttribute // login.jsp form에 유저 객체 주입 (객체 생성을 해줌)
		public User setup() {
			return new User();
		}
		
		@RequestMapping(method=RequestMethod.GET) //콜백 메서드 선언
		public String loginform() {
			return "login";
		}
		
		@RequestMapping(method=RequestMethod.POST) //콜백 메서드 선언 form 에서 post 매핑을 받는 메서드
		public ModelAndView loginDo(User user, BindingResult br) {//Errors 객체와 BindingResult 객체는 같은 객체
			//폼 체크하는 객체를 먼저 받아야 한다. 순서 바꾸면 안 됨(매개변수)
			loginValidator.validate(user, br);
			ModelAndView mav = new ModelAndView();
			if(br.hasErrors()) {//입력폼에 문제가 있는 경우
				mav.getModel().putAll(br.getModel());
				return mav;
			}
			try {
				User loginUser = userDao.findUser(user);
				if(loginUser != null) {//로그인 성공
					mav.addObject("loginUser",loginUser);
					mav.setViewName("loginSuccess");//뷰(JSP) 이름
					return mav;
				}else {//로그인 실패
					br.reject("error.login.user");
					mav.getModel().putAll(br.getModel());
					return mav;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
}

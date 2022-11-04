package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginUser;
import model.User;
@Controller
public class LoginFormController {
	
	@Autowired
	private LoginUser loginUser;
	@ModelAttribute
	public User set() {
		return new User();
	}
	@RequestMapping(method=RequestMethod.GET)
	public String loginPage() {
		return "loginForm/login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			User login = loginUser.loginUser(user);
			if(login != null) {
				mav.setViewName("loginForm/loginSuccess");
				mav.addObject("login",login);
				session.setAttribute("USER_KEY", login);
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			
		}
		return null;
	}
}

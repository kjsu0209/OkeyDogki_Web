package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import controller.SurveyController;
import spring.AuthService;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private AuthService authService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController rc = new RegisterController();
		rc.setMemberRegisterService(memberRegSvc);
		return rc;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
}

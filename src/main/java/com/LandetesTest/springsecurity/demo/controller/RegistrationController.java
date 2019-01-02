package com.LandetesTest.springsecurity.demo.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LandetesTest.springsecurity.demo.entity.User;
import com.LandetesTest.springsecurity.demo.service.UserService;
import com.LandetesTest.springsecurity.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

//	The @InitBinder is code that we've used before. It is used in the form validation
//	process. Here we add support to trim empty strings to null.

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

//	The next section of code is the request mapping to show the registration form. We
//	also create a CrmUser and add it as a model attribute.

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {

		theModel.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult, Model theModel) {

		String userName = theCrmUser.getUserName();
		logger.info("Procesando formulario de registro....: " + userName);

		// form validation
		if (theBindingResult.hasErrors()) {
			return "registration-form";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if (existing != null) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "Nombre de usuario ya en uso.");

			logger.warning("Nombre de usuario ya en uso.");
			return "registration-form";
		}
		// create user account
		userService.save(theCrmUser);

		logger.info("usuario creado con exito: " + userName);

		return "registration-confirmation";
	}
}

package com.chaithra.controller;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  

import com.chaithra.model.Agent;
import com.chaithra.model.Carmax;
import com.chaithra.model.ICICIBank;
import com.chaithra.model.NwmSite;
@Controller
public class PfmController{ 
	private String errImage;
	private String errMsg;
	private String nav = "";
	@RequestMapping("/error")  
	public String getErrorCode(@ModelAttribute("agent") Agent ag,ModelMap model){
		String errImage = ag.scrape();
		String errMsg = ag.errorMsg;
		model.addAttribute("errorMessage",errMsg);
		model.addAttribute("errorImage", errImage);
		return "hellopage";
	}  
	@RequestMapping("/error1")  
	public String getCharlesSchwabErrImage(@ModelAttribute("NwmSite") NwmSite cs,ModelMap model){
		 errImage = cs.scrape();
		 errMsg = cs.errorMsg;
		model.addAttribute("errorImage1", errImage);
		return "hellopage";
	}  
	@RequestMapping("/error2")  
	public String accept(@ModelAttribute("NwmSite") NwmSite cs,ModelMap model){
		//Accept
		String errMsg1 = cs.scrape1();
		System.out.println(errMsg1);
		model.addAttribute("error",errMsg1);
		model.addAttribute("errorMessage1","");
		return "hellopage";
	}  
	@RequestMapping("/error3")  
	public String decline(@ModelAttribute("NwmSite") NwmSite cs,ModelMap model){
		//Decline
		cs.scrape2();
		System.out.println(errMsg);
		model.addAttribute("error","");
		model.addAttribute("errorMessage1","  Successfully Refreshed...");
		model.addAttribute("navigation",nav);
		return "hellopage";
	} 
	@RequestMapping("/error4")  
	public String decline(@ModelAttribute("Carmax") Carmax obj,ModelMap model){
		String errImage = obj.scrape();
		String errMsg = obj.errorMsg;
		model.addAttribute("errorMessage2",errMsg);
		model.addAttribute("errorImage2", errImage);
		return "hellopage";
	} 
	@RequestMapping("/error5")  
	public String decline(@ModelAttribute("ICICIBank") ICICIBank obj,ModelMap model){
		String errImage = obj.scrape();
		String errMsg = obj.errorMsg;
		model.addAttribute("errorMessage3",errMsg);
		model.addAttribute("errorImage3", errImage);
		model.addAttribute("navigation", obj.navigation);
		return "hellopage";
	} 
}  
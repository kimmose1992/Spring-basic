package com.sample.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.main.vo.SampleVO;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called.....");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called.....");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called.....");
		return "result";
	}
	
	@RequestMapping("doD")
	public String doD(Model model) {
		logger.info("doD called.....");
		SampleVO sample = new SampleVO("ms", "mosekim");
		model.addAttribute(sample);
		return "sample";
	}
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called.....");
		rttr.addFlashAttribute("msg", "I AM doE");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF called..... " + msg);
	}
	
	@RequestMapping("doJSON")
	@ResponseBody
	public SampleVO doJSON() {
		SampleVO sample = new SampleVO("id", "name");
		return sample;
	}
}

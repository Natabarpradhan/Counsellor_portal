package Natabarit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Natabarit.dto.Dashboard;
import Natabarit.entity.Counsellor;
import Natabarit.service.CounsellorService;
import Natabarit.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;
	
	@Autowired
	private EnquiryService enquiryService;
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);//get Session
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerView";
	}
	@PostMapping("/register")
	public String handleRegister(Counsellor c,Model model) {
		boolean status = counsellorService.saveCounsellor(c);
		if(status) {
			model.addAttribute("smsg", "Counsellor Saved");
		}else {
			model.addAttribute("emsg", "Failed to Save");
		}
		return "registerView";
	}
	/*
	 * Start from here
	 */
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "index";
	}
	@PostMapping("/login")
	public String handleLogin(Counsellor counsellor,HttpServletRequest req, Model model) {
		Counsellor c = counsellorService.getCounsellor(counsellor.getEmail(), counsellor.getPwd());
		if(c==null) {
			model.addAttribute("msg", "Invalid Credentials");
			return "index";
		}else {
			
			/*
			 * set counsellor-id in session
			 * true meaning new session is created
			 */
			HttpSession session = req.getSession(true);//always every user new session is created
			session.setAttribute(  "cid", c.getCounsellerId());//cid set counsellor id to know who logged
			Dashboard dbinfo = enquiryService.getDashboardInfo(c.getCounsellerId());
			model.addAttribute("dashboard", dbinfo);
			
			
			return"dashboard";
		}
		
	}
}
  
package Natabarit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Natabarit.entity.Enquiry;
import Natabarit.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	
	//private static final String Integer = null;
	@Autowired
	private EnquiryService enquiryService;
/*
 * add enq -page display
 */
	@GetMapping("/enquiry")
	public String addEnquiry(  Model model) {
		model.addAttribute("enq", new  Enquiry());
		return "addEnq";
	}
	/*
	 * save Enq
	 */
	@PostMapping("/enquiry")
	public String saveEnquiry(Enquiry enq,HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		
		Integer cid = (Integer)session.getAttribute("cid");
		
		
		boolean status = enquiryService.addEnquiry(enq, cid);
		if(status) {
			model.addAttribute("smsg","Enquiry saved");
		}else {
			model.addAttribute("emsg", "Enquiry Not saved");
		}
		return "addEnq";
	}
	/*
	 * view enquiry 
	 */
	@GetMapping("/enquiries")
	public String getEnquries(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession(false);//exiting code
	     Integer cid = (Integer)session.getAttribute("cid");
	     List<Enquiry> list = enquiryService.getEnquires(new Enquiry(), cid);
	     model.addAttribute("enqs", list);
	     model.addAttribute("enq",new Enquiry());
		return "viewEnquiries";
	}
	/*
	 * filter enquiry
	 */
	@PostMapping("/filter-enqs")
	public String filterEnqs(Enquiry enq,HttpServletRequest req,Model model) {
		   HttpSession session = req.getSession(false);
		   Integer cid = (Integer)session.getAttribute("cid");
		   List<Enquiry> list = enquiryService.getEnquires(enq,cid);
		   model.addAttribute("enqs", list);
		   return "viewEnquiries";
	}
	/*
	 * edit & update enq
	 */
	@GetMapping("/edit")
	public String editEnquiry(@RequestParam ("enqId")Integer enqId,Model model) {
		Enquiry enquiry = enquiryService.getEnquiry(enqId);
		model.addAttribute("enq", enquiry);
		return "addEnq";
	}
}

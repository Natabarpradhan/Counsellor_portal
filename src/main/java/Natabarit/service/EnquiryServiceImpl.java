package Natabarit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import Natabarit.dto.Dashboard;
import Natabarit.entity.Counsellor;
import Natabarit.entity.Enquiry;
import Natabarit.repo.CounsellorRepository;
import Natabarit.repo.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;
	
	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public Dashboard getDashboardInfo(Integer counsellorId) {
		Long totalEnq = enquiryRepository.getEnquries(counsellorId);
		Long openCnt = enquiryRepository.getEnquries(counsellorId, "Open");
		Long lostCnt = enquiryRepository.getEnquries(counsellorId, "Lost");
		Long enrolledCnt = enquiryRepository.getEnquries(counsellorId, "Enrolled");

		Dashboard d = new Dashboard();
		d.setTotalEnqs(totalEnq);
		d.setEnrolledEnqs(enrolledCnt);
		d.setLostEnqs(lostCnt);
		d.setOpenEnqs(openCnt);

		return d;  
	}


	@Override
	public boolean addEnquiry(Enquiry enquiry,Integer counsellorId) {
		Counsellor counsellor = counsellorRepository.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);//association for foreign key
		Enquiry saveEnq = enquiryRepository.save(enquiry);
		
		return saveEnq.getEnqId()!=null; 
	}

	@Override 
	public List<Enquiry> getEnquires(Enquiry enquiry, Integer counsellorId) {
		Counsellor counsellor = counsellorRepository.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);
		Example<Enquiry> of = Example.of(enquiry);//dynamic query created
		 
		return enquiryRepository.findAll(of);
	}
//edit the enquary
	@Override
	public Enquiry getEnquiry(Integer enqId) {
	
		return enquiryRepository.findById(enqId).orElseThrow() ;
	}

}

package Natabarit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Natabarit.entity.Counsellor;
import Natabarit.repo.CounsellorRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepository CounsellorRepository;
	@Override
	public boolean saveCounsellor(Counsellor counsellor) {
		Counsellor findByEmail = CounsellorRepository.findByEmail(counsellor.getEmail());
		if(findByEmail!=null) {
			return false;
		}else {
			Counsellor savedCounsellor = CounsellorRepository.save(counsellor);
			return savedCounsellor.getCounsellerId()!=null;
		}
		
		
	}
    
	@Override    
	public Counsellor getCounsellor(String email, String pwd) {
//		CounsellorRepository.findByEmailAndPwd(email, pwd);
		return CounsellorRepository.findByEmailAndPwd(email, pwd);
	}

}

package Natabarit.service;

import Natabarit.entity.Counsellor;

public interface CounsellorService {
/*
 * Registration to Counsellor
 */
	public boolean saveCounsellor(Counsellor counsellor);
	/*
	 * Login
	 */
	public Counsellor getCounsellor(String email,String pwd);
}

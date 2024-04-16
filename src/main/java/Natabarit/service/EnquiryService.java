package Natabarit.service;

import java.util.List;

import Natabarit.dto.Dashboard;
import Natabarit.entity.Enquiry;

public interface EnquiryService {
	/*
	 * for dash-board page
	 */
public Dashboard getDashboardInfo(Integer counsellorId);
/*
 * save Enquiry
 */
public boolean addEnquiry(Enquiry enquiry,Integer counsellorId);
/*
 * view enquires + filter
 */

public List<Enquiry>getEnquires(Enquiry enquiry,Integer counsellorId);
/*
 * edit
 */
public Enquiry getEnquiry(Integer enqId) ;
}

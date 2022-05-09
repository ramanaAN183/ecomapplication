/**
 * 
 */
package com.ecom.service;

import java.io.File;

import com.ecom.model.SendTextMailVm;



/**
 * @author Rama Subbarao
 *
 */
public interface MailSenderService {
	public void sendSimpleMail(SendTextMailVm mail);
//	
//	public SendTextMailVm prepareMailObject(String data,String toMaolId);
	public void sendMailWithAttachment(File file);
//	public void sendMailWithAttachment();
public void sendSimplemultipleMails(SendTextMailVm mail);
	 public SendTextMailVm prepareMailObject(String message,String subject,String toMailId);
}

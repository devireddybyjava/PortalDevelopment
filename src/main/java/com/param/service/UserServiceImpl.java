package com.param.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.param.binding.LoginForm;
import com.param.binding.SignUpForm;
import com.param.binding.UnlockForm;
import com.param.entity.UserDtlsEntity;
import com.param.repo.UserDtlsRepo;
import com.param.utils.EmailUtils;
import com.param.utils.PwdUtils;

@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserDtlsRepo userRepo;

@Autowired
private EmailUtils emailutils;
	@Override
	public boolean signUpPage(SignUpForm signup) {
		
		UserDtlsEntity user=userRepo.findByEmail(signup.getEmail());
		if(user!=null) {
			return false;
		}
		
		//TODO:Copy data from binding obj to entity obj
		
		UserDtlsEntity entity=new UserDtlsEntity();
		BeanUtils.copyProperties(signup, entity);
		
		
		// TODO: generate random password and set to the object
		String tempPwd=PwdUtils.generateRandomPwd();
		
		
		//TODO: Set account status as LOCKED
		entity.setAcc_status("Locked");
		
		//TODO: Insert record
            userRepo.save(entity);
            String to=signup.getEmail();
            String subject="Unlock Your Account";
            StringBuffer body=new StringBuffer("");
            body.append("<h1>Use below temporary password to unlock your account</h1>");
            body.append("Temporary pwd: "+ tempPwd);
            body.append("<br/>");
            body.append("<a href=\"http://localhost:8080/unlock?email="+to+"\">Click Here to Unclock Your Account</a>");
          emailutils.sendEmail(to, subject, body.toString());
		return true;
	}

	@Override
	public String loginPage(LoginForm login) {
		// TODO Auto-generated method stub
		
		UserDtlsEntity entity=userRepo.findByEmailAndPwd(login.getEmail(), login.getPassword());
		if(entity==null) {
			return "Invalid Credentials";
		}
		if(entity.getAcc_status()==("LOCKED"))
		{
			return "Your Account is Locked";
		}
		return "Successfully logged into the Account";
	}

	@Override
	public boolean unlockPage(UnlockForm unlock) {
		// TODO Auto-generated method stub
		 UserDtlsEntity entity=userRepo.findByEmail(unlock.getEmail());
		 if(entity.getPwd()==unlock.getTempPwd()) {
			 entity.setPwd(unlock.getNewPwd());
			 entity.setAcc_status("UNLOCKED");
			 userRepo.save(entity);
			 return true;
		 }else {
			 return false;
		 }
	}

	@Override
	public String forgotPage(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

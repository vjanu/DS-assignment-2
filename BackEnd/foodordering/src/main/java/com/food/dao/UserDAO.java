package com.food.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.food.bean.FoodBean;
import com.food.bean.UserBean;
import com.food.security.AESEncryption;
import com.food.services.UserService;


public class UserDAO implements UserService{
	String details;
	String data[];
	String username;
	String password;
	
	@Override
	public List populateUserDetails() {
		List<UserBean> userList = new ArrayList<>();
		  try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
	        		(UserDAO.class.getResourceAsStream("userdata.txt")))) {

	            // traverse through each line available in the text file
	        	
	            while ((details = bufferedReader.readLine()) != null) {
	            	UserBean userBean = new UserBean();
	            	data = details.split("-");
	            
	            	username = AESEncryption.encrypt(data[0]);
	            	password = AESEncryption.encrypt(data[1]);
	            	
	            	userBean.setUserName(username);
	            	userBean.setPassword(password);
	            	userList.add(userBean);

	            }
	        } catch (IOException e) {
	            System.err.println("Login cannot be done "+e.getMessage());
	        } catch (Exception e) {
	        	System.err.println("Error occured in Login Encryption "+e.getMessage());
			}

		return userList;
}

}


package com.icss.service;

import java.util.List;

import com.icss.po.UserRolesPO;
import com.icss.po.UsersPO;
import com.icss.vo.PageVO;
import com.icss.vo.UserSessionVO;
import com.icss.vo.UsersViewVO;

/**
 * 
 * @author Administrator
 *
 */
public interface UsersService {
	/**
	 * 
	 * @param userPO
	 * @throws Exception
	 */
	void reg(UsersPO userPO)throws Exception;
	
	
	/**
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 * @throws Exception
	 */
	UserSessionVO login(String userName,String userPwd)throws Exception;
	
	PageVO<UsersViewVO> pageUser(int page,int rowMax) throws Exception;
	
	UsersPO get(int userId)throws Exception;
	
	List<UserRolesPO> listRoles()throws Exception;
	
	void modify(UsersPO userPO)throws Exception;
}

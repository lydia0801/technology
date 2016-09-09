package com.icss.service;

import java.util.Date;
import java.util.List;

import com.icss.dao.FileLevelDAO;
import com.icss.dao.UserRolesDAO;
import com.icss.dao.UsersDAO;
import com.icss.po.FileLevelPO;
import com.icss.po.UserRolesPO;
import com.icss.po.UsersPO;
import com.icss.vo.PageVO;
import com.icss.vo.UserSessionVO;
import com.icss.vo.UsersViewVO;

public class UsersServiceImp implements UsersService {
	
	private UsersDAO dao = new UsersDAO();
	private UserRolesDAO userRolesDAO = new UserRolesDAO();
	
	private FileLevelDAO fileLevelDAO = new FileLevelDAO();

	public void reg(UsersPO userPO) throws Exception {
		try{
			userPO.setFileLevelId(1);
			userPO.setUserRolesId(0);
			userPO.setUserState(true);
			userPO.setUserTime(new Date());
			dao.add(userPO);
		}catch (Exception e) {
			throw new Exception("用户名重复", e);
		}
	}

	public UserSessionVO login(String userName, String userPwd)
			throws Exception {
		UsersPO po = dao.findByUserName(userName);
		if(!po.getUserPwd().equals(userPwd)){
			throw new Exception("用户密码不匹配");
		}
		if(!po.getUserState()){
			throw new Exception("用户禁止访问");
		}
		UserSessionVO vo = new UserSessionVO();
		vo.setFileLevelId(po.getFileLevelId());
		vo.setLoginTime(new Date());
		vo.setUserId(po.getUserId());
		vo.setUserName(po.getUserName());
		vo.setUserRealName(po.getUserRealName());
		vo.setUserRolesId(po.getUserRolesId());
		vo.setUserRolesName("");
		
		FileLevelPO fileLevelPO = new FileLevelPO(po.getFileLevelId());
		fileLevelPO = fileLevelDAO.findById(fileLevelPO);
		vo.setFileLevelName(fileLevelPO.getFileLevelName());
		
		//vo.setFileLevelName(fileLevelDAO.findById(new FileLevelPO(po.getFileLevelId())).getFileLevelName());
		return vo;
	}

	public PageVO<UsersViewVO> pageUser(int page, int rowMax) throws Exception {
		return dao.pageUser(page, rowMax);
	}

	public List<UserRolesPO> listRoles() throws Exception {
		return userRolesDAO.findAll();
	}

	public void modify(UsersPO userPO) throws Exception {
		dao.modify(userPO);
	}

	public UsersPO get(int userId) throws Exception {
		return dao.findById(new UsersPO(userId));
	}

}

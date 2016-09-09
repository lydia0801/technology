package com.icss.dao;

import java.util.List;

import com.icss.po.UsersPO;
import com.icss.vo.PageVO;
import com.icss.vo.UsersViewVO;

public class UsersDAO extends DAOSupport<UsersPO> {

	@Override
	public void add(UsersPO... po) throws Exception {
		for(UsersPO p : po){
			db.execute(
				"insert into users(user_roles_id,file_level_id,user_name,user_pwd,user_real_name,user_state,user_time) values(?,?,?,?,?,?,?)",
				p.getUserRolesId(),
				p.getFileLevelId(),
				p.getUserName(),
				p.getUserPwd(),
				p.getUserRealName(),
				p.getUserState(),
				p.getUserTime()
			);
		}
		

	}

	@Override
	public void delete(UsersPO... po) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsersPO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersPO findById(UsersPO po) throws Exception {
		return db.get("select * from users where user_id=?", new UsersPO(), po.getUserId());
	}

	@Override
	public void modify(UsersPO... po) throws Exception {
		for(UsersPO p : po){
			db.execute(
				"update users set user_roles_id=?,file_level_id=?,user_name=?,user_pwd=?,user_real_name=?,user_state=?,user_time=? where user_id=?",
				p.getUserRolesId(),
				p.getFileLevelId(),
				p.getUserName(),
				p.getUserPwd(),
				p.getUserRealName(),
				p.getUserState(),
				p.getUserTime(),
				p.getUserId()
			);
		}
	}
	
	public UsersPO findByUserName(String userName)throws Exception {
		try{
			return db.get("select * from users where user_name=?", new UsersPO(), userName);
		}catch (Exception e) {
			throw new Exception("没有找到对应的帐号", e);
		}
	}
	
	public PageVO<UsersViewVO> pageUser(int page,int rowMax) throws Exception {
		return page("select * from users_view ORDER BY user_time DESC", page, rowMax, new UsersViewVO());
	}

}

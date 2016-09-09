package test.dao;

import org.apache.struts2.json.JSONUtil;
import org.junit.Test;

import com.icss.dao.UsersDAO;

public class UserDAOTest {

	private UsersDAO dao = new UsersDAO();
	
	@Test
	public void findByUserName()throws Exception{
		System.out.println(dao.findByUserName("admin1"));
	}
	
	@Test
	public void pageUser()throws Exception{
		System.out.println(JSONUtil.serialize(dao.pageUser(1, 5)));
		
	}
}

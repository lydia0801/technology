package test.dao;

import java.util.List;

import org.apache.struts2.json.JSONUtil;
import org.junit.Test;

import com.icss.dao.FileLevelDAO;
import com.icss.po.FileLevelPO;

public class FileLevelDAOTest {
	
	private FileLevelDAO dao = new FileLevelDAO();
	
	@Test
	public void add0()throws Exception{
		dao.add();
	}
	
	@Test
	public void add1()throws Exception{
		FileLevelPO po = new FileLevelPO(-2, "as佛挡杀佛");
		dao.add(po);
	}
	

	
	@Test
	public void add2()throws Exception{
		FileLevelPO po1 = new FileLevelPO(-3,null);
		FileLevelPO po2 = new FileLevelPO(-4, "阿萨德发生的防守打法上");
		dao.add(po1,po2);
	}
	
	@Test
	public void findAll()throws Exception{
		List<FileLevelPO> list = dao.findAll();
		String listJson = JSONUtil.serialize(list);
		System.out.println(listJson);
	}
	
	

}

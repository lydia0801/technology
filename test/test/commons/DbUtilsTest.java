package test.commons;

import java.util.List;

import org.junit.Test;

import com.icss.commons.DbUtils;
import com.icss.po.FileLevelPO;
import com.icss.po.FileLevelRowMapper;

public class DbUtilsTest {

	private DbUtils db = DbUtils.newInstance();
	
	@Test
	public void testExecute1()throws Exception{
		db.execute("delete from file_level where file_level_id=?", 0);
		//db.execute("delete from file_level where file_level_id=?", new Object[]{0});
	}
	
	@Test
	public void testGet1()throws Exception {
		FileLevelPO po = db.get("select * from file_level where file_level_id=?", new FileLevelPO(), 1);
		System.out.println(po);
	}
	
	@Test
	public void testGet2()throws Exception {
		FileLevelPO po = db.get("select * from file_level", new FileLevelPO());
		System.out.println(po);
	} 
	
	@Test
	public void testList()throws Exception {
		List<FileLevelPO> po = db.list("select * from file_level", new FileLevelPO());
		System.out.println(po);
	}
}

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysUser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leesin Dong
 * @since 2021/12/29
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @org.junit.Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = new SysUser();
        sysUser.setUserName("ad");
        List<SysUser> sysUsers = mapper.selectByUser(sysUser);
        sysUsers.forEach(System.out::println);

        sysUser.setUserEmail("test@mybatis.tk");
        List<SysUser> sysUsers1 = mapper.selectByUser(sysUser);
        sysUsers1.forEach(System.out::println);

        List<SysUser> sysUsers2 = mapper.selectByUser(new SysUser());
        sysUsers2.forEach(System.out::println);
    }

    @org.junit.Test
    public void testUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = new SysUser();
        sysUser.setUserName("aaa");
        sysUser.setUserPassword("a'a'a");
        sysUser.setId(1L);
        int i = mapper.updateByIdSelective(sysUser);

        SysUser sysUser1 = new SysUser();
        sysUser1.setId(1L);
        mapper.selectByUser(sysUser1);
        sqlSession.commit();

    }

    @org.junit.Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("xuexi");
        mapper.insert(sysUser);
        sqlSession.commit();
    }

    @org.junit.Test
    public void testSelectForEache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = new SysUser();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        List<SysUser> sysUsers = mapper.selectByIdList(list);
        sysUsers.forEach(System.out::println);
    }

    @org.junit.Test
    public void testInsertList() {
         SqlSession SQL_SESSION = sqlSessionFactory.openSession();
        UserMapper mapper = SQL_SESSION.getMapper(UserMapper.class);
        List<SysUser> list = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setUserName("name");
        list.add(sysUser);
        mapper.insertList(list);

        SQL_SESSION.commit();
    }

    @org.junit.Test
    public void testUpdateByMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1L);
        map.put("user_name", "kkk");
        mapper.updateByMap(map);
        sqlSession.commit();
    }
}

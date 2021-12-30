import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysUser;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
            // reader.close();
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

        sysUser.setUserEmail("test@mybatis.tk");
        List<SysUser> sysUsers1 = mapper.selectByUser(sysUser);



    }
}

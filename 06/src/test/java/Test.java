import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import tk.mybatis.simple.Enabled;
import tk.mybatis.simple.mapper.RoleMapper;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysRoleType;
import tk.mybatis.simple.model.SysUser;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Leesin Dong
 * @since 2021/12/31
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

         SysUser sysUser = mapper.selectUserAndRoleByIdSelect(1L);
        System.out.println(sysUser.toString());
        System.out.println(sysUser.getRoleList().toString());
        System.out.println(sysUser.getRoleList().get(0).getPrivilegeList());
        // SysUser sysUser1 = new SysUser();
        // sysUser1.setId(1L);
        // mapper.selectByUser(sysUser1);
    }

    @org.junit.Test
    public void testUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        SysRoleType sysRoleType = new SysRoleType();
        sysRoleType.setEnabled(Enabled.disabled);
        mapper.update(sysRoleType);
    }
}

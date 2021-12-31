package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 标题：用户表 Mapper<br>
 * 描述：用户表 Mapper<br>
 * 时间：2018/06/14<br>
 *
 * @author zc
 **/
public interface UserMapper {
    /**
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUser(SysUser sysUser);

    int updateByIdSelective(SysUser sysUser);

    int insert(SysUser sysUser);

    List<SysUser> selectByIdList(@Param("ids") List<Long> ids);

    int insertList(@Param("list")List<SysUser> sysUser);

    int updateByMap(Map<String, Object> map);

    SysUser selectUserAndRoleByIdSelect(Long id);
}

package tk.mybatis.simple.mapper;


import tk.mybatis.simple.model.SysUser;

import java.util.List;

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
}

package tk.mybatis.simple.model.mapper;

import tk.mybatis.simple.model.model.SysUser;

/**
 * 标题：用户表 Mapper<br>
 * 描述：用户表 Mapper<br>
 * 时间：2018/05/30<br>
 *
 * @author zc
 **/
public interface UserMapper {

    /**
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);
}

package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysRoleType;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public interface RoleMapper {
    SysRole selectRoleById(Long id);

    int update(SysRoleType sysRoleType);
}

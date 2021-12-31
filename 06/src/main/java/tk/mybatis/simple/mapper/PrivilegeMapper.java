package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysPrivilege;

import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public interface PrivilegeMapper {
    List<SysPrivilege> selectPrivilege(Long roleId);
}

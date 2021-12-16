package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}

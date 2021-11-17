package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.services.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Override
    public RoleVo getById(Long id) {
        return null;
    }

    @Override
    public List<RoleVo> getAllRoles() {
        return null;
    }

    @Override
    public void save(RoleVo role) {

    }

    @Override
    public void update(Long id, RoleVo role) {

    }

    @Override
    public void delete(Long id) {

    }
}

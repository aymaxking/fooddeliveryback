package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.services.ISubMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class SubMenuServiceImp implements ISubMenuService {
    @Override
    public SubMenuVo getById(Long id) {
        return null;
    }

    @Override
    public List<SubMenuVo> getAllSubMenu() {
        return null;
    }

    @Override
    public void save(SubMenuVo subMenu) {

    }

    @Override
    public void update(Long id, SubMenuVo subMenu) {

    }

    @Override
    public void delete(Long id) {

    }
}

package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.services.IMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements IMenuService {
    @Override
    public MenuVo getById(Long id) {
        return null;
    }

    @Override
    public List<MenuVo> getAllMenus() {
        return null;
    }

    @Override
    public void save(MenuVo menu) {

    }

    @Override
    public void update(Long id, MenuVo menu) {

    }

    @Override
    public void delete(Long id) {

    }
}

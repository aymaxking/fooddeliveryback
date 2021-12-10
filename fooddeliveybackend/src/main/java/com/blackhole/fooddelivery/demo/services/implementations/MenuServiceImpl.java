package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.MenuRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.MenuConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.model.Menu;
import com.blackhole.fooddelivery.demo.services.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuRepository menuRepository;


    @Override
    public MenuVo getById(Long id) {
        boolean trouve = menuRepository.existsById(id);
        if (!trouve)
            return null;
        return MenuConverter.toVo(menuRepository.getOne(id));
    }

    @Override
    public List<MenuVo> getAll() {
        List<Menu> list = menuRepository.findAll();
        return MenuConverter.toVoList(list);    }

    @Override
    public void save(MenuVo menu) {
        menuRepository.save(MenuConverter.toBo(menu));
    }

    @Override
    public void update(Long id, MenuVo menu) {
        menu.setId(id);
        menuRepository.save(MenuConverter.toBo(menu));
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}

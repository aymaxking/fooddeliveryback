package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.SubMenuRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.SubMenuConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.model.SubMenu;
import com.blackhole.fooddelivery.demo.services.ISubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subMenuService")
@Transactional
public class SubMenuServiceImp implements ISubMenuService {
    @Autowired
    private SubMenuRepository subMenuRepository;

    @Override
    public SubMenuVo getById(Long id) {
        boolean trouve = subMenuRepository.existsById(id);
        if (!trouve)
            return null;
        return SubMenuConverter.toVo(subMenuRepository.getOne(id));
    }

    @Override
    public List<SubMenuVo> getAll() {
        List<SubMenu> list = subMenuRepository.findAll();
        return SubMenuConverter.toVoList(list);
    }

    @Override
    public void save(SubMenuVo subMenu) {
        subMenuRepository.save(SubMenuConverter.toBo(subMenu));
    }

    @Override
    public void update(Long id, SubMenuVo subMenu) {
        subMenu.setId(id);
        subMenuRepository.save(SubMenuConverter.toBo(subMenu));
    }

    @Override
    public void delete(Long id) {
        subMenuRepository.deleteById(id);
    }
}

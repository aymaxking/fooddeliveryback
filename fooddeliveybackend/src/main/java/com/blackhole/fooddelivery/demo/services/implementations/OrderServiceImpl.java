package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.ClientRepository;
import com.blackhole.fooddelivery.demo.dao.OrderRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CategoryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.OrderConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.OrderVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Order;
import com.blackhole.fooddelivery.demo.model.Testclass;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IClientService;
import com.blackhole.fooddelivery.demo.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IClientService clientService;


    @Override
    public OrderVo getById(Long id) {
        boolean trouve = orderRepository.existsById(id);
        if (!trouve)
            return null;
        return OrderConverter.toVo(orderRepository.getById(id));
    }



    @Override
    public List<OrderVo> getAll() {
        List<Order> list = orderRepository.findAll();
        return OrderConverter.toVoList(list);
    }

    @Override
    public List<OrderVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Order> list = orderRepository.findAll(pr).getContent();
        return OrderConverter.toVoList(list);
    }



    @Override
    public void save(OrderVo order) {
        order.setClient(clientService.getById(order.getIdclient()));
        orderRepository.save(OrderConverter.toBo(order));
    }

    @Override
    public void update(Long id, OrderVo order) {
        order.setId(id);
        orderRepository.save(OrderConverter.toBo(order));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

}

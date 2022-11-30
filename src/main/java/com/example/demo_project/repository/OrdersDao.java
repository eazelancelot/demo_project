package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Orders;
import com.example.demo_project.vo.OrdersInfo;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer>{
	
	@Query("select new com.example.demo_project.vo.OrdersInfo(c.name, o.productName, o.quantity, o.customerId) "
			+ "from Customers c join Orders o"
			+ " on o.customerId = c.id")
	public List<OrdersInfo> findAllOrdersInfo();
	
//	@Query("select c.name, o.productName, o.quantity, o.customerId "
//			+ "from Customers c join Orders o"
//			+ " on o.customerId = c.id")
//	public List<Object> findAllOrdersInfo();
	
//	public List<OrdersInfo> findOrdersInfoByCustomersIdIn();

}

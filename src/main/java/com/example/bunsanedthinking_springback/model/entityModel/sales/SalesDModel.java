package com.example.bunsanedthinking_springback.model.entityModel.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bunsanedthinking_springback.entity.employee.Employee;
import com.example.bunsanedthinking_springback.entity.employee.Sales;
import com.example.bunsanedthinking_springback.model.entityModel.employee.EmployeeEntityModel;
import com.example.bunsanedthinking_springback.repository.SalesMapper;
import com.example.bunsanedthinking_springback.vo.SalesVO;

@Service
public class SalesDModel {
	@Autowired
	private EmployeeEntityModel employeeEntityModel;
	@Autowired
	private SalesMapper salesMapper;

	public Sales getById(int id) {
		SalesVO salesVO = salesMapper.get_SalesModel(id); // Optional 수정 필요
		if (salesVO == null)
			return null;
		Employee employee = employeeEntityModel.getById(id);
		return salesVO.getEntity(employee);
	}

	public List<Sales> getAll() {
		List<Sales> sales = new ArrayList<Sales>();
		salesMapper.getAll_SalesModel().forEach(e -> sales.add(getById(e.getEmployee_id())));
		// getAll_SalesModel - List 수정 필요
		return sales;
	}

	public Integer getMaxId() {
		return salesMapper.getMaxId();
	}

	// 아래들 Optional 아니라서 그냥 등가비교
	public void add(Sales sales) {
		if (sales == null)
			return;
		if (salesMapper.get_SalesModel(sales.getId()) != null)
			return;
		employeeEntityModel.add(sales);
		salesMapper.insert(sales.findVO());
	}

	public void update(Sales sales) {
		if (sales == null)
			return;
		if (salesMapper.get_SalesModel(sales.getId()) == null)
			return;
		salesMapper.update_SalesModel(sales.findVO());
		employeeEntityModel.update(sales);
	}

	public void delete(int id) {
		if (salesMapper.get_SalesModel(id) == null)
			return;
		salesMapper.deleteById(id);
		employeeEntityModel.delete(id);
	}
}

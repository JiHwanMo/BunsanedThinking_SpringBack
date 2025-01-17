package com.example.bunsanedthinking_springback.repository;

import com.example.bunsanedthinking_springback.vo.InsuranceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface InsuranceMapper {
	public Optional<InsuranceVO> getById(int id);
	public List<InsuranceVO> getAll();
	public Integer getMaxId();
	public void insert(InsuranceVO insuranceVO);
	public void update(InsuranceVO insuranceVO);
	public void deleteById(int id);
}

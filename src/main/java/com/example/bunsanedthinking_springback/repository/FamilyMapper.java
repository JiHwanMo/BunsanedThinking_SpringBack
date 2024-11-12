package com.example.bunsanedthinking_springback.repository;

import com.example.bunsanedthinking_springback.vo.FamilyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FamilyMapper {
	public Integer getMaxId();
	public void insert(FamilyVO familyVO);
	public Optional<FamilyVO> getById(int id);
	public List<FamilyVO> getAll();
	public void update(FamilyVO familyVO);
	public void delete(int id);
}

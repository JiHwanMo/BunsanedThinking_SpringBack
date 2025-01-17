package com.example.bunsanedthinking_springback.repository;

import com.example.bunsanedthinking_springback.vo.RevivalVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RevivalMapper {
	public Optional<RevivalVO> getById(int id);
	public List<RevivalVO> getAll();
	public Integer getMaxId();
	public void insert(RevivalVO revivalVO);
	public void update(RevivalVO revivalVO);
	public void deleteById(int id);
}

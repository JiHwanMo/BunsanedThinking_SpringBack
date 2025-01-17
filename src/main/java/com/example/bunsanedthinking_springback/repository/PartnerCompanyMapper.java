package com.example.bunsanedthinking_springback.repository;

import com.example.bunsanedthinking_springback.vo.PartnerCompanyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PartnerCompanyMapper {
	public Optional<PartnerCompanyVO> getById(int id);
	public List<PartnerCompanyVO> getAll();
	public Integer getMaxId();
	public void insert(PartnerCompanyVO partnerCompanyVO);
	public void update(PartnerCompanyVO partnerCompanyVO);
	public void deleteById(int id);
}

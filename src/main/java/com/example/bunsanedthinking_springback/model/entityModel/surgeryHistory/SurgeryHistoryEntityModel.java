package com.example.bunsanedthinking_springback.model.entityModel.surgeryHistory;

import com.example.bunsanedthinking_springback.entity.surgeryHistory.SurgeryHistory;
import com.example.bunsanedthinking_springback.global.common.ReadOnly;
import com.example.bunsanedthinking_springback.repository.SurgeryHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurgeryHistoryEntityModel {
	@Autowired
	private SurgeryHistoryMapper surgeryHistoryMapper;
	@ReadOnly
	public SurgeryHistory getById(int id) {
		return surgeryHistoryMapper.getById(id)
			.map(SurgeryHistory::new)
			.orElse(null);
	}
	@ReadOnly
	public List<SurgeryHistory> getAll() {
		List<SurgeryHistory> surgeryHistories = new ArrayList<SurgeryHistory>();
		surgeryHistoryMapper.getAll()
			.forEach(e -> surgeryHistories.add(getById(e.getId())));
		return surgeryHistories;
	}
	@ReadOnly
	public Integer getMaxId() {
		return surgeryHistoryMapper.getMaxId();
	}

	public void add(SurgeryHistory surgeryHistory) {
		surgeryHistoryMapper.insert(surgeryHistory.findVO());
	}

	public void update(SurgeryHistory surgeryHistory) {
		surgeryHistoryMapper.update(surgeryHistory.findVO());
	}

	public void delete(int id) {
		if (getById(id) == null) return;
		surgeryHistoryMapper.deleteById(id);
	}

}

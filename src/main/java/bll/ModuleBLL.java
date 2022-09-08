package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dal.ModuleDAO;

@Service
public class ModuleBLL {
	@Autowired
	private ModuleDAO dao;
	
	public List<bo.Module> findAll() {
		return dao.findAll();
	}
	
	public bo.Module findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(bo.Module module) {
		dao.save(module);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean contains(int id) {
		return dao.existsById(id);
	}
}

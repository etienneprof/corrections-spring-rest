package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Personne;
import dal.PersonneDAO;

@Service
public class PersonneBLL {
	@Autowired
	private PersonneDAO dao;
	
	public List<Personne> findAll() {
		return dao.findAll();
	}
	
	public Personne findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Personne module) {
		dao.save(module);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean contains(int id) {
		return dao.existsById(id);
	}
}

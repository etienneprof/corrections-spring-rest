package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Etudiant;
import dal.EtudiantDAO;

@Service
public class EtudiantBLL {
	@Autowired
	private EtudiantDAO dao;
	
	public List<Etudiant> findAll() {
		return dao.findAll();
	}
}

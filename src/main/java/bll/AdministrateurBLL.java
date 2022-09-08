package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Administrateur;
import dal.AdministrateurDAO;

@Service
public class AdministrateurBLL {
	@Autowired
	private AdministrateurDAO dao;
	
	public List<Administrateur> findAll() {
		return dao.findAll();
	}
}

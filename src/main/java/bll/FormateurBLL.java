package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Formateur;
import dal.FormateurDAO;

@Service
public class FormateurBLL {
	@Autowired
	private FormateurDAO dao;
	
	public List<Formateur> findAll() {
		return dao.findAll();
	}
}

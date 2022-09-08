package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bll.AdministrateurBLL;
import bll.EtudiantBLL;
import bll.FormateurBLL;
import bll.PersonneBLL;
import bo.Administrateur;
import bo.Etudiant;
import bo.Formateur;
import bo.Personne;

@RestController
@RequestMapping(path = "/personnes")
public class PersonneController {
	@Autowired
	private PersonneBLL bll;
	@Autowired
	private AdministrateurBLL aBll;
	@Autowired
	private EtudiantBLL eBll;
	@Autowired
	private FormateurBLL fBll;
	
	@GetMapping
	public ResponseEntity<List<Personne>> selectAll() {
		return new ResponseEntity<List<Personne>>(bll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/admins")
	public ResponseEntity<List<Administrateur>> selectAllAdmin() {
		return new ResponseEntity<List<Administrateur>>(aBll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/etudiants")
	public ResponseEntity<List<Etudiant>> selectAllEtudiants() {
		return new ResponseEntity<List<Etudiant>>(eBll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/formateurs")
	public ResponseEntity<List<Formateur>> selectAllFormateurs() {
		return new ResponseEntity<List<Formateur>>(fBll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Personne> selectById(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			return new ResponseEntity<Personne>(bll.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "/admins")
	public ResponseEntity<Administrateur> insert(@RequestBody Administrateur a) {
		bll.save(a);
		return new ResponseEntity<Administrateur>(a, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/etudiants")
	public ResponseEntity<Etudiant> insert(@RequestBody Etudiant e) {
		bll.save(e);
		return new ResponseEntity<Etudiant>(e, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/formateurs")
	public ResponseEntity<Formateur> insert(@RequestBody Formateur f) {
		bll.save(f);
		return new ResponseEntity<Formateur>(f, HttpStatus.CREATED);
	}
	
	@PutMapping("/admins/{id}")
	public ResponseEntity<Administrateur> updateAdmin(
			@PathVariable("id") int id,
			@RequestBody Administrateur a) {
		if (bll.contains(id)) {
			a.setId(id);
			bll.save(a);
			return new ResponseEntity<Administrateur>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<Administrateur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> updateEtudiant(
			@PathVariable("id") int id,
			@RequestBody Etudiant e) {
		if (bll.contains(id)) {
			e.setId(id);
			bll.save(e);
			return new ResponseEntity<Etudiant>(e, HttpStatus.OK);
		} else {
			return new ResponseEntity<Etudiant>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/formateurs/{id}")
	public ResponseEntity<Formateur> updateFormateur(
			@PathVariable("id") int id,
			@RequestBody Formateur f) {
		if (bll.contains(id)) {
			f.setId(id);
			bll.save(f);
			return new ResponseEntity<Formateur>(f, HttpStatus.OK);
		} else {
			return new ResponseEntity<Formateur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Personne> delete(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			Personne p = bll.findById(id);
			bll.delete(id);
			return new ResponseEntity<Personne>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<Personne>(HttpStatus.CONFLICT);
		}
	}
}
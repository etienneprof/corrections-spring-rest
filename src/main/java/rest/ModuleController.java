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

import bll.ModuleBLL;

@RestController
@RequestMapping("/modules")
public class ModuleController {
	@Autowired
	private ModuleBLL bll;
	
	@GetMapping
	public ResponseEntity<List<bo.Module>> getModules() {
		return new ResponseEntity<List<bo.Module>>(bll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<bo.Module> selectById(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			return new ResponseEntity<bo.Module>(bll.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<bo.Module>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<bo.Module> insert(@RequestBody bo.Module m) {
		bll.save(m);
		return new ResponseEntity<bo.Module>(m, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<bo.Module> update(
			@PathVariable("id") int id,
			@RequestBody bo.Module m) {
		if (bll.contains(id)) {
			m.setId(id);
			bll.save(m);
			return new ResponseEntity<bo.Module>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<bo.Module>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<bo.Module> delete(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			bo.Module m = bll.findById(id);
			bll.delete(id);
			return new ResponseEntity<bo.Module>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<bo.Module>(HttpStatus.CONFLICT);
		}
	}
}

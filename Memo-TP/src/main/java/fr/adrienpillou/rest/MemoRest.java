package fr.adrienpillou.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.adrienpillou.entities.Memo;
import fr.adrienpillou.repositories.MemoRepository;

@RestController @CrossOrigin("*")
public class MemoRest {
	@Autowired
	MemoRepository memoRepository;
	
	@GetMapping("/memos/user/{id}")
	public Iterable<Memo> findByUserId(@PathVariable Long id) {
		return memoRepository.findByUserId(id);
	}
	
	@GetMapping("/memos")
	public Iterable<Memo> allMemos() {
		return memoRepository.findAll();
	}
	
	@GetMapping("/date")
	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}
	
	@PostMapping("/memos")
	public Memo saveMemo(@RequestBody Memo memo) {
		return memoRepository.save(memo);
	}
	
	/*@DeleteMapping("memos/{idMemo}")
	public void deleteMemo(@PathVariable Long idMemo) {
		memoRepository.deleteById(idMemo);
	}*/
	
	@DeleteMapping("memos/{idMemo}")
	public Boolean deletememo(@PathVariable Long idMemo) {
		Optional<Memo> m = memoRepository.findById(idMemo);
		if(m.isEmpty()) {
			return false;
		}     
		memoRepository.deleteById(idMemo);
		return true;
	}
}

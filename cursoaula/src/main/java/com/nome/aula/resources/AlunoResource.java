package com.nome.aula.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nome.aula.DTO.CursoDTO;
import com.nome.aula.DTO.AlunoDTO;
import com.nome.aula.entity.CursoEntity;
import com.nome.aula.entity.AlunoEntity;
import com.nome.aula.service.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AlunoDTO> buscar() {	
		List<AlunoEntity> listaAlunos = service.buscar();
		List<AlunoDTO> listaDTO = listaAlunos.stream().map(
				obj -> new AlunoDTO(obj)).collect(Collectors.toList()
				);
		return listaDTO;				
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AlunoEntity> buscar(@PathVariable Integer id){
		AlunoEntity obj = service.buscar(id);		
		return ResponseEntity.ok(obj);
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody AlunoDTO objDTO){
	
		AlunoEntity obj = new AlunoEntity(
				null, 
				objDTO.getNome(),
				objDTO.getTelefone(),
				objDTO.getMatricula(),
				objDTO.getEmail()
		);
		
		obj = service.salvar(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/paginacao",method=RequestMethod.GET)
	public ResponseEntity<Page<AlunoDTO>> listarPaginas(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="qtd", defaultValue="15") Integer qtdLinhas, 
			@RequestParam(value="ordem", defaultValue="nome") String orderBy, 
			@RequestParam(value="dir", defaultValue="DESC") String dir
		) 
	{	
		Page<AlunoEntity> listaEntity = service.buscar(nome, pagina, qtdLinhas, orderBy, dir);
		
		Page<AlunoDTO> listaDTO = listaEntity.map(obj -> new AlunoDTO(obj));			
		
		return ResponseEntity.ok().body(listaDTO);				
	}
	
	
}

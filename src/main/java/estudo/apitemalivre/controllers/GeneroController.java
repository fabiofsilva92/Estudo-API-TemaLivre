package estudo.apitemalivre.controllers;

import estudo.apitemalivre.dto.genero.ConsultaGeneroDTO;
import estudo.apitemalivre.dto.genero.GeneroMapper;
import estudo.apitemalivre.dto.genero.RegistroGeneroDTO;
import estudo.apitemalivre.entities.Genero;
import estudo.apitemalivre.services.GeneroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaGeneroDTO>> getGeneros(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(generoService.buscarTodosGeneros(pageable).map(GeneroMapper :: fromEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaGeneroDTO> buscarGenero(@PathVariable Long id){
        Genero genero = generoService.buscarGenero(id);
        return ResponseEntity.ok(GeneroMapper.fromEntity(genero));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaGeneroDTO> saveGeneros(@RequestBody RegistroGeneroDTO genero){

        Genero genero1 = generoService.salvarGenero(GeneroMapper.fromDTO(genero));

        return ResponseEntity.ok(GeneroMapper.fromEntity(genero1));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaGeneroDTO> atualizarGenero(@RequestBody RegistroGeneroDTO dto, @PathVariable Long id){
        Genero genero = generoService.atualizarGenero(GeneroMapper.fromDTO(dto), id);
        return ResponseEntity.ok(GeneroMapper.fromEntity(genero));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaGeneroDTO> deletarGenero(@PathVariable Long id){
        try{
            generoService.excluirGenero(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }
}

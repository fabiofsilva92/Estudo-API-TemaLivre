package estudo.apitemalivre.controllers;

import estudo.apitemalivre.services.PlataformaService;
import estudo.apitemalivre.dto.plataforma.ConsultaPlataformaDTO;
import estudo.apitemalivre.dto.plataforma.PlataformaMapper;
import estudo.apitemalivre.dto.plataforma.RegistroPlataformaDTO;
import estudo.apitemalivre.entities.Plataforma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/plataformas")
public class PlataformaController {

    private final PlataformaService plataformaService;

    public PlataformaController(PlataformaService plataformaService) {
        this.plataformaService = plataformaService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaPlataformaDTO>> getPlataformas(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(plataformaService.buscarTodasPlataformas(pageable).map(PlataformaMapper::fromEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaPlataformaDTO> buscarPlataforma(@PathVariable Long id){
        Plataforma plataforma = plataformaService.buscarPlataforma(id);
        return ResponseEntity.ok(PlataformaMapper.fromEntity(plataforma));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaPlataformaDTO> savePlataforma(@RequestBody RegistroPlataformaDTO plataforma){

        Plataforma plataforma1 = plataformaService.salvarPlataforma(PlataformaMapper.fromDTO(plataforma));

        return ResponseEntity.ok(PlataformaMapper.fromEntity(plataforma1));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaPlataformaDTO> atualizarPlataforma(@RequestBody RegistroPlataformaDTO dto, @PathVariable Long id){

        Plataforma plataforma = plataformaService.atualizarPlataforma(PlataformaMapper.fromDTO(dto), id);

        return ResponseEntity.ok(PlataformaMapper.fromEntity(plataforma));

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaPlataformaDTO> deletarPlataforma(@PathVariable Long id){

        try{
            plataformaService.excluirPlataforma(id);
            return ResponseEntity.ok().build();

        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }

    }

}

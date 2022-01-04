package estudo.apitemalivre.controllers;

import estudo.apitemalivre.dto.jogo.ConsultaJogosDTO;
import estudo.apitemalivre.dto.jogo.JogoMapper;
import estudo.apitemalivre.dto.jogo.RegistroJogoDTO;
import estudo.apitemalivre.entities.Jogo;
import estudo.apitemalivre.services.GeneroService;
import estudo.apitemalivre.services.JogoService;
import estudo.apitemalivre.services.PlataformaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/jogos")
public class JogoController {

    private final JogoService jogoService;

    private final GeneroService generoService;

    private final PlataformaService plataformaService;

    public JogoController(JogoService jogoService, GeneroService generoService, PlataformaService plataformaService) {
        this.jogoService = jogoService;
        this.generoService = generoService;
        this.plataformaService = plataformaService;
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaJogosDTO>> getJogos(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(jogoService.buscarTodosJogos(pageable).map(JogoMapper :: fromEntity));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaJogosDTO> saveJogo(@RequestBody RegistroJogoDTO registroJogoDTO){

        Jogo jogo = jogoService.salvarJogo(JogoMapper.fromDTO(registroJogoDTO, generoService, plataformaService));

        return ResponseEntity.ok(JogoMapper.fromEntity(jogo));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaJogosDTO> buscarJogo(@PathVariable Long id){
        Jogo jogo = jogoService.buscarJogo(id);
        return ResponseEntity.ok(JogoMapper.fromEntity(jogo));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaJogosDTO> alterarJogo(@RequestBody RegistroJogoDTO dto, @PathVariable Long id){
        Jogo jogo = jogoService.atualizarJogo(JogoMapper.fromDTO(dto, generoService, plataformaService), id);
        return ResponseEntity.ok(JogoMapper.fromEntity(jogo));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaJogosDTO> deletarJogo(@PathVariable Long id){
        try{
            jogoService.excluirJogo(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }
}

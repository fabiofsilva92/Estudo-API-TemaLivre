package estudo.apitemalivre.services;

import estudo.apitemalivre.repositories.JogoRepository;
import estudo.apitemalivre.entities.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo salvarJogo(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    public Page<Jogo> buscarTodosJogos(Pageable pageable){
        return jogoRepository.findAll(pageable);
    }

    public Jogo buscarJogo(Long id){
        Optional<Jogo> jogo = jogoRepository.findById(id);

        return jogo.orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
    }

    public Jogo atualizarJogo(Jogo jogo, Long id){

        Jogo jogoOriginal = buscarJogo(id);

        jogo.setId(jogoOriginal.getId());

        return jogoRepository.save(jogo);

    }

    public void excluirJogo(Long id){
        Jogo jogo = buscarJogo(id);

        jogoRepository.delete(jogo);
    }
}

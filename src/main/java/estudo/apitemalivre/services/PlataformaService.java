package estudo.apitemalivre.services;

import estudo.apitemalivre.repositories.PlataformaRepository;
import estudo.apitemalivre.entities.Plataforma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public Plataforma salvarPlataforma(Plataforma plataforma){
        return plataformaRepository.save(plataforma);
    }

    public Plataforma buscarPlataforma(Long id){
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);

        return plataformaOptional.orElseThrow(()-> new EntityNotFoundException("Plataforma não encontrada"));
    }

    public Page<Plataforma> buscarTodasPlataformas(Pageable pageable){
        return plataformaRepository.findAll(pageable);
    }

    public Plataforma atualizarPlataforma(Plataforma plataforma, Long id){

        Plataforma plataformaOrig = buscarPlataforma(id);

        plataforma.setId(plataformaOrig.getId());

       return  plataformaRepository.save(plataforma);

    }

    public void excluirPlataforma(Long id){

        Plataforma plataforma = buscarPlataforma(id);

        plataformaRepository.delete(plataforma);

    }

}

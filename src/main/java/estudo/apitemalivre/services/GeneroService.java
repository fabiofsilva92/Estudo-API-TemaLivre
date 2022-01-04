package estudo.apitemalivre.services;

import estudo.apitemalivre.repositories.GeneroRepository;
import estudo.apitemalivre.entities.Genero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
    public Genero salvarGenero(Genero genero){
        return generoRepository.save(genero);
    }

    public Page<Genero> buscarTodosGeneros(Pageable pageable){
        return generoRepository.findAll(pageable);
    }

    public Genero buscarGenero(Long id){
        Optional<Genero> generoByID = generoRepository.findById(id);

        return generoByID.orElseThrow(() -> new EntityNotFoundException("Genero não encontrado"));
    }

    public Genero atualizarGenero(Genero genero, Long id){

        Genero generoOriginal = buscarGenero(id);

        genero.setId(generoOriginal.getId());

        return generoRepository.save(genero);

    }

    public void excluirGenero(Long id){

        Genero genero = buscarGenero(id);

        generoRepository.delete(genero);

    }
}

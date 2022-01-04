package estudo.apitemalivre.repositories;

import estudo.apitemalivre.entities.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Page<Jogo> findAll(Pageable pageable);
}

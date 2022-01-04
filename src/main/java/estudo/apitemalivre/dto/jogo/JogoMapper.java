package estudo.apitemalivre.dto.jogo;

import estudo.apitemalivre.dto.genero.ConsultaGeneroDTO;
import estudo.apitemalivre.dto.genero.GeneroMapper;
import estudo.apitemalivre.dto.plataforma.ConsultaPlataformaDTO;
import estudo.apitemalivre.dto.plataforma.PlataformaMapper;
import estudo.apitemalivre.entities.Genero;
import estudo.apitemalivre.entities.Jogo;
import estudo.apitemalivre.entities.Plataforma;
import estudo.apitemalivre.services.GeneroService;
import estudo.apitemalivre.services.PlataformaService;


import java.util.ArrayList;
import java.util.List;

public class JogoMapper {


    public static Jogo fromDTO(RegistroJogoDTO dto, GeneroService generoService, PlataformaService plataformaService){
        Genero genero = generoService.buscarGenero(dto.getGenero_id());

        List<Plataforma> plataformaList = new ArrayList<>();

        dto.getPlataformas().stream()
                .forEach(p -> plataformaList.add(plataformaService.buscarPlataforma(p)));

        return new Jogo(null, dto.getNome(),
                dto.getDataLancamento(),
                dto.getDescricao(),
                dto.getValor(), genero, plataformaList);
    }

    public static ConsultaJogosDTO fromEntity(Jogo jogo){
        ConsultaGeneroDTO consultaGeneroDTO = GeneroMapper.fromEntity(jogo.getGenero());

        List<ConsultaPlataformaDTO> plataformaDTOS = new ArrayList<>();

        jogo.getPlataforma().stream()
                .forEach(p -> plataformaDTOS.add(PlataformaMapper.fromEntity(p)));

        return new ConsultaJogosDTO(jogo.getId(), jogo.getNome(), jogo.getDataLancamento(),
                jogo.getDescricao(), jogo.getValor(), consultaGeneroDTO, plataformaDTOS);
    }

}

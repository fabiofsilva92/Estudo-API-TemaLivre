package estudo.apitemalivre.dto.plataforma;

import estudo.apitemalivre.entities.Plataforma;

public class PlataformaMapper {

    public static Plataforma fromDTO(RegistroPlataformaDTO registroPlataformaDTO){
        return new Plataforma(null,
                registroPlataformaDTO.getNome(),
                registroPlataformaDTO.getValor(),
                registroPlataformaDTO.getAnoLancamento());
    }

    public static ConsultaPlataformaDTO fromEntity(Plataforma plataforma){
        return new ConsultaPlataformaDTO(plataforma.getId(),
                plataforma.getNome(), plataforma.getValor(),
                plataforma.getAnoLancamento());
    }

}

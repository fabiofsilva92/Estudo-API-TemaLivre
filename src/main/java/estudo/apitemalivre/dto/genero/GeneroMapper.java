package estudo.apitemalivre.dto.genero;

import estudo.apitemalivre.entities.Genero;

public class GeneroMapper {

    public static Genero fromDTO(RegistroGeneroDTO registroGeneroDTO){
        return new Genero(null, registroGeneroDTO.getNome());
    }

    public static ConsultaGeneroDTO fromEntity(Genero genero){
        return new ConsultaGeneroDTO(genero.getId(), genero.getNome());
    }

}

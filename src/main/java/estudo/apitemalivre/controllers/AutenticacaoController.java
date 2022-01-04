package estudo.apitemalivre.controllers;

import estudo.apitemalivre.dto.AutenticacaoDTO;
import estudo.apitemalivre.dto.TokenDTO;
import estudo.apitemalivre.services.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("v1/auth")
public class AutenticacaoController {

    private AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO autenticacaoDTO){

        try{
            return ResponseEntity.ok(autenticacaoService.autenticar(autenticacaoDTO));
        }catch (AuthenticationException ae){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

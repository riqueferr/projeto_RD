package br.com.pi.projeto_RD.service;

import br.com.pi.projeto_RD.model.dto.OperadorDTO;
import br.com.pi.projeto_RD.controller.ResultData;
import br.com.pi.projeto_RD.model.entity.OperadorEntity;
import br.com.pi.projeto_RD.repository.LoginRepository;
import br.com.pi.projeto_RD.service.bo.LoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Base64;
import java.util.List;

@Component
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginBO loginBO;

    public ResponseEntity login(BigInteger nrMatricula, String pwOperador) {
        ResultData resultData = null;
        if(nrMatricula == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Matrícula inválida!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(pwOperador == null){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Senha inválida!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }


        try {

//            String codificado = Base64.getEncoder().encodeToString(pwOperador.getBytes());

            List<OperadorEntity> listEntity = repository.findByNrMatriculaAndPwOperador(nrMatricula, pwOperador);
            if(listEntity.size() == 0){
                resultData = new ResultData(HttpStatus.UNAUTHORIZED.value(), "Matrícula ou senha incorretas!");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultData);
            }
            OperadorDTO dto = null;

            for (OperadorEntity entity : listEntity) {
                dto = loginBO.parseToDTO(entity);
            }
            resultData = new ResultData(HttpStatus.ACCEPTED.value(), "Usuário autenticado com sucesso!", dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao autenticar usuário " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
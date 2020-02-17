package com.bctel.back.controllers;

import com.bctel.back.Response;
import com.bctel.back.enums.TalkMorePlan;
import com.bctel.back.models.Simulation;
import com.bctel.back.services.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/simulation")
@CrossOrigin(origins = "*")
public class SimulationController {

    @Autowired
    public SimulationService simulationService;

    @GetMapping
    public ResponseEntity<Response<Simulation>> test() {
        Response<Simulation> response = new Response();
        response.setData(simulationService.obtainCallPrice(testSimulation()));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<Simulation>> test(@Valid @RequestBody Simulation simulation) {
        Response<Simulation> response = new Response();
        response.setData(simulationService.obtainCallPrice(simulation));
        return ResponseEntity.ok(response);
    }

    private Simulation testSimulation() {
        return new Simulation(11, 16, 40, 30);
    }


//    @PostMapping
//    public ResponseEntity<Response<CadastroPFDto>> cadastrar(@Valid @RequestBody CadastroPFDto cadastroPFDto,
//                                                             BindingResult result) throws NoSuchAlgorithmException {
//        log.info("Cadastrando PF: {}", cadastroPFDto.toString());
//        Response<CadastroPFDto> response = new Response<CadastroPFDto>();
//
//        validarDadosExistentes(cadastroPFDto, result);
//        Funcionario funcionario = this.converterDtoParaFuncionario(cadastroPFDto, result);
//
//        if (result.hasErrors()) {
//            log.error("Erro validando dados de cadastro PF: {}", result.getAllErrors());
//            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(cadastroPFDto.getCnpj());
//        empresa.ifPresent(emp -> funcionario.setEmpresa(emp));
//        this.funcionarioService.persistir(funcionario);
//
//        response.setData(this.converterCadastroPFDto(funcionario));
//        return ResponseEntity.ok(response);
//    }
}

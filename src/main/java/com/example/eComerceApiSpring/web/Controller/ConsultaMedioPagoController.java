package com.example.eComerceApiSpring.web.Controller;

import com.example.eComerceApiSpring.domain.service.ConsultaMedioPagoService;
import com.example.eComerceApiSpring.utils.genericos.ObjetoListaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultaMedioPago")
public class ConsultaMedioPagoController {
    private final ConsultaMedioPagoService consultaMedioPagoService;

    public ConsultaMedioPagoController(ConsultaMedioPagoService consultaMedioPagoService) {
        this.consultaMedioPagoService = consultaMedioPagoService;
    }

    @GetMapping("/generarListaDesplegableMedioPago")
    public ResponseEntity<List<ObjetoListaDTO>> generarListaDesplegableMedioPago(){
        return new ResponseEntity<>(consultaMedioPagoService.consultaMedioPago(), HttpStatus.OK);
    }
}

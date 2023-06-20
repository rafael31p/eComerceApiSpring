package com.example.eComerceApiSpring.domain.service;

import com.example.eComerceApiSpring.utils.enums.MedioPagoEnum;
import com.example.eComerceApiSpring.utils.genericos.ObjetoListaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaMedioPagoService {
    public List<ObjetoListaDTO> consultaMedioPago(){
        List<ObjetoListaDTO> objetoListaDTOS = new ArrayList<>();
        for(MedioPagoEnum medioPagoEnum : MedioPagoEnum.values()){
            ObjetoListaDTO objetoListaDTO = new ObjetoListaDTO();
            objetoListaDTO.setExitos(true);
            objetoListaDTO.setEtiqueta(medioPagoEnum.getCodigoMessage());
            objetoListaDTO.setValor(medioPagoEnum.name());
            objetoListaDTOS.add(objetoListaDTO);
        }
        return objetoListaDTOS;
    }
}

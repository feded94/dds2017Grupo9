package com.dds.model.metodologia.operadores.unarios;

public class DecrecienteEstricto extends OperadorCrecimiento {
    @Override
    public boolean compare(Double newer, Double older) {
        return newer < older;
    }

    @Override
    public String nombre() {
        return "ES ESTRICTAMENTE DECRECIENTE";
    }
}

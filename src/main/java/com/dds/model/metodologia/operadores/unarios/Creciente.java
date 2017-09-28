package com.dds.model.metodologia.operadores.unarios;

public class Creciente extends OperadorCrecimiento {
    @Override
    protected boolean compare(Double newer, Double older) {
        return newer >= older;
    }
}

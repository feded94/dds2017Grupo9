package com.dds.utils;

import com.dds.persistence.services.CuentaService;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ArchivoCuentasParser {
    private BufferedReader reader;

    public ArchivoCuentasParser(File archivo) {
        try {
            InputStream is = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(is);

            this.reader = new BufferedReader(isr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean procesarArchivo() {
        while (procesarSiguienteLinea());

        try {
            return reader.readLine() == null;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean procesarSiguienteLinea() {
        String line = null;

        try {
            for (;;) {
                line = reader.readLine();

                if (line == null) {
                    return false;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                List<String> strs = Arrays.asList(line.split(","));

                if (strs.size() != 4) {
                    System.err.println("Error de al intentar procesar: \"" + line + "\"");
                    return false;
                }

                String cuenta = strs.get(0).trim();
                String empresa = strs.get(1).trim();
                Integer periodo;
                double valor;

                try {
                    periodo = Integer.parseInt(strs.get(2).trim());
                } catch (NumberFormatException e) {
                    System.err.println("Error de al intentar procesar: \"" + line + "\"");
                    System.err.println("\tPeriodo debe ser un numero!");
                    return false;
                }

                try {
                    valor = Double.parseDouble(strs.get(3).trim());
                } catch (NumberFormatException e) {
                    System.err.println("Error de al intentar procesar: \"" + line + "\"");
                    System.err.println("\tValor de la cuenta debe ser un numero!");
                    return false;
                }

                return CuentaService.getService()
                        .save(cuenta, empresa, periodo, valor) != null;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            this.reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.dds;

import com.dds.utils.ArchivoCuentasParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

@Component
public class ProcesoCargaArchivos implements DisposableBean, Runnable {
    private final String dirname = "directorio-cuentas";
    private final Path dir;

    private boolean dispose = false;

    private Thread thread;

    Logger logger = LoggerFactory.getLogger(getClass());

    public ProcesoCargaArchivos() {
        this.dir = FileSystems.getDefault().getPath(dirname);

        this.thread = new Thread(this);
        this.thread.run();
    }

    @Override
    public void run() {
        cargaInicial();

        WatchService watcher;

        try {
            watcher = FileSystems.getDefault().newWatchService();

            dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            for ( ; !dispose; ) {
                WatchKey key = watcher.take();

                for (WatchEvent<?> watchEvent: key.pollEvents()) {
                    WatchEvent.Kind<?> kind = watchEvent.kind();

                    if (kind == OVERFLOW) {
                        // Manejar Overflow
                        manejarOverflow();
                        continue;
                    }

                    WatchEvent<Path> pathWatchEvent = (WatchEvent<Path>)watchEvent;
                    Path filename = dir.resolve(pathWatchEvent.context());

                    File file = filename.toFile();

                    if (file.isDirectory()) {
                        // No procesar nada si es un directorio.
                        continue;
                    }

                    if (!getExtension(file).equals("dat")) {
                        // Solo procesar los archivos .dat
                        continue;
                    }

                    if (kind == ENTRY_CREATE) {
                        // Manejar archivo creado
                        manejarArchivoCreado(file);
                    }
                    else if (kind == ENTRY_MODIFY) {
                        // Manejar archivo modificado
                        manejarArchivoModificado(file);
                    }
                    else if (kind == ENTRY_DELETE) {
                        // Manejar archivo borrado
                        manejarArchivoBorrado(file);
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargaInicial() {
        File[] files = dir.toFile().listFiles();

        for (File file : files) {
            if (!file.isDirectory() && getExtension(file).equals("dat")) {
                ArchivoCuentasParser parser = new ArchivoCuentasParser(file);
                parser.procesarArchivo();
                parser.close();
            }
        }
    }

    @Override
    public void destroy() {
        dispose = true;
    }

    private void manejarOverflow() { }

    private void manejarArchivoCreado(File file) {
        logger.info("Archivo creado: " + file);

        ArchivoCuentasParser parser = new ArchivoCuentasParser(file);
        parser.procesarArchivo();
        parser.close();
    }

    private void manejarArchivoModificado(File file) {
        logger.info("Archivo modificado: " + file);

        ArchivoCuentasParser parser = new ArchivoCuentasParser(file);
        parser.procesarArchivo();
        parser.close();
    }

    private void manejarArchivoBorrado(File file) {
        logger.info("Archivo borrado: " + file);
    }

    private String getExtension(File file) {
        String extension = "";
        String fileName = file.getName();

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        return extension;
    }
}

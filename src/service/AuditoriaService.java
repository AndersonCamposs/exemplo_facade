package service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AuditoriaService {

    private static final Logger logger = Logger.getLogger(AuditoriaService.class.getName());

    static {
        try {
            Files.createDirectories(Paths.get("logs"));

            FileHandler fileHandler = new FileHandler("logs/auditoria.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void registrarLog(String mensagem) {
        logger.info(mensagem);
    }
}

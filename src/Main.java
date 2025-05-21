import entity.ContaCorrente;
import entity.Usuario;
import facade.TransferenciaFacade;

public class Main {
    public static void main(String[] args) {
        TransferenciaFacade transferenciaFacade = new TransferenciaFacade(
                new ContaCorrente(
                        1000,
                        new Usuario("Anderson", "123456"),
                        "984828"
                )
        );

        transferenciaFacade.realizarTransferencia("Anderson", "123456", 500);
    }
}

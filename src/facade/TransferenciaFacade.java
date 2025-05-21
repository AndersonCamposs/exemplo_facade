package facade;

import entity.ContaCorrente;
import service.AuditoriaService;
import service.AutenticacaoService;

public class TransferenciaFacade {
    private AutenticacaoService autenticacaoService;
    private AuditoriaService auditoriaService;
    private ContaCorrente contaCorrente;

    public TransferenciaFacade(ContaCorrente contaCorrente) {
        this.autenticacaoService = new AutenticacaoService();
        this.auditoriaService = new AuditoriaService();
        this.contaCorrente = contaCorrente;
    }

    public void realizarTransferencia(String login, String senha, double valor) {
        System.out.println("Iniciando transferência...");
        // validando o usuário
        if (!autenticacaoService.autenticar(this.contaCorrente.getTitular(),
                login, senha)
        ) {
            auditoriaService.registrarLog("Erro de auntenticação.\nUsuário e/ou senha inválidos.");
            System.out.println("Erro de autenticação.");
            return;
        }
        if (contaCorrente.getSaldo() < valor) {
            auditoriaService.registrarLog("Erro ao realizar transferência. Saldo insuficiente.");
            System.out.println("Saldo insuficiente.");
            return;
        }
        this.contaCorrente.tranferir(valor);
        auditoriaService.registrarLog(
                "Transferência realizada no valor de R$ " + valor + " com sucesso."
        );
        System.out.println("Transferência realizada no valor de R$ " + valor + " com sucesso.");
    }
}

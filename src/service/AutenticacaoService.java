package service;

import entity.Usuario;

public class AutenticacaoService {

    public boolean autenticar(Usuario usuario, String login, String senha) {
        return usuario.getLogin().equals(login)
                && usuario.validarSenha(senha);
    }
}

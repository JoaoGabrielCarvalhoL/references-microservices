package br.com.carv.mscreditassessor.model;

public class ProtocoloSolicitacaoCartao {

    private String protocol;

    public ProtocoloSolicitacaoCartao() {

    }

    public ProtocoloSolicitacaoCartao(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}

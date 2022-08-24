package br.com.carv.mscreditassessor.exception;

public class ErrorOnCommunicationMSException extends RuntimeException {

    private Integer status;

    public ErrorOnCommunicationMSException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

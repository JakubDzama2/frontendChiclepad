package rest.controllerAdvice;

public class ApiError {

    private int status;
    private String errorMessage;

    public ApiError(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getStatus() {
        return status;
    }
}

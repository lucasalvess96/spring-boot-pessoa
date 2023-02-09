package br.com.person.project.comon;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErroValidatition {
    public static class ErrorDto {

        private final int status;
        private final String error;
        private final String message;
        private List<String> detailedMessages;

        public ErrorDto(HttpStatus httpStatus, String message) {
            status = httpStatus.value();
            error = httpStatus.getReasonPhrase();
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getError() {
            return error;
        }

        public String getMessage() {
            return message;
        }

        public List<String> getDetailedMessages() {
            return detailedMessages;
        }

        public void setDetailedMessages(List<String> detailedMessages) {
            this.detailedMessages = detailedMessages;
        }
    }
}

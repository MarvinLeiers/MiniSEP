package sep.mini.util;

import lombok.Getter;

@Getter
public class StringResponse {
    private final String response;

    public StringResponse(String response) {
        this.response = response;
    }
}

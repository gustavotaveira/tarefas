package br.com.home.infra.enums;

public enum Databases {

    POSTGRESQL(1, "jdbc:postgresql://localhost:5433/agenda", "postgres", "postgres");

    private Integer code;
    private String uri;
    private String username;
    private String password;

    Databases(Integer code, String uri, String username, String password) {
        this.code = code;
        this.uri = uri;
        this.username = username;
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public String getUri() {
        return uri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

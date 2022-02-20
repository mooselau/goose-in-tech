package demo.jpa.model;

public enum OrderStatus {
    INIT("INIT"),
    PROCESSING("PROC"),
    FINISH("FINI");

    private String dbValue;

    OrderStatus(String dbValue) {
        this.dbValue = dbValue;
    }
}

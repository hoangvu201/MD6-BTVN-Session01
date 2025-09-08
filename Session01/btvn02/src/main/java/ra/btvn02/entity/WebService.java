package ra.btvn02.entity;

public class WebService {
    private String name;
    private String value;

    public WebService(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

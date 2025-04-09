package course.extend;

public class Father {
    private String id;
    private String name;
    private String gender = "male";

    public Father() {
    }

    public Father(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

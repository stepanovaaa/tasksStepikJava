package hash;

public class MyClass {
    private Long id;
    private String name;

    public MyClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj){
        MyClass other = (MyClass) obj;
        return id.equals(other.id) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}

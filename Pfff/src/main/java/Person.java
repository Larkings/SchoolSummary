
public abstract class Person {
    private String id;
    private String name;
    private char gender;
    private int age;
    private String email;
    private String role;


    public abstract void introduce();

    public Person(){

    }

    public Person(String id){
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setRole(String role){
      this.role = role;
    };

    public String getRole () {
        return this.role;
    }

    public String getId(){
        return id;
    }
}

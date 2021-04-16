package java;

public abstract class Person {
    private String id;
    private String name;
    private String gender;
    private String email;
    private String role;
    private String birthday;
    private String subject;

    public abstract void introduce();

    public Person(){

    }

    public Person(String id, String name, String role, String email){
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getRole () {
        return this.role;
    }

    public void setRole(String role){
      this.role = role;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday ){
        this.birthday = birthday ;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}

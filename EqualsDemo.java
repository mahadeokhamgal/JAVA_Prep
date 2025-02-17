class User{
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {// obj to to be compared to and this is current object
        if (obj == this) {
            return true;
        } else {
            if (obj == null || this.getClass() != obj.getClass()) return false;//if classes not matching
            User user = (User) obj;
            return user.getId() == this.id && user.getName() == this.name;
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + this.name.hashCode(); // Typically, override hashCode when you override equals
    }
}

public class EqualsDemo{
    
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        System.out.println("== check output is -> " + (a == b));
        
        User userA = new User((long) 0, "john");
        User userB = new User((long) 0, "john");
        User userC = userA;
        System.out.println(".equals check userA.equals(userB) -> " + userA.equals(userB));
        System.out.println(".equals check userA.equals(userA) -> " + userA.equals(userA));
        System.out.println(".equals check userA.equals(userC) -> " + userA.equals(userC));

        System.out.println("== check (userA == userB) -> " + (userA == userB));
        System.out.println("== check (userA == userA) -> " + (userA == userA));
        System.out.println("== check (userA == userC) -> " + (userA == userC));
    }
}
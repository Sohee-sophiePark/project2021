package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");   
        
        em1.setAlternateEmail("alt@gmail.com");
        System.out.println(em1.getAlternateEmail());
        
        em1.changePassword("testtest1234");
        System.out.println(em1.getPassword());

        em1.showInfo();
    }
}

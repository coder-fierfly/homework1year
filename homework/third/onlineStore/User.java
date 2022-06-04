package homework.third.onlineStore;

public class User {
    private String login;
    private String password;
    private Basket basket = new Basket();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

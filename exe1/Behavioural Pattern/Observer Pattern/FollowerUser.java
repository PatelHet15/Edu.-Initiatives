import java.util.ArrayList;
import java.util.List;


interface User {
    void update();
    void followAccount(Account ac);
}


interface Subject {
    void follower(Follower f);
    void unfollower(Follower uf);
    void notifyFollower();
    void upload(String name);
}

class Account implements Subject {
    private List<Follower> followers = new ArrayList<>();
    public String title;

    @Override
    public void follower(Follower f) {
        followers.add(f);
    }

    @Override
    public void unfollower(Follower uf) {
        followers.remove(uf);
    }

    @Override
    public void notifyFollower() {
        for (Follower f : followers) {
            f.update();
        }
    }

    @Override
    public void upload(String title) {
        this.title = title;
        notifyFollower();
    }
}

class Follower implements User {
    private String name;
    private Account account;

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " received update: New upload - " + account.title);
    }

    @Override
    public void followAccount(Account ac) {
        this.account = ac;
    }
}

public class FollowerUser {
    public static void main(String[] args) {
        Account account = new Account();

       
        Follower s1 = new Follower("Kunj");
        Follower s2 = new Follower("Smit");
        Follower s3 = new Follower("Het");
        Follower s4 = new Follower("Kamesh");
        Follower s5 = new Follower("Meet");

       
        account.follower(s1);
        account.follower(s2);
        account.follower(s3);
        account.follower(s4);
        account.follower(s5);

        s1.followAccount(account);
        s2.followAccount(account);
        s3.followAccount(account);
        s4.followAccount(account);
        s5.followAccount(account);

        account.upload("tourner dans le vide");
        account.unfollower(s4);
        System.out.println("\n");
        account.upload("go down deh");
    }
}

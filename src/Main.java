import customCollections.CustomArrayList;
import customSort.BubbleSort;
import customSort.comparators.UserAgeComparator;
import models.User;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<User> users = new CustomArrayList<>(5);

        User user1 = new User("Vita", 27);
        User user2 = new User("Anton", 17);
        User user3 = new User("Elena", 15);
        User user4 = new User("Jimmy", 24);
        User user5 = new User("Jack", 18);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(users);

        BubbleSort.sort(users, new UserAgeComparator());

        System.out.println(users);
    }
}

package study.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;
    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Kenneth", new Date()));
        users.add(new User(3, "Kenneth", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
               return user;
            }
        }

        return null;
    }

    public User deleteUser(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateUser(int id, User user) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User target = iterator.next();

            if (target.getId() == id) {
                target.setName(user.getName());
                target.setJoinDate(user.getJoinDate());
                return target;
            }
        }
        return null;
    }
}

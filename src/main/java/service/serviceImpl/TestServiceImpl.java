package service.serviceImpl;

import entity.User;
import org.springframework.stereotype.Service;
import service.TestService;
/**
 * @Author:RichelYu
 */
@Service
public class TestServiceImpl implements TestService {

    public User getUser(String userName) {
        User user = new User();
        user.setUserName("于冰融");
        return user;
    }
}

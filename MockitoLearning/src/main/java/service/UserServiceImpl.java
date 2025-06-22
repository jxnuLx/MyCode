package service;

import dao.UserUpdateReq;
import dao.UserVo;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public int modifyById(UserUpdateReq userUpdateReq) {
        return 0;
    }

    @Override
    public UserVo selectById(long id) {
        return null;
    }

    @Override
    public void add(String username, String phone, List<String> features) {

    }

    @Override
    public int getNumber() {
        System.out.println("get number");
        return 0;
    }
}

package service;

import dao.UserUpdateReq;
import dao.UserVo;

import java.util.List;

public interface UserService {
    int modifyById(UserUpdateReq userUpdateReq);
    UserVo selectById(long  id);

    void add(String username, String phone, List<String> features);

    int getNumber();

}

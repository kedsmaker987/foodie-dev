package com.kejian.service.impl;

import com.kejian.mapper.UsersMapper;
import com.kejian.pojo.Users;
import com.kejian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserNameIsExist(String userName) {
        Example userExample = new Example(Users.class);

        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",userName);
        Users result = usersMapper.selectOneByExample(userExample);
        return result==null?false:true;
    }
}

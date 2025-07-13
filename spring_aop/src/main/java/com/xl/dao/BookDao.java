package com.xl.dao;

import org.omg.CORBA.PUBLIC_MEMBER;

public interface BookDao {
    public void save();
    public void update();
    public int select();
}

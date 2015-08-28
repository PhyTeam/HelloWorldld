package com.bookstore.dao;

import java.sql.SQLException;

import com.bookstore.model.MemberUser;

public interface MemberUserDAO {
	public MemberUser getMemberUserById(String id) throws SQLException;
	public void addMemberUser(MemberUser user);
	public void deleteMemberUser(MemberUser user);
	public void updateMemberUser(MemberUser user);
}

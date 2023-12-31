package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.UserDao;
import com.ssafy.fit.model.dto.SearchCondition;
import com.ssafy.fit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}
	
	@Override
	public List<User> search(SearchCondition condition) {
		// TODO Auto-generated method stub
		return userDao.search(condition);
	}
	
	//최영진 / 박소현 아주 훌륭 그자체
	@Override
	public int signup(User user) {
		return userDao.insertUser(user);
	}


	@Override
	public User login(User user) {
		//DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
		User tmp = userDao.selectOne(user.getId());
		//tmp가 실제 User 정보 일수도 있고 / null 넘어왔다.
		if(tmp != null && tmp.getPassword().equals(user.getPassword()))
			return tmp;
		return null;
	}


	@Override
	public User selectOne(String id) {
		// TODO Auto-generated method stub
		return userDao.selectOne(id);
	}


}

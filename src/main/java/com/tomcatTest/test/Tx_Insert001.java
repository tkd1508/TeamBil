package com.tomcatTest.test;

import org.apache.ibatis.annotations.Insert;

public interface Tx_Insert001 {
	@Insert("insert into step002 (todo) values (#{data})")
	public int insertTodo(String data);
}

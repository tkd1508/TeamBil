package com.tomcatTest.test;

import org.apache.ibatis.annotations.Insert;

public interface Tx_Insert002 {
	@Insert("insert into step001 (todo) values (#{data})")
	public int insertTodo(String data);
}

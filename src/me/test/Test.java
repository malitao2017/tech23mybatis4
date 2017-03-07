package me.test;

import org.apache.ibatis.session.SqlSession;

import me.domain.Order;

public class Test {
	
	public static void main(String[] args){
		testGetOrderById();//不能查出
		testGetOrderById1();//方式1
		testGetOrderById2();//方式2
	}
	
	public static void testGetOrderById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String statement = "me.mapping.orderMapper.getOrderById";
		Order result = sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println("原来："+result);
	}
	
	public static void testGetOrderById1(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String statement = "me.mapping.orderMapper.selectOrder";
		Order result = sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println("方式1："+result);
	}
	public static void testGetOrderById2(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String statement = "me.mapping.orderMapper.selectOrderResultMap";
		Order result = sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println("方式2："+result);
	}
	
}

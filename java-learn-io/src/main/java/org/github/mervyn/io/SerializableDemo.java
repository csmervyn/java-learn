package org.github.mervyn.io;

import java.io.Serializable;

/**
  * @ClassName: SerializableDemo
  * @Description: 实现Serializable接口，该实体类的对象就有了序列化的能力
  * @author: mervyn 
  * @date 2015年12月26日 下午8:02:17
  *
  */
public class SerializableDemo implements Serializable {
	
	/**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	
	private static final long serialVersionUID = 4929415483278521509L;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "SerializableDemo [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

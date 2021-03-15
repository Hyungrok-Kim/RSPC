package com.myproject.rspc.user.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int mno;
	private String id;
	private String pwd;
	private String mname;
}

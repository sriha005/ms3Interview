package com.person.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//This represents a record in the table which we named as person in the database
@Entity
@Table(name="person")
public class PersonEntity {

	@Column(name="A")
	String a;
	@Column(name="B")
	String b;
	//We are making column c as a primary key as values here appear to be unique
	@Id
	@Column(name="C")
	String c;
	@Column(name="D")
	String d;
	@Column(name="E")
	String e;
	@Column(name="F")
	String f;
	@Column(name="G")
	String g;
	@Column(name="H")
	boolean h;
	@Column(name="I")
	boolean i;
	@Column(name="J")
	String j;
	
	public PersonEntity() {
		super();
	}
	public PersonEntity(String[] values){
		super();
		this.a=values[0];
		this.b=values[1];
		this.c=values[2];
		this.d=values[3];
		this.e=values[4];
		this.f=values[5];
		this.g=values[6];
		this.h=Boolean.parseBoolean(values[7]);
		this.i=Boolean.parseBoolean(values[8]);
		this.j=values[9];
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public boolean isH() {
		return h;
	}
	public void setH(boolean h) {
		this.h = h;
	}
	public boolean isI() {
		return i;
	}
	public void setI(boolean i) {
		this.i = i;
	}
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}

}

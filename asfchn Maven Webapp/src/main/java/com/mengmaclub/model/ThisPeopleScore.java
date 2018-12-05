package com.mengmaclub.model;

public class ThisPeopleScore {
private double thisPeopleScore1=0.0;
 private double thisPeopleScore2=0.0;
private double thisPeopleScore3=0.0;
private double time=0.0;
public double getThisPeopleScore1() {
	return thisPeopleScore1;
}
public void setThisPeopleScore1(double thisPeopleScore1) {
	this.thisPeopleScore1 = thisPeopleScore1;
}
public double getThisPeopleScore2() {
	return thisPeopleScore2;
}
public void setThisPeopleScore2(double thisPeopleScore2) {
	this.thisPeopleScore2 = thisPeopleScore2;
}
public double getThisPeopleScore3() {
	return thisPeopleScore3;
}
public void setThisPeopleScore3(double thisPeopleScore3) {
	this.thisPeopleScore3 = thisPeopleScore3;
}
public double getTime() {
	return time;
}
public void setTime(double time) {
	this.time = time;
}
@Override
public String toString() {
	return "ThisPeopleScore [thisPeopleScore1=" + thisPeopleScore1
			+ ", thisPeopleScore2=" + thisPeopleScore2 + ", thisPeopleScore3="
			+ thisPeopleScore3 + ", time=" + time + "]";
}



}

package com.mengmaclub.model;

import java.util.List;

public class JoinMatchTeamPeopleList {

	private List<JoinMatchTeamPeople> JoinMatchTeamPeoples;

	public List<JoinMatchTeamPeople> getJoinMatchTeamPeople() {
		return JoinMatchTeamPeoples;
	}

	public void setJoinMatchTeamPeople(List<JoinMatchTeamPeople> joinMatchTeamPeoples) {
		this.JoinMatchTeamPeoples = joinMatchTeamPeoples;
	}

	@Override
	public String toString() {
		return "JoinMatchTeamPeopleList [JoinMatchTeamPeoples="
				+ JoinMatchTeamPeoples + "]";
	}
	
}

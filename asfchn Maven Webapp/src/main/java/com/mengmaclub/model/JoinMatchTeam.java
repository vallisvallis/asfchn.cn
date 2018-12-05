package com.mengmaclub.model;

import java.util.Date;

public class JoinMatchTeam implements Comparable<JoinMatchTeam>{
    private Integer id;

    private String teamname;

    private Integer blongteam;

    private String blongteamname;

    private Date addtime;

    private String prop1;

    private Integer isconfirm;

    private String peopleid;

    private Integer matchid;

    private String matchname;

    private Integer teamrank;
    private Integer teamscore;
    
    @Override
	public String toString() {
		return "JoinMatchTeam [id=" + id + ", teamname=" + teamname + ", blongteam=" + blongteam + ", blongteamname="
				+ blongteamname + ", addtime=" + addtime + ", prop1=" + prop1 + ", isconfirm=" + isconfirm
				+ ", peopleid=" + peopleid + ", matchid=" + matchid + ", matchname=" + matchname + ", teamRank="
				+ teamrank + ", teamScore=" + teamscore + "]";
	}

	public Integer getTeamrank() {
		return teamrank;
	}

	public void setTeamrank(Integer teamRank) {
		this.teamrank = teamRank;
	}

	public Integer getTeamscore() {
		return teamscore;
	}

	public void setTeamscore(Integer teamScore) {
		this.teamscore = teamScore;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public Integer getBlongteam() {
        return blongteam;
    }

    public void setBlongteam(Integer blongteam) {
        this.blongteam = blongteam;
    }

    public String getBlongteamname() {
        return blongteamname;
    }

    public void setBlongteamname(String blongteamname) {
        this.blongteamname = blongteamname == null ? null : blongteamname.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1 == null ? null : prop1.trim();
    }

    public Integer getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Integer isconfirm) {
        this.isconfirm = isconfirm;
    }

    public String getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(String peopleid) {
        this.peopleid = peopleid == null ? null : peopleid.trim();
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname == null ? null : matchname.trim();
    }

	@Override
	public int compareTo(JoinMatchTeam o) {
		if(null ==o){
			return 1;
		}
		double fin1=this.teamscore;
		double fin2=o.teamscore;
		double result=fin1-fin2;
		return (int) Math.ceil(result);
	}
}
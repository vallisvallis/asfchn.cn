package com.mengmaclub.model;

public class JoinMatchTeamPeople {
	private Integer id;

	private Integer job;

	private String jobname;

	private String name;

	private Integer peopleid;

	private String peoplegender;

	private String peoplesn;

	private Integer joinmatchlist;

	private String joinmatchlistinname;

	private Integer gage;

	private String pinlv;

	private String isteammatchlist;

	private Integer teamid;

	private Integer matchid;

	private String matchname;
	
	private Integer joinwhichjointeam;
	
	private String score1;
	
	private String score2;
	
	private String score3;

	private String teamname;
	
	
	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getScore3() {
		return score3;
	}

	public void setScore3(String score3) {
		this.score3 = score3;
	}

	@Override
	public String toString() {
		return "JoinMatchTeamPeople [id=" + id + ", job=" + job + ", jobname="
				+ jobname + ", name=" + name + ", peopleid=" + peopleid
				+ ", peoplegender=" + peoplegender + ", peoplesn=" + peoplesn
				+ ", joinmatchlist=" + joinmatchlist + ", joinmatchlistinname="
				+ joinmatchlistinname + ", gage=" + gage + ", pinlv=" + pinlv
				+ ", isteammatchlist=" + isteammatchlist + ", teamid=" + teamid
				+ ", matchid=" + matchid + ", matchname=" + matchname
				+ ", joinwhichjointeam=" + joinwhichjointeam + ", score1="
				+ score1 + ", score2=" + score2 + ", score3=" + score3
				+ ", teamname=" + teamname + "]";
	}

	public Integer getJoinwhichjointeam() {
		return joinwhichjointeam;
	}

	public void setJoinwhichjointeam(Integer joinwhichjointeam) {
		this.joinwhichjointeam = joinwhichjointeam;
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
		this.matchname = matchname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname == null ? null : jobname.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Integer peopleid) {
		this.peopleid = peopleid;
	}

	public String getPeoplegender() {
		return peoplegender;
	}

	public void setPeoplegender(String peoplegender) {
		this.peoplegender = peoplegender == null ? null : peoplegender.trim();
	}

	public String getPeoplesn() {
		return peoplesn;
	}

	public void setPeoplesn(String peoplesn) {
		this.peoplesn = peoplesn == null ? null : peoplesn.trim();
	}

	public Integer getJoinmatchlist() {
		return joinmatchlist;
	}

	public void setJoinmatchlist(Integer joinmatchlist) {
		this.joinmatchlist = joinmatchlist;
	}

	public String getJoinmatchlistinname() {
		return joinmatchlistinname;
	}

	public void setJoinmatchlistinname(String joinmatchlistinname) {
		this.joinmatchlistinname = joinmatchlistinname == null ? null
				: joinmatchlistinname.trim();
	}

	public Integer getGage() {
		return gage;
	}

	public void setGage(Integer gage) {
		this.gage = gage;
	}

	public String getPinlv() {
		return pinlv;
	}

	public void setPinlv(String pinlv) {
		this.pinlv = pinlv == null ? null : pinlv.trim();
	}

	public String getIsteammatchlist() {
		return isteammatchlist;
	}

	public void setIsteammatchlist(String isteammatchlist) {
		this.isteammatchlist = isteammatchlist == null ? null : isteammatchlist
				.trim();
	}

	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}
	
}
package com.mengmaclub.model;

public class Withfriendmatch implements Comparable<Withfriendmatch>{
    private Integer id;

    private String sn;

    private String name;

    private Integer joinpeopleid;

    private Integer turn;

    private Integer rank;

    private String scoreone;

    private String scoretwo;

    private String finalscore;

    private Integer oneroundrid;

    private Integer tworoundrid;

    private String teamname;

    private String reward;

    private Integer isteammatch;

    private String num;

    private Integer joinmatch;

    private Integer joinlist;

    private Integer joingagae;

    private String myteamfriend;

    private Integer isconfirm;

    private Integer tworoundisconfirm;

    private Integer oneroundisconfirm;

    private Double scoreonebytranslate;

    private Double scoretwobytranslate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getJoinpeopleid() {
        return joinpeopleid;
    }

    public void setJoinpeopleid(Integer joinpeopleid) {
        this.joinpeopleid = joinpeopleid;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getScoreone() {
        return scoreone;
    }

    public void setScoreone(String scoreone) {
        this.scoreone = scoreone == null ? null : scoreone.trim();
    }

    public String getScoretwo() {
        return scoretwo;
    }

    public void setScoretwo(String scoretwo) {
        this.scoretwo = scoretwo == null ? null : scoretwo.trim();
    }

    public String getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(String finalscore) {
        this.finalscore = finalscore == null ? null : finalscore.trim();
    }

    public Integer getOneroundrid() {
        return oneroundrid;
    }

    public void setOneroundrid(Integer oneroundrid) {
        this.oneroundrid = oneroundrid;
    }

    public Integer getTworoundrid() {
        return tworoundrid;
    }

    public void setTworoundrid(Integer tworoundrid) {
        this.tworoundrid = tworoundrid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward == null ? null : reward.trim();
    }

    public Integer getIsteammatch() {
        return isteammatch;
    }

    public void setIsteammatch(Integer isteammatch) {
        this.isteammatch = isteammatch;
    }

   

    public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getJoinmatch() {
        return joinmatch;
    }

    public void setJoinmatch(Integer joinmatch) {
        this.joinmatch = joinmatch;
    }

    public Integer getJoinlist() {
        return joinlist;
    }

    public void setJoinlist(Integer joinlist) {
        this.joinlist = joinlist;
    }

    public Integer getJoingagae() {
        return joingagae;
    }

    public void setJoingagae(Integer joingagae) {
        this.joingagae = joingagae;
    }

    public String getMyteamfriend() {
        return myteamfriend;
    }

    public void setMyteamfriend(String myteamfriend) {
        this.myteamfriend = myteamfriend == null ? null : myteamfriend.trim();
    }

    public Integer getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Integer isconfirm) {
        this.isconfirm = isconfirm;
    }

    public Integer getTworoundisconfirm() {
        return tworoundisconfirm;
    }

    public void setTworoundisconfirm(Integer tworoundisconfirm) {
        this.tworoundisconfirm = tworoundisconfirm;
    }

    public Integer getOneroundisconfirm() {
        return oneroundisconfirm;
    }

    public void setOneroundisconfirm(Integer oneroundisconfirm) {
        this.oneroundisconfirm = oneroundisconfirm;
    }

    public Double getScoreonebytranslate() {
        return scoreonebytranslate;
    }

    public void setScoreonebytranslate(Double scoreonebytranslate) {
        this.scoreonebytranslate = scoreonebytranslate;
    }

    public Double getScoretwobytranslate() {
        return scoretwobytranslate;
    }

    public void setScoretwobytranslate(Double scoretwobytranslate) {
        this.scoretwobytranslate = scoretwobytranslate;
    }

	@Override
	public int compareTo(Withfriendmatch o) {
		if(null ==o){
			return 1;
		}
		double fin1=this.scoreonebytranslate+this.scoretwobytranslate;
		double fin2=o.scoreonebytranslate+o.scoretwobytranslate;
		double result=fin2-fin1;
		return (int) Math.ceil(result);
	}
}
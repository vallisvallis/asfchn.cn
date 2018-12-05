package com.mengmaclub.model;

public class Mangoptionsmatch  implements Comparable<Mangoptionsmatch>{
    private Integer id;

    private String sn;

    private String name;

    private Integer joinpeopleid;

    private Integer turn;

    private Integer rank;

    private String score1one;

    private String score2one;

    private String score3one;

    private String score4one;

    private String score5one;

    private String score6one;

    private String score7one;

    private String score8one;

    private String score9one;

    private String score10one;

    private String score1two;

    private String score2two;

    private String score3two;

    private String score4two;

    private String score5two;

    private String score6two;

    private String score7two;

    private String score8two;

    private String score9two;

    private String score10two;

    private String scorefinalone;

    private String scorefinaltwo;

    private String scorefinal;

    private Double scoreonebytranslate;

    private Double scoretwobytranslate;

    private Integer tworoundisconfirm;

    private Integer oneroundisconfirm;

    private Integer oneroundrid;

    private Integer tworoundrid;

    private String teamname;

    private String reward;

    private Integer isteammatch;

    private String num;
    
    private Integer joinmatch;

    private Integer joinlist;

    private Integer joingage;

    private Integer isconfirm;

    
    public Integer getJoinmatch() {
		return joinmatch;
	}

	public void setJoinmatch(Integer joinmatch) {
		this.joinmatch = joinmatch;
	}

	@Override
	public String toString() {
		return "Mangoptionsmatch [id=" + id + ", sn=" + sn + ", name=" + name + ", joinpeopleid=" + joinpeopleid
				+ ", turn=" + turn + ", rank=" + rank + ", score1one=" + score1one + ", score2one=" + score2one
				+ ", score3one=" + score3one + ", score4one=" + score4one + ", score5one=" + score5one + ", score6one="
				+ score6one + ", score7one=" + score7one + ", score8one=" + score8one + ", score9one=" + score9one
				+ ", score10one=" + score10one + ", score1two=" + score1two + ", score2two=" + score2two
				+ ", score3two=" + score3two + ", score4two=" + score4two + ", score5two=" + score5two + ", score6two="
				+ score6two + ", score7two=" + score7two + ", score8two=" + score8two + ", score9two=" + score9two
				+ ", score10two=" + score10two + ", scorefinalone=" + scorefinalone + ", scorefinaltwo=" + scorefinaltwo
				+ ", scorefinal=" + scorefinal + ", scoreonebytranslate=" + scoreonebytranslate
				+ ", scoretwobytranslate=" + scoretwobytranslate + ", tworoundisconfirm=" + tworoundisconfirm
				+ ", oneroundisconfirm=" + oneroundisconfirm + ", oneroundrid=" + oneroundrid + ", tworoundrid="
				+ tworoundrid + ", teamname=" + teamname + ", reward=" + reward + ", isteammatch=" + isteammatch
				+ ", num=" + num + ", joinmatch=" + joinmatch + ", joinlist=" + joinlist + ", joingage=" + joingage
				+ ", isconfirm=" + isconfirm + "]";
	}

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

    public String getScore1one() {
        return score1one;
    }

    public void setScore1one(String score1one) {
        this.score1one = score1one == null ? null : score1one.trim();
    }

    public String getScore2one() {
        return score2one;
    }

    public void setScore2one(String score2one) {
        this.score2one = score2one == null ? null : score2one.trim();
    }

    public String getScore3one() {
        return score3one;
    }

    public void setScore3one(String score3one) {
        this.score3one = score3one == null ? null : score3one.trim();
    }

    public String getScore4one() {
        return score4one;
    }

    public void setScore4one(String score4one) {
        this.score4one = score4one == null ? null : score4one.trim();
    }

    public String getScore5one() {
        return score5one;
    }

    public void setScore5one(String score5one) {
        this.score5one = score5one == null ? null : score5one.trim();
    }

    public String getScore6one() {
        return score6one;
    }

    public void setScore6one(String score6one) {
        this.score6one = score6one == null ? null : score6one.trim();
    }

    public String getScore7one() {
        return score7one;
    }

    public void setScore7one(String score7one) {
        this.score7one = score7one == null ? null : score7one.trim();
    }

    public String getScore8one() {
        return score8one;
    }

    public void setScore8one(String score8one) {
        this.score8one = score8one == null ? null : score8one.trim();
    }

    public String getScore9one() {
        return score9one;
    }

    public void setScore9one(String score9one) {
        this.score9one = score9one == null ? null : score9one.trim();
    }

    public String getScore10one() {
        return score10one;
    }

    public void setScore10one(String score10one) {
        this.score10one = score10one == null ? null : score10one.trim();
    }

    public String getScore1two() {
        return score1two;
    }

    public void setScore1two(String score1two) {
        this.score1two = score1two == null ? null : score1two.trim();
    }

    public String getScore2two() {
        return score2two;
    }

    public void setScore2two(String score2two) {
        this.score2two = score2two == null ? null : score2two.trim();
    }

    public String getScore3two() {
        return score3two;
    }

    public void setScore3two(String score3two) {
        this.score3two = score3two == null ? null : score3two.trim();
    }

    public String getScore4two() {
        return score4two;
    }

    public void setScore4two(String score4two) {
        this.score4two = score4two == null ? null : score4two.trim();
    }

    public String getScore5two() {
        return score5two;
    }

    public void setScore5two(String score5two) {
        this.score5two = score5two == null ? null : score5two.trim();
    }

    public String getScore6two() {
        return score6two;
    }

    public void setScore6two(String score6two) {
        this.score6two = score6two == null ? null : score6two.trim();
    }

    public String getScore7two() {
        return score7two;
    }

    public void setScore7two(String score7two) {
        this.score7two = score7two == null ? null : score7two.trim();
    }

    public String getScore8two() {
        return score8two;
    }

    public void setScore8two(String score8two) {
        this.score8two = score8two == null ? null : score8two.trim();
    }

    public String getScore9two() {
        return score9two;
    }

    public void setScore9two(String score9two) {
        this.score9two = score9two == null ? null : score9two.trim();
    }

    public String getScore10two() {
        return score10two;
    }

    public void setScore10two(String score10two) {
        this.score10two = score10two == null ? null : score10two.trim();
    }

    public String getScorefinalone() {
        return scorefinalone;
    }

    public void setScorefinalone(String scorefinalone) {
        this.scorefinalone = scorefinalone == null ? null : scorefinalone.trim();
    }

    public String getScorefinaltwo() {
        return scorefinaltwo;
    }

    public void setScorefinaltwo(String scorefinaltwo) {
        this.scorefinaltwo = scorefinaltwo == null ? null : scorefinaltwo.trim();
    }

    public String getScorefinal() {
        return scorefinal;
    }

    public void setScorefinal(String scorefinal) {
        this.scorefinal = scorefinal == null ? null : scorefinal.trim();
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

	public Integer getJoinlist() {
        return joinlist;
    }

    public void setJoinlist(Integer joinlist) {
        this.joinlist = joinlist;
    }

    public Integer getJoingage() {
        return joingage;
    }

    public void setJoingage(Integer joingage) {
        this.joingage = joingage;
    }

    public Integer getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Integer isconfirm) {
        this.isconfirm = isconfirm;
    }

	@Override
	public int compareTo(Mangoptionsmatch o) {
		
		if(null ==o){
			return 1;
		}
		double fin1=this.scoreonebytranslate+this.scoretwobytranslate;
		double fin2=o.scoreonebytranslate+o.scoretwobytranslate;
		double result=fin2-fin1;
		
		return (int) Math.ceil(result);
	}
}
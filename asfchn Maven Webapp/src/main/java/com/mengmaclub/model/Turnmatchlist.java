package com.mengmaclub.model;

public class Turnmatchlist implements Comparable<Turnmatchlist> {
    private Integer id;

    private String sn;

    private String name;

    private Integer joinpeopleid;

    private Integer turn1;

    private Integer turn2;

    private Integer rank1;

    private Integer rank2;

    private Integer rankfinal;

    private String oneturnpowertime;

    private String oneturnpointmeter;

    private String oneturnskytime;

    private String oneturnscore;

    private Double scoreinoneturnhascalc;

    private String twoturnpowertime;

    private String twoturnpointmeter;

    private String twoturnskytime;

    private String twoturnscore;

    private Double scoreintwoturnhascalc;

    private String finalscore;

    private Integer oneroundrid;

    private Integer tworoundrid;

    private String teamname;

    private String reward;

    private Integer isteammatch;

    private String num;

    private Integer joinmatch;
    private Integer joinlist;

    private Integer joingage;

    private Integer oneroundisconfirm;

    private Integer tworoundisconfirm;

    
    
    
    public Integer getJoinmatch() {
		return joinmatch;
	}

	public void setJoinmatch(Integer joinmatch) {
		this.joinmatch = joinmatch;
	}

	@Override
	public String toString() {
		return "Turnmatchlist [id=" + id + ", sn=" + sn + ", name=" + name + ", joinpeopleid=" + joinpeopleid
				+ ", turn1=" + turn1 + ", turn2=" + turn2 + ", rank1=" + rank1 + ", rank2=" + rank2 + ", rankfinal="
				+ rankfinal + ", oneturnpowertime=" + oneturnpowertime + ", oneturnpointmeter=" + oneturnpointmeter
				+ ", oneturnskytime=" + oneturnskytime + ", oneturnscore=" + oneturnscore + ", scoreinoneturnhascalc="
				+ scoreinoneturnhascalc + ", twoturnpowertime=" + twoturnpowertime + ", twoturnpointmeter="
				+ twoturnpointmeter + ", twoturnskytime=" + twoturnskytime + ", twoturnscore=" + twoturnscore
				+ ", scoreintwoturnhascalc=" + scoreintwoturnhascalc + ", finalscore=" + finalscore + ", oneroundrid="
				+ oneroundrid + ", tworoundrid=" + tworoundrid + ", teamname=" + teamname + ", reward=" + reward
				+ ", isteammatch=" + isteammatch + ", num=" + num + ", joinmatch=" + joinmatch + ", joinlist="
				+ joinlist + ", joingage=" + joingage + ", oneroundisconfirm=" + oneroundisconfirm
				+ ", tworoundisconfirm=" + tworoundisconfirm + "]";
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

    public Integer getTurn1() {
        return turn1;
    }

    public void setTurn1(Integer turn1) {
        this.turn1 = turn1;
    }

    public Integer getTurn2() {
        return turn2;
    }

    public void setTurn2(Integer turn2) {
        this.turn2 = turn2;
    }

    public Integer getRank1() {
        return rank1;
    }

    public void setRank1(Integer rank1) {
        this.rank1 = rank1;
    }

    public Integer getRank2() {
        return rank2;
    }

    public void setRank2(Integer rank2) {
        this.rank2 = rank2;
    }

    public Integer getRankfinal() {
        return rankfinal;
    }

    public void setRankfinal(Integer rankfinal) {
        this.rankfinal = rankfinal;
    }

    public String getOneturnpowertime() {
        return oneturnpowertime;
    }

    public void setOneturnpowertime(String oneturnpowertime) {
        this.oneturnpowertime = oneturnpowertime == null ? null : oneturnpowertime.trim();
    }

    public String getOneturnpointmeter() {
        return oneturnpointmeter;
    }

    public void setOneturnpointmeter(String oneturnpointmeter) {
        this.oneturnpointmeter = oneturnpointmeter == null ? null : oneturnpointmeter.trim();
    }

    public String getOneturnskytime() {
        return oneturnskytime;
    }

    public void setOneturnskytime(String oneturnskytime) {
        this.oneturnskytime = oneturnskytime == null ? null : oneturnskytime.trim();
    }

    public String getOneturnscore() {
        return oneturnscore;
    }

    public void setOneturnscore(String oneturnscore) {
        this.oneturnscore = oneturnscore == null ? null : oneturnscore.trim();
    }

    public Double getScoreinoneturnhascalc() {
        return scoreinoneturnhascalc;
    }

    public void setScoreinoneturnhascalc(Double scoreinoneturnhascalc) {
        this.scoreinoneturnhascalc = scoreinoneturnhascalc;
    }

    public String getTwoturnpowertime() {
        return twoturnpowertime;
    }

    public void setTwoturnpowertime(String twoturnpowertime) {
        this.twoturnpowertime = twoturnpowertime == null ? null : twoturnpowertime.trim();
    }

    public String getTwoturnpointmeter() {
        return twoturnpointmeter;
    }

    public void setTwoturnpointmeter(String twoturnpointmeter) {
        this.twoturnpointmeter = twoturnpointmeter == null ? null : twoturnpointmeter.trim();
    }

    public String getTwoturnskytime() {
        return twoturnskytime;
    }

    public void setTwoturnskytime(String twoturnskytime) {
        this.twoturnskytime = twoturnskytime == null ? null : twoturnskytime.trim();
    }

    public String getTwoturnscore() {
        return twoturnscore;
    }

    public void setTwoturnscore(String twoturnscore) {
        this.twoturnscore = twoturnscore == null ? null : twoturnscore.trim();
    }

    public Double getScoreintwoturnhascalc() {
        return scoreintwoturnhascalc;
    }

    public void setScoreintwoturnhascalc(Double scoreintwoturnhascalc) {
        this.scoreintwoturnhascalc = scoreintwoturnhascalc;
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

    public Integer getOneroundisconfirm() {
        return oneroundisconfirm;
    }

    public void setOneroundisconfirm(Integer oneroundisconfirm) {
        this.oneroundisconfirm = oneroundisconfirm;
    }

    public Integer getTworoundisconfirm() {
        return tworoundisconfirm;
    }

    public void setTworoundisconfirm(Integer tworoundisconfirm) {
        this.tworoundisconfirm = tworoundisconfirm;
    }

	@Override
	public int compareTo(Turnmatchlist o) {
		if(null ==o){
			return 1;
		}
		double finalscore=0.0;
		double otherfinalscore=0.0;
		if (o.joinlist==20) {
			try {
				finalscore=Double.parseDouble(this.finalscore);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				otherfinalscore=Double.parseDouble(o.finalscore);
			} catch (Exception e) {
				// TODO: handle exception
			}
			double result=finalscore-otherfinalscore;
			
			return (int) Math.ceil(result);
		}
		try {
			finalscore=Double.parseDouble(this.finalscore);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			otherfinalscore=Double.parseDouble(o.finalscore);
		} catch (Exception e) {
			// TODO: handle exception
		}
		double result=otherfinalscore-finalscore;
		
		return (int) Math.ceil(result);
	}
}
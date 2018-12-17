package com.mengmaclub.model;

public class Twoptionsmatch implements Comparable<Twoptionsmatch> {
	private Integer id;// id由数据生成

	private String sn;// 会员号，从页面上获取-------

	private String name;// 名字，从页面上获取-------

	private Integer joinpeopleid;// 参赛人的ID，从页面上获取------

	private Integer turn;// 批次，从页面上获取------

	private Integer rank;// 排名，有系统生成

	private String scoreone;// 第一轮成绩，String 类型，值由裁判写入

	private String scoretwo;// 第二轮成绩,String 类型,值由裁判写入

	private String finalscore;// 最终得分,String类型，值由系统计算

	private Integer oneroundrid;// 第一轮裁判，由页面获取--------

	private Integer tworoundrid;// 第二轮裁判，有页面获取--------

	private String teamname;// 由系统添加

	private String reward;// 奖项，由系统生成

	private Integer isteammatch;// 是否是团体会员，由系统生成

	private String num;// 编号，由系统生成
	
	private Integer joinmatch;
	private Integer joinlist;// 参加的项目，有系统生成

	private Integer joingage;// 参加的组别，由系统生成
	/*
	 * 0为 无，1为打分未确认，2为打分已确认
	 */
	private Integer tworoundisconfirm;// 第二轮是否确认，由裁判打分确定，此值如果确定，才可以进行最终排名计算，若未确定，再次打分时，仍打第二轮
	/*
	 * 0为 无，1为打分未确认，2为打分已确认
	 */
	private Integer oneroundisconfirm;// 第一轮是否确认，由裁判打分确定，此值如果确定，才可以进行第二轮打分，若未确定，再次打分时，仍打第一轮

	private Double scoreonebytranslate;// 第一轮的分数，由系统计算

	private Double scoretwobytranslate;// 第二轮的分数，由系统计算

	public Integer getJoinmatch() {
		return joinmatch;
	}

	public void setJoinmatch(Integer joinmatch) {
		this.joinmatch = joinmatch;
	}

	@Override
	public String toString() {
		return "Twoptionsmatch [id=" + id + ", sn=" + sn + ", name=" + name + ", joinpeopleid=" + joinpeopleid
				+ ", turn=" + turn + ", rank=" + rank + ", scoreone=" + scoreone + ", scoretwo=" + scoretwo
				+ ", finalscore=" + finalscore + ", oneroundrid=" + oneroundrid + ", tworoundrid=" + tworoundrid
				+ ", teamname=" + teamname + ", reward=" + reward + ", isteammatch=" + isteammatch + ", num=" + num
				+ ", joinmatch=" + joinmatch + ", joinlist=" + joinlist + ", joingage=" + joingage
				+ ", tworoundisconfirm=" + tworoundisconfirm + ", oneroundisconfirm=" + oneroundisconfirm
				+ ", scoreonebytranslate=" + scoreonebytranslate + ", scoretwobytranslate=" + scoretwobytranslate + "]";
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
	public int compareTo(Twoptionsmatch o) {
		if(null ==o){
			return 1;
		}
		double fin1=this.scoreonebytranslate+this.scoretwobytranslate;
		double fin2=o.scoreonebytranslate+o.scoretwobytranslate;
		double result=fin2-fin1;
		return (int) Math.ceil(result);
	}
}
package com.mengmaclub.model;

public class JoinExamPeople {
    private Integer id;

    private String name;

    private Integer teamid;

    private String peoplesn;

    private String examtype;

    private String examtypelevel;

    private Integer feestatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getPeoplesn() {
        return peoplesn;
    }

    public void setPeoplesn(String peoplesn) {
        this.peoplesn = peoplesn == null ? null : peoplesn.trim();
    }

    public String getExamtype() {
        return examtype;
    }

    public void setExamtype(String examtype) {
        this.examtype = examtype == null ? null : examtype.trim();
    }

    public String getExamtypelevel() {
        return examtypelevel;
    }

    public void setExamtypelevel(String examtypelevel) {
        this.examtypelevel = examtypelevel;
    }

    public Integer getFeestatus() {
        return feestatus;
    }

    public void setFeestatus(Integer feestatus) {
        this.feestatus = feestatus;
    }

	@Override
	public String toString() {
		return "JoinExamPeople [id=" + id + ", name=" + name + ", teamid="
				+ teamid + ", peoplesn=" + peoplesn + ", examtype=" + examtype
				+ ", examtypelevel=" + examtypelevel + ", feestatus="
				+ feestatus + "]";
	}
    
}
package com.neuedu.JiemoTest.entity;

public class QuestionAnswerVO {
	
	    private Integer paperid;

		private Integer questionid;

	    private String questionskill;

	    private String title;

	    private String options;

	    private String answer;

	    private Integer questiontype;

	    private String analysis;

	    private Integer difficultdegree;

	    private Integer edittime;
	    
	    private Integer questionserialnum;

	    private String answercontent;

	    private Integer score;

	    private Integer correctstate;

	    private Integer spare1;

	    private Integer spare2;

	    private String spare3;

	    private String spare4;
	   
	    public Integer getPaperid() {
		return paperid;
	}

	public void setPaperid(Integer paperid) {
		this.paperid = paperid;
	}

	    public Integer getQuestionid() {
	        return questionid;
	    }

	    public void setQuestionid(Integer questionid) {
	        this.questionid = questionid;
	    }

	    public String getQuestionskill() {
	        return questionskill;
	    }

	    public void setQuestionskill(String questionskill) {
	        this.questionskill = questionskill == null ? null : questionskill.trim();
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title == null ? null : title.trim();
	    }

	    public String getOptions() {
	        return options;
	    }

	    public void setOptions(String options) {
	        this.options = options == null ? null : options.trim();
	    }

	    public String getAnswer() {
	        return answer;
	    }

	    public void setAnswer(String answer) {
	        this.answer = answer == null ? null : answer.trim();
	    }

	    public Integer getQuestiontype() {
	        return questiontype;
	    }

	    public void setQuestiontype(Integer questiontype) {
	        this.questiontype = questiontype;
	    }

	    public String getAnalysis() {
	        return analysis;
	    }

	    public void setAnalysis(String analysis) {
	        this.analysis = analysis == null ? null : analysis.trim();
	    }

	    public Integer getDifficultdegree() {
	        return difficultdegree;
	    }

	    public void setDifficultdegree(Integer difficultdegree) {
	        this.difficultdegree = difficultdegree;
	    }

	    public Integer getEdittime() {
	        return edittime;
	    }

	    public void setEdittime(Integer edittime) {
	        this.edittime = edittime;
	    }

	    public Integer getSpare1() {
	        return spare1;
	    }

	    public void setSpare1(Integer spare1) {
	        this.spare1 = spare1;
	    }

	    public Integer getSpare2() {
	        return spare2;
	    }

	    public void setSpare2(Integer spare2) {
	        this.spare2 = spare2;
	    }

	    public String getSpare3() {
	        return spare3;
	    }

	    public void setSpare3(String spare3) {
	        this.spare3 = spare3 == null ? null : spare3.trim();
	    }

	    public String getSpare4() {
	        return spare4;
	    }

	    public void setSpare4(String spare4) {
	        this.spare4 = spare4 == null ? null : spare4.trim();
	    }

		public Integer getQuestionserialnum() {
			return questionserialnum;
		}

		public void setQuestionserialnum(Integer questionserialnum) {
			this.questionserialnum = questionserialnum;
		}

		public String getAnswercontent() {
			return answercontent;
		}

		public void setAnswercontent(String answercontent) {
			this.answercontent = answercontent;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		public Integer getCorrectstate() {
			return correctstate;
		}

		public void setCorrectstate(Integer correctstate) {
			this.correctstate = correctstate;
		}


}

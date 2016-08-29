package org.conference.parser.conference.talk;

public class Talk implements Comparable<Talk>{
	
	private String talkTitle;
	private int duration;
	
	public Talk(int duration, String talkTitle){
		this.setDuration(duration);
		this.setTalkTitle(talkTitle);
	}
	
	public String getTalkTitle() {
		return talkTitle;
	}
	public void setTalkTitle(String talkTitle) {
		this.talkTitle = talkTitle;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int compareTo(Talk thatTalk) {
		if (thatTalk.getDuration() > this.getDuration()){
			return -1;
		} else if (thatTalk.getDuration() < this.getDuration()){
			return 1;
		} else {
			return 0;
		}
			
	}
	
	
	
}

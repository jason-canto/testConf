package org.conference.parser.conference.organizer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.conference.parser.conference.talk.Talk;

public class ScheduleOrganizer {
	
	private static final int LUNCH_BEGGIN = 12 * 60;
	private static final int LUNCH_END = 13 * 60;
	private static final int NETWORK_TIME_BEGGIN = 16 * 60;
	private static final int NETWORK_TIME_END = 17 * 60;
	private Calendar calendar;

	public ScheduleOrganizer(){
		this.setCalendar(Calendar.getInstance());
		this.getCalendar().set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 9, 0);
	}
	
	public List<String> organizeTalks(List<Talk> talks) {
		List<String> schedule = new ArrayList<String>();
		Collections.sort(talks, Collections.reverseOrder());
		
		for (Talk talk: talks) {
			int timeInMinutes = (this.getCalendar().get(Calendar.HOUR_OF_DAY) * 60) + this.getCalendar().get(Calendar.MINUTE);
			if(timeInMinutes == LUNCH_BEGGIN){
				schedule.add(this.getTimeFormated() + " - Lunch time");
				this.getCalendar().add(Calendar.MINUTE, (LUNCH_END - timeInMinutes));
			} else if (timeInMinutes >= NETWORK_TIME_BEGGIN && timeInMinutes < NETWORK_TIME_END){
				schedule.add(this.getTimeFormated() + " - Networking Event");
				this.getCalendar().add(Calendar.MINUTE, (NETWORK_TIME_END - timeInMinutes));
			} else if (!(timeInMinutes >= NETWORK_TIME_END)){
				schedule.add(this.getTimeFormated() + " - " + talk.getTalkTitle());
				this.getCalendar().add(Calendar.MINUTE, talk.getDuration());
			} else {
				break;
			}
		}
		
		return schedule;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public String getTimeFormated(){
		SimpleDateFormat df = new SimpleDateFormat ("hh:mm a");
		return df.format(this.getCalendar().getTime());
	}

}

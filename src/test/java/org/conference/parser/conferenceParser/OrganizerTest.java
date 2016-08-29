package org.conference.parser.conferenceParser;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.conference.parser.conference.organizer.ScheduleOrganizer;
import org.conference.parser.conference.parser.Parser;
import org.conference.parser.conference.talk.Talk;
import org.junit.Test;

public class OrganizerTest {

	@Test
	public void testSchedule() {
		
		ScheduleOrganizer organizer = new ScheduleOrganizer();
		List<Talk> talks = new ArrayList<Talk>();
		List<String> schedule;
		
		for(int i=0; i<10; i++){
			talks.add(new Talk(60, "Test"));
		}
		
		schedule = organizer.organizeTalks(talks);
		assertEquals(8, schedule.size());
		assertTrue(schedule.get(0).contains("09:00 AM"));
		assertTrue(schedule.get(3).contains("12:00 PM - Lunch time"));
		assertTrue(schedule.get(7).contains("Networking Event"));
				
	}

}

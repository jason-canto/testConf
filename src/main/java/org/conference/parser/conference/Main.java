package org.conference.parser.conference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.conference.parser.conference.organizer.ScheduleOrganizer;
import org.conference.parser.conference.parser.Parser;
import org.conference.parser.conference.talk.Talk;

public class Main {
	
public static void main(String[] args) {
		
		Parser parser = new Parser();
		ScheduleOrganizer organizer = new ScheduleOrganizer();
		
		if(args.length > 0){
			File file = new File(args[0]);
			
			try {
				List<Talk> talks = parser.parseFile(file);
			
				List<String> schedule = organizer.organizeTalks(talks);
				for(String track : schedule){
					System.out.println(track);
				}
				
			} catch (FileNotFoundException e) {
			    System.out.println("File not found");
			} catch (IOException e) {
			    e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
	}

}

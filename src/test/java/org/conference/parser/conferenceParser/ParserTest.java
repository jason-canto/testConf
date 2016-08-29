package org.conference.parser.conferenceParser;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.conference.parser.conference.parser.Parser;
import org.conference.parser.conference.talk.Talk;
import org.junit.Test;

public class ParserTest {

	@Test
	public void testListSize() {
		
		Parser parser = new Parser();
		File file = new File("conf.txt");
		List<Talk> talks;
		try {
			talks = parser.parseFile(file);
			assertEquals(19, talks.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testFileFound() {
		Parser parser = new Parser();
		File file = new File("conf2.txt");
		try{
			List<Talk> talks = parser.parseFile(file);
			fail("Exception not thrown");
		} catch(FileNotFoundException e){
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue(false);
		}
		
		
	}
	
	@Test
	public void testFileEmpty() {
		Parser parser = new Parser();
		File file = new File("test.txt");
		try{
			List<Talk> talks = parser.parseFile(file);
			fail("Exception not thrown");
		} catch(FileNotFoundException e){
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue(false);
		}
		
		
	}	

}

package com.kodcu.web.tablesorter;

import java.util.ArrayList;
import java.util.List;

import com.kodcu.data.Project;

public class DataGenerator {
	
	public static List<Project> getData() {
		
		List<Project> data = new ArrayList<Project>();
		
		Project p01 = new Project();
		p01.setId(322);
		p01.setProjectName("good project");
		p01.setCreator("Altug Altintas");
		data.add(p01);
		
		Project p02 = new Project();
		p02.setId(15);
		p02.setProjectName("fair project");
		p02.setCreator("John Lanen");
		data.add(p02);
		
		Project p03 = new Project();
		p03.setId(815);
		p03.setProjectName("very good project");
		p03.setCreator("Tina John");
		data.add(p03);
		
		Project p04 = new Project();
		p04.setId(27);
		p04.setProjectName("best project");
		p04.setCreator("Osman Kalem");
		data.add(p04);
		
		return data;		
		
	}

}

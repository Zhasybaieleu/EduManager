package users;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import utils.academic.*;

import database.Database;
import enumerations.*;
import journals.Journal;
import utils.*;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Database.DATA.getUsers().put(new Credentials("margulan", "pass"), new Student());
		Database.DATA.getUsers().put(new Credentials("admin", "12345"), new Admin("Darkhan", "Aukenov"));
    	Dean rector = new Dean("Albus", "Dumbledore");
		Database.DATA.getUsers().put(new Credentials("rector", "12345"), rector);
		Database.DATA.setRector(rector);

		Dean d1 = new Dean("Minerva", "McGonagall");
		Database.DATA.getUsers().put(new Credentials("gryffindor", "12345"), d1);

		Dean d2 = new Dean("Severus", "Snape");
		Database.DATA.getUsers().put(new Credentials("slytherin", "12345"), d2);

		Dean d3 = new Dean("Filius", "Flitwick");
		Database.DATA.getUsers().put(new Credentials("ravenclaw", "12345"), d3);

		Dean d4 = new Dean("Pomona", "Sprout");
		Database.DATA.getUsers().put(new Credentials("hufflepuff", "12345"), d4);

		Database.DATA.getOffices().put(Faculty.GRYFFINDOR, d1);
		Database.DATA.getOffices().put(Faculty.SLYTHERIN, d1);
		Database.DATA.getOffices().put(Faculty.RAVENCLAW, d1);
		Database.DATA.getOffices().put(Faculty.HUFFLEPUFF, d1);
		Journal j = new Journal("Hogwarts time");
		Journal j2 = new Journal("Hogwarts scientific");
		Journal j3 = new Journal("Hogwarts geographics");

		HashMap<Faculty, CourseType> subjectType = new HashMap<Faculty, CourseType>();
		subjectType.put(Faculty.GRYFFINDOR, CourseType.MAJOR);
		subjectType.put(Faculty.SLYTHERIN, CourseType.MINOR);
		subjectType.put(Faculty.HUFFLEPUFF, CourseType.FREE_ELECTIVE);

		HashMap<Faculty, CourseType> subjectType2 = new HashMap<Faculty, CourseType>();
		subjectType2.put(Faculty.RAVENCLAW, CourseType.MAJOR);
		subjectType2.put(Faculty.GRYFFINDOR, CourseType.MINOR);
		subjectType2.put(Faculty.SLYTHERIN, CourseType.FREE_ELECTIVE);
		
		HashMap<Faculty, CourseType> subjectType3 = new HashMap<Faculty, CourseType>();
		subjectType3.put(Faculty.RAVENCLAW, CourseType.MAJOR);
		subjectType3.put(Faculty.GRYFFINDOR, CourseType.MINOR);

		Database.DATA.getSubjects().add(new Subject("CSCI2105", "Zelyevarenie", 5,subjectType ));
		Database.DATA.getSubjects().add(new Subject("CSCI2204", "Koldostvo", 5,subjectType2 ));
		Database.DATA.getSubjects().add(new Subject("CSCI2004", "Research Methods", 5,subjectType3 ));

		Database.DATA.getJournals().add(new Journal("Hogwarts Time"));
		Database.DATA.getJournals().add(new Journal("Hogwarts Scientific"));
		Database.DATA.getJournals().add(new Journal("BBC"));


		
		
		new HogwartsKZ().run();
		//a_mukhadilova@hogwarts.kz, +vfVBdiTy+Ix manager
		//k_kospan@hogwarts.kz, 8Z8wCwn82fFB teacher
		//u_shyndali@hogwarts.kz, 5-!!nzl0uZl phd student
		//v_demort@hogwarts.kz, +f7(Bqd5xn@1 techsupport
		//p_shamoi@hogwarts.kz, N)M5704@aAx3 phd
		//a_inoe@hogwarts.kz, qOxMH7QZh6s)
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Perform cleanup or any necessary actions
            try {
				Database.write();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Shutdown hook executed");
        }));
	}

}

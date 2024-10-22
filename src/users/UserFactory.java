package users;
import enumerations.*;
import myexceptions.InvalidManagerTypeException;

/**
 * @author kama
 */

public class UserFactory {
	/**
	 * 
	 * @return Dean or TechSupport based on userType
	 */
	public User getUser(String firstName, String lastName, UserType userType) {
		
		if (userType.equals(UserType.D)) {
			return new Dean(firstName, lastName);
		}
		
		else if(userType.equals(UserType.TS)) {
			return new TechSupport(firstName, lastName);
		}
		
		return null;
	}
	/**
	 *
	 * @return new Manager
	 * @throws InvalidManagerTypeException
	 */
	public User getUser(String firstName, String lastName, ManagerType managerType) throws InvalidManagerTypeException {
		return new Manager(firstName, lastName, managerType);
	}
	/**
	 *
	 * @return new Teacher
	 */
	public User getUser(String firstName, String lastName, Faculty faculty, TeacherType teacherType) {
			return new Teacher(firstName, lastName,faculty, teacherType);
	}
	/**
	 * 
	 * @return Student, MasterStudent, PhdStudent or Researcher based on userType
	 */
	public User getUser(String firstName, String lastName, UserType userType, Faculty facultyType) {
		
		if(userType.equals(UserType.MST)) {
			return new MasterStudent(firstName, lastName, facultyType);
		}
	
		else if(userType.equals(UserType.P)) {
			return new PhdStudent(firstName, lastName, facultyType);
		}
		
		else if(userType.equals(UserType.R)) {
			return new Researcher(firstName, lastName, facultyType);
		}
		
		else if(userType.equals(UserType.S)) {
			return new Student(firstName, lastName, facultyType);
		}
		return null;
	}
	/**
	 * 
	 * @param student who invoked becomeResearcher()
	 * @return new Researcher account
	 */
	public User getUser(Student student) {
		return new Researcher(student.getFirstName(), student.getLastName(), student.getFaculty());
	}
	/**
	 * 
	 * @param teacher who invoked becomeResearcher()
	 * @return new Researcher account
	 */
	public User getUser(Teacher teacher) {
		return new Researcher(teacher.getFirstName(), teacher.getLastName(), teacher.getFaculty());
	}
	

}

package utils.academic;




/**
* @author kama
*/
public class CourseFactory {

	/**
    * Method that makes new Course out of Subject
    */
    public static Course getCourse(Subject subject, int limit) {
    	return new Course(subject.getCode(), subject.getName(), subject.getEcts(), subject.getSubjectType(), limit);
    }
    
    
}

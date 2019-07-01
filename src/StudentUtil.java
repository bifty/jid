import java.security.InvalidParameterException;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] result = new double[studentIdList.length];
        int i = -1;
        
        for (char[] studentGrades : studentsGrades) {
        	double sumGrades = 0.0;
        	i++;
        	int numberOfGrades = studentGrades.length;
        	for( char grade: studentGrades) {
        		sumGrades += transformGradeToNumber(grade);
        	}
        	sumGrades = sumGrades / numberOfGrades;
        	result[i] = sumGrades;
        }
        
    	return result ;
    }
    
    private static double transformGradeToNumber(char grade) {
    	switch (grade) {
    		case 'A' : return 4;
    		case 'B' : return 3;
    		case 'C' : return 2;
    		default: throw new InvalidParameterException("not such grade!");
    	}
	}

	public static  int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        
        // invoke calculateGPA
        
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
    	int[] result = { 4 };
    	return result;
    }
    
}
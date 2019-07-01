import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.junit.Test;

public class StudentUtilTest {

	@Test
	public void testSingleStudentAndOneGrade() {
		double[] resultA = StudentUtil.calculateGPA(new int[]{1}, new char[][] {{'A'}});
		assertArrayEquals(new double[]{4}, resultA, 0.0);

		double[] resultB = StudentUtil.calculateGPA(new int[]{1}, new char[][] {{'B'}});
		assertArrayEquals(new double[]{3}, resultB, 0.0);

		double[] resultC = StudentUtil.calculateGPA(new int[]{1}, new char[][] {{'C'}});
		assertArrayEquals(new double[]{2}, resultC, 0.0);
	}

	@Test
	public void testSingleStudentAndTwoGrades() {
		double[] resultSameGradesA = StudentUtil.calculateGPA(new int[] {1}, new char[][] {{'A', 'A'}});
		assertArrayEquals(new double[]{4}, resultSameGradesA, 0.0);

		double[] resultSameGradesB = StudentUtil.calculateGPA(new int[] {1}, new char[][] {{'B', 'B'}});
		assertArrayEquals(new double[]{3}, resultSameGradesB, 0.0);

		double[] resultDifferentGrades = StudentUtil.calculateGPA(new int[] {1}, new char[][] {{'A', 'B'}});
		assertArrayEquals(new double[]{3.5}, resultDifferentGrades, 0.0);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void wrongGradesShouldThrowError() {
		double[] resultSameGradesB = StudentUtil.calculateGPA(new int[] {1}, new char[][] {{'Z', 'B'}});
		assertArrayEquals(new double[]{3}, resultSameGradesB, 0.0);
	}
	
	@Test
	public void testTwoStudentsAndOneGrade() {
		int[] studentIdList = {1, 2}; 
		char[][] studentsGrades = {{'A'},{'B'}};
		
		double[] resultTwoStudents = StudentUtil.calculateGPA(studentIdList, studentsGrades);
		assertArrayEquals(new double[]{4, 3}, resultTwoStudents, 0.0);
	}

	@Test
	public void testThreeStudentsAndOneGrade() {
		int[] studentIdList = {1, 2, 3}; 
		char[][] studentsGrades = {{'A'},{'B'}, {'C'}};
		
		double[] resultThreeStudents = StudentUtil.calculateGPA(studentIdList, studentsGrades);
		assertArrayEquals(new double[]{4, 3, 2}, resultThreeStudents, 0.0);
	}
	
	@Test
	public void testThreeStudentsAndMultipleGrades() {
		int[] studentIdList = {1, 2, 3}; 
		char[][] studentsGrades = {{'A', 'B', 'A'},{'B', 'A'}, {'C', 'A', 'C'}};
		
		double[] resultThreeStudents = StudentUtil.calculateGPA(studentIdList, studentsGrades);
		assertArrayEquals(new double[]{3.66, 3.5, 2.66}, resultThreeStudents, 0.01);
	}

	@Test
	public void getNoneStudentPerGPA() {
		int[] studentIdList = {1, 2, 3}; 
		char[][] studentsGrades = {{'A', 'B', 'A'},{'B', 'A'}, {'C', 'A', 'C'}};

		int[] students = StudentUtil.getStudentsByGPA(3.0, 4.0, studentIdList, studentsGrades);
		assertArrayEquals(new int[]{}, students);
		
	}
	
}

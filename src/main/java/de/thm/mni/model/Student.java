package de.thm.mni.model;


import de.thm.mni.util.CheckConstructorInputs;
import java.util.HashSet;
import java.util.Set;

public class Student extends User {
  private final Set<String> strengths;
  private final Set<String> weaknesses;


  /**
   * A Constructor for the class "Student".
   * Includes methods to check the values and throw error if blank or null.
   * @param fname the first name of the student.
   * @param sname the second name of the student.
   * @param username the username of the student.
   * @param email the email of the student.
   * @param password the password of the student.
   * @param strengths the strengths of the student.
   * @param weaknesses tht weaknesses of the student.
   */
  public Student(String fname, String sname, String username, String email, String password,
                 Set<String> strengths, Set<String> weaknesses) {
    super(fname, sname, username, email, password);
    this.strengths = CheckConstructorInputs.requireNotNullOrBlankSet(strengths);
    this.weaknesses = CheckConstructorInputs.requireNotNullOrBlankSet(weaknesses);
  }

  /**
   * Get-Methode for the strengths.
   * @return strengths of the student.
   */
  public Set<String> getStrengths() {
    return new HashSet<>(strengths);
  }

  /**
   * Get-Methode of the weaknesses.
   * @return weaknesses of the student.
   */
  public Set<String> getWeaknesses() {
    return new HashSet<>(weaknesses);
  }

  /**
   * The method specifies the representation of an instance of Student on the output.
   * @return the representation of a instance of Student.
   */
  public String toString() {
    return "Student{" +
      "fname='" + getFname() + '\'' +
      ", sname='" + getSname() + '\'' +
      ", username='" + getUsername() + '\'' +
      ", email='" + getEmail() + '\'' +
      ", strengths=" + strengths +
      ", weaknesses=" + weaknesses +
      '}';
  }
}

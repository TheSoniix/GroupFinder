package de.thm.mni.model;


import de.thm.mni.util.CheckConstructorInputs;
import java.util.HashSet;
import java.util.Set;

public class Tutor extends User {
  private final Set<String> competencies;
  private int capacity;

  /**
   * A Constructor for the class "Tutor".
   * Includes methods to check the values and throw error if blank or null.
   * @param fname the first name of the tutor.
   * @param sname the second name of the tutor.
   * @param username the username of the tutor.
   * @param email the email of the tutor.
   * @param password the password of the tutor.
   * @param competencies the competencies of the tutor.
   * @param capacity the capacity to teach groups of the tutor.
   */
  public Tutor(String fname, String sname, String username, String email, String password,
               Set<String> competencies, int capacity) {
    super(fname, sname, username, email, password);
    this.competencies = CheckConstructorInputs.requireNotNullOrBlankSet(competencies);
    this.capacity = CheckConstructorInputs.requireNotZeroOrNegativeInt(capacity);
  }

  /**
   * Get-Methode for the competencies.
   * @return competencies of the tutor.
   */
  public Set<String> getCompetencies() {
    return new HashSet<>(competencies);
  }

  /**
   * Get-Methode for the capacity.
   * @return capacity of the tutor.
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Set-Methode for the capacity.
   * @param capacity contains the value that must be set.
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  /**
   * The method specifies the representation of an instance of Tutor on the output.
   * @return the representation of a instance of Tutor.
   */
  @Override
  public String toString() {
    return "Tutor{" +
      "fname='" + getFname() + '\'' +
      ", sname='" + getSname() + '\'' +
      ", username='" + getUsername() + '\'' +
      ", email='" + getEmail() + '\'' +
      ", competencies=" + competencies +
      ", capacity=" + capacity +
      '}';
  }
}

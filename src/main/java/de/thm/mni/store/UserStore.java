package de.thm.mni.store;

import de.thm.mni.model.Student;
import de.thm.mni.model.Tutor;
import de.thm.mni.model.User;
import de.thm.mni.store.impl.UserStoreImpl;

import java.util.Optional;
import java.util.Set;

/**
 * Store to save users.
 * @param <T> A typ parameter that promises a type of User.
 */
public interface UserStore <T extends User>{

  /**
   * @return The instance of the UserStoreImpl with typ parameter Student.
   */
  static UserStore<Student> getStoreStudent(){    return UserStoreImpl.getInstanceStudent();}

  /**
   * @return The instance of the UserStoreImpl with typ parameter Tutor.
   */
  static UserStore<Tutor> getStoreTutor(){    return UserStoreImpl.getInstanceTutor();}


  /**
   * Store a user into the store. If the user already exists, it will be overwritten.
   * @param user The user to store.
   */
  void store(T user);

  /**
   * Searches and returns a user by username.
   * @param username The username of the user to find.
   * @return A non-empty optional of a user u with u.getUsername() = username exists.
   * Otherwise the optional is empty.
   */
  Optional<T> find(String username);

  /**
   * Remove a user from the store. If the user does not exists, the call does nothing.
   * @param user The user to remove.
   */
  void delete(T user);

  /**
   * @return Return all stored users.
   */
  Set<T> getAll();

  /**
   * @return Return the size of the instance of UserStore.
   */
  int getSize();


}

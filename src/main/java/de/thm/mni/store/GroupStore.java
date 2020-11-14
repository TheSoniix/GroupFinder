package de.thm.mni.store;

import de.thm.mni.model.Group;
import de.thm.mni.model.Student;
import de.thm.mni.store.impl.GroupStoreImpl;

import java.util.Optional;
import java.util.Set;

/**
 * Store to save group.
 */
public interface GroupStore {

  /**
   * @return The instance of the group store.
   */
  static GroupStore getStore() {
    return GroupStoreImpl.getInstance();
  }


  /**
   * Store a group into the store. If the group already exists, it will be overwritten.
   * @param group The group to store.
   */
  void store(Group group);

  /**
   * Searches and returns a group by id.
   *
   * @param id The id of the group to find.
   * @return A non-empty optional of a group u with g.getId() = id exists.
   * Otherwise the optional is empty.
   */
  Optional<Group> find(Integer id);

  /**
   * Remove a group from the store. If the group does not exists, the call does nothing.
   * @param group The group to remove.
   */
  void delete(Group group);

  /**
   * @return Return all stored groups.
   */
  Set<Group> getAll();

  /**
   * @return Return the size of the instance of GroupStore.
   */
  int getSize();

  /**
   * A method to check, whether a student is already am member of a group.
   * @param student The student we are looking for.
   * @return Returns true if the student is found.
   */
  Boolean searchStudent(Student student);


}

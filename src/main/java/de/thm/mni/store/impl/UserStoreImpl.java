package de.thm.mni.store.impl;

import de.thm.mni.model.Student;
import de.thm.mni.model.Tutor;
import de.thm.mni.model.User;
import de.thm.mni.store.UserStore;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserStoreImpl<T extends User> implements UserStore<T> {
  private final Set<T> runtimeStore = new HashSet<>();


  private static UserStore<Student> instanceStudent;
  private static UserStore<Tutor> instanceTutor;

  public static UserStore<Student> getInstanceStudent() {
    if (instanceStudent == null) {
      instanceStudent = new UserStoreImpl<>();
    }
    return instanceStudent;
  }
  public static UserStore<Tutor> getInstanceTutor() {
    if (instanceTutor == null) {
      instanceTutor = new UserStoreImpl<>();
    }
    return instanceTutor;
  }

  @Override
  public void store(T user) {
    this.runtimeStore.add(user);
  }

  @Override
  public Optional<T> find(String username) {
    return runtimeStore.stream()
      .filter(user -> user.getUsername().equalsIgnoreCase(username))
      .findFirst();
  }

  @Override
  public void delete(T user) {
    runtimeStore.remove(user);
  }

  @Override
  public Set<T> getAll() {
    return new HashSet<>(runtimeStore);
  }

  public int getSize() {
    return runtimeStore.size();
  }


}

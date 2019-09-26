package org.openmbee.sdvc.rdb.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.openmbee.sdvc.data.domains.global.Project;
import org.openmbee.sdvc.data.domains.global.ProjectUserPerm;
import org.openmbee.sdvc.data.domains.global.Role;
import org.openmbee.sdvc.data.domains.global.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserPermRepository extends JpaRepository<ProjectUserPerm, Long> {

    List<ProjectUserPerm> findAllByProject(Project proj);

    List<ProjectUserPerm> findAllByProjectAndInherited(Project proj, boolean inherited);

    List<ProjectUserPerm> findAllByProject_ProjectId(String projectId);

    Optional<ProjectUserPerm> findByProjectAndUserAndInheritedIsFalse(Project proj, User user);

    List<ProjectUserPerm> findAllByProjectAndRole_Name(Project proj, String r);

    boolean existsByProjectAndUser_UsernameAndRoleIn(Project proj, String user, Set<Role> roles);

    void deleteByProjectAndUser_UsernameInAndInheritedIsFalse(Project proj, Set<String> users);
}

package br.edu.unp.blog.backend.datasource.repositories;

import br.edu.unp.blog.backend.domainmodel.entities.QRole;
import br.edu.unp.blog.backend.domainmodel.entities.QUser;
import br.edu.unp.blog.backend.domainmodel.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    private static final QUser user = QUser.user;
    private static final QRole role = QRole.role;

    public Optional<User> findUserByNameJPQL(String name){
        return em.createQuery(
                "select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();

    }

    public Optional<User> findUserByNameDSL(String name){

        return Optional.ofNullable( new JPAQueryFactory(this.em)
                .selectFrom(user)
                .where(user.name.eq(name))
                .fetchOne());

    }

    public Optional<User> findUserByEmail(String email){

        return Optional.ofNullable( new JPAQueryFactory(this.em)
                .selectFrom(user)
                .where(user.email.eq(email))
                .fetchOne());

    }

    public List<User> findByUsersByRole(String roleName){
        return new JPAQueryFactory(this.em)
                .selectFrom(user)
                .where(user.roles.any().name.eq(roleName))
                .fetch();
    }


}

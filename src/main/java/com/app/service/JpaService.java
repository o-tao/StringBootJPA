package com.app.service;

import com.app.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JpaService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void run() {
        log.info("JpaService run");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            insert(entityManager);
//            select(entityManager, 1);
//            update(entityManager);
//            delete(entityManager);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private void insert(EntityManager eManager) {
        UserEntity user = new UserEntity();
        user.setUserNm("홍길동");
        user.setUserPwd("1");

        eManager.persist(user);

    }

    private void select(EntityManager eManager, int id) {
        UserEntity user = eManager.find(UserEntity.class, id);
        log.info("User : {}", user);
    }

    private void update(EntityManager eManager) {
        UserEntity user = eManager.find(UserEntity.class, 2);
        user.setUserNm("오길동");
        select(eManager, 2);
    }

    private void delete(EntityManager eManager) {
        UserEntity user = eManager.find(UserEntity.class, 2);
        eManager.remove(user);
    }
}

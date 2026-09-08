package com.example.learnhub.database.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;

    public DatabaseSeeder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (!isTableEmpty()) {
            return;
        }

        System.out.println("Seeding database...");
        String password = passwordEncoder.encode("password");

        insertUser(
            "seed-admin-001",
            catalogueId("Super Admin"),
            "admin",
            "admin@learnhub.local",
            password,
            "0901234567",
            "12 Nguyen Hue, Quan 1, TP.HCM",
            "https://cdn.learnhub.local/avatars/admin.png",
            "LearnHub Admin",
            "Quan tri vien he thong",
            "ACTIVE",
            true
        );

        insertUser(
            "seed-instructor-001",
            catalogueId("Instructor"),
            "instructor",
            "instructor@learnhub.local",
            password,
            "0901234568",
            "25 Le Loi, Quan 1, TP.HCM",
            "https://cdn.learnhub.local/avatars/instructor.png",
            "Nguyen Van Giang",
            "Giang vien lap trinh",
            "ACTIVE",
            true
        );

        insertUser(
            "seed-student-001",
            catalogueId("Student"),
            "student",
            "student@learnhub.local",
            password,
            "0901234569",
            "48 Tran Hung Dao, Quan 5, TP.HCM",
            "https://cdn.learnhub.local/avatars/student.png",
            "Tran Thi Hoc",
            "Hoc vien",
            "ACTIVE",
            false
        );
    }

    private void insertUser(
        String firebaseUid,
        Long userCatalogueId,
        String username,
        String email,
        String password,
        String phone,
        String address,
        String images,
        String fullName,
        String bio,
        String status,
        boolean emailVerified
    ) {
        entityManager.createNativeQuery(
            "INSERT INTO users ("
                + "firebase_uid, user_catalogue_id, username, email, password, "
                + "phone, address, images, full_name, bio, status, email_verified"
                + ") VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)"
        )
            .setParameter(1, firebaseUid)
            .setParameter(2, userCatalogueId)
            .setParameter(3, username)
            .setParameter(4, email)
            .setParameter(5, password)
            .setParameter(6, phone)
            .setParameter(7, address)
            .setParameter(8, images)
            .setParameter(9, fullName)
            .setParameter(10, bio)
            .setParameter(11, status)
            .setParameter(12, emailVerified ? 1 : 0)
            .executeUpdate();
    }

    private Long catalogueId(String name) {
        return ((Number) entityManager
            .createNativeQuery("SELECT id FROM users_catalogues WHERE name = ?1")
            .setParameter(1, name)
            .getSingleResult())
            .longValue();
    }

    private boolean isTableEmpty() {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(u.id) FROM User u").getSingleResult();
        return count == 0;
    }
}

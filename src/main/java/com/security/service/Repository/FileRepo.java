package com.security.service.Repository;

import com.security.service.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileRepo extends JpaRepository<File,Long> {
    @Query(value = "SELECT * from Files WHERE files.user_id = :userId",nativeQuery = true)
    List<File> findAllById(@Param("userId")Long userId);
    @Query(value = "SELECT f.file_name FROM files WHERE f.file_name = LIKE %:search% LIMIT 3", nativeQuery = true)
    List<String> search(@Param("search") String search);
}

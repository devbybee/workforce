package com.example.demo.repository;

import com.example.demo.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Long> {

    @Query("SELECT a FROM Revision a WHERE a.updatedAt BETWEEN :start AND :end")
    List<Revision> getLatestRevision(String start, String end);
}

package com.tns.jobservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslearnbds.entities.Course;
import com.devsuperior.dslearnbds.entities.Lesson;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.Reply;

public interface ReplayRepository extends JpaRepository<Reply, Long>{
					
}

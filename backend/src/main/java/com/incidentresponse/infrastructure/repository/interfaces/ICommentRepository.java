package com.incidentresponse.infrastructure.repository.interfaces;

import com.incidentresponse.infrastructure.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByIncidentId(Long incidentId);
}

package com.incidentresponse.infrastructure.repository.interfaces;

import com.incidentresponse.infrastructure.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long> {
}

package infractructure.mapper;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.infrastructure.entity.CommentEntity;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.entity.UserEntity;
import com.incidentresponse.infrastructure.mapper.CommentEntityMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = IncidentApplication.class)
public class TestCommentEntityMapper {
    private final CommentEntityMapper commentEntityMapper;

    @Autowired
    public TestCommentEntityMapper(CommentEntityMapper commentEntityMapper) {
        this.commentEntityMapper = commentEntityMapper;
    }

    @Test
    public void testEntityToDomain() {
        CommentEntity commentEntity = generateCommentEntity();
        Comment com = this.commentEntityMapper.entityToDomain(commentEntity);
        Assertions.assertNotNull(com.getId());
        Assertions.assertNotNull(com.getDescription());
        Assertions.assertNotNull(com.getIncident());
        Assertions.assertNotNull(com.getUser());
    }

    @Test
    public void testDomainToEntity() {
        Comment com = generateComment();
        CommentEntity commentEntity = this.commentEntityMapper.domainToEntity(com);
        Assertions.assertNotNull(commentEntity.getId());
        Assertions.assertNotNull(commentEntity.getDescription());
        Assertions.assertNotNull(commentEntity.getIncident());
        Assertions.assertNotNull(commentEntity.getUser());
    }


    /**
     * Generate a comment entity object
     *
     * @return a comment DTO object
     */
    public CommentEntity generateCommentEntity() {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(42L);
        commentEntity.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        commentEntity.setUser(new UserEntity());
        commentEntity.setIncident(new IncidentEntity());
        return commentEntity;
    }

    /**
     * Generate a comment
     *
     * @return a comment
     */
    public Comment generateComment() {
        Comment comment = new Comment();
        comment.setId(42L);
        comment.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        comment.setUser(new User());
        comment.setIncident(new Incident());
        return comment;
    }

}

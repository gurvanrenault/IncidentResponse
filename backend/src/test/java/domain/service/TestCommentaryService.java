package domain.service;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.domain.services.CommentService;
import com.incidentresponse.infrastructure.entity.CommentEntity;
import com.incidentresponse.infrastructure.mapper.CommentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.ICommentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = IncidentApplication.class)
public class TestCommentaryService {
    @Spy
    CommentEntityMapper commentEntityMapper;
    @Mock
    private ICommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @BeforeEach
    public void beforeEach() {
        when(commentRepository.save(any())).thenReturn(new CommentEntity());
        when(commentEntityMapper.entityToDomain(any())).thenReturn(new Comment());
    }

    @Test
    public void testAddComment() {
        Comment comment = generateComment();
        Comment comCreated = this.commentService.addComment(comment);
        Assertions.assertNotNull(comCreated);
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

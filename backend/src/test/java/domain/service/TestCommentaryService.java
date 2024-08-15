package domain.service;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.domain.services.CommentService;
import com.incidentresponse.infrastructure.entity.CommentEntity;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.entity.UserEntity;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private final Long ID_INCIDENT_EMPTY = 47L;
    private final Long ID_INCIDENT_NOT_EMPTY = 42L;
    private final CommentEntity[] ARRAY_COMMENTS_ENTITIES = new CommentEntity[]{this.generateCommentEntity()};
    private final List<CommentEntity> LIST_ENTITY = Arrays.stream(ARRAY_COMMENTS_ENTITIES).toList();
    private final List<CommentEntity> EMPTY_LIST_ENTITY = new ArrayList<>();



    @BeforeEach
    public void beforeEach() {
        when(commentRepository.save(any())).thenReturn(this.generateCommentEntity());
        when(commentRepository.findAllByIncidentId(ID_INCIDENT_EMPTY)).thenReturn(EMPTY_LIST_ENTITY);
        when(commentRepository.findAllByIncidentId(ID_INCIDENT_NOT_EMPTY)).thenReturn(LIST_ENTITY);
        when(commentEntityMapper.entityToDomain(any())).thenReturn(new Comment());
        when(commentEntityMapper.listEntityToDomain(EMPTY_LIST_ENTITY)).thenReturn(new ArrayList<>());
        when(commentEntityMapper.listEntityToDomain(LIST_ENTITY)).thenReturn(List.of(new Comment()));
    }

    @Test
    public void testAddComment() {
        Comment comment = generateComment();
        Comment comCreated = this.commentService.addComment(comment);
        Assertions.assertNotNull(comCreated);
    }

    @Test
    public void testGetCommentsNotEmpty() {
        List<Comment> comments = this.commentService.getCommentsByIdIncident(ID_INCIDENT_EMPTY);
        Assertions.assertEquals(0, comments.size());
    }

    @Test
    public void testGetCommentsEmpty() {
        List<Comment> comments = this.commentService.getCommentsByIdIncident(ID_INCIDENT_NOT_EMPTY);
        Assertions.assertEquals(1, comments.size());
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


}

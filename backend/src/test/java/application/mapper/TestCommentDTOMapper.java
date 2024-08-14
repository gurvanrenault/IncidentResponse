package application.mapper;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.application.dto.CommentDTO;
import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.application.mapper.CommentDTOMapper;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = IncidentApplication.class)
public class TestCommentDTOMapper {


    private final CommentDTOMapper commentDTOMapper;

    @Autowired
    public TestCommentDTOMapper(CommentDTOMapper commentDTOMapper) {
        this.commentDTOMapper = commentDTOMapper;
    }

    @Test
    public void testApplicationToDomain() {
        CommentDTO comDTO = generateCommentDTO();
        Comment com = this.commentDTOMapper.applicationToDomain(comDTO);
        Assertions.assertNotNull(com.getId());
        Assertions.assertNotNull(com.getDescription());
        Assertions.assertNotNull(com.getIncident());
        Assertions.assertNotNull(com.getUser());
    }

    @Test
    public void testDomainToApplication() {
        Comment com = generateComment();
        CommentDTO comDTO = this.commentDTOMapper.domainToApplication(com);
        Assertions.assertNotNull(comDTO.getId());
        Assertions.assertNotNull(comDTO.getDescription());
        Assertions.assertNotNull(comDTO.getIncident());
        Assertions.assertNotNull(comDTO.getUser());
    }


    /**
     * Generate a comment DTO objectd
     *
     * @return a comment DTO objectd
     */
    public CommentDTO generateCommentDTO() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(42L);
        commentDTO.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        commentDTO.setUser(new UserDTO());
        commentDTO.setIncident(new IncidentDTO());
        return commentDTO;
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

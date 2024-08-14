package application.validators;

import com.incidentresponse.application.dto.CommentDTO;
import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.application.utils.CommentValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCommentValidator {

    private CommentValidator commentValidator;

    @BeforeEach
    public void beforeEach() {
        this.commentValidator = new CommentValidator();
    }

    @Test
    public void testCommentValidatorNoMissing() {
        CommentDTO commentDTO = generateIncidentDTO(false, false, false);
        Assertions.assertTrue(this.commentValidator.isValid(commentDTO));
    }

    @Test
    public void testCommentValidatorMissingDescription() {
        CommentDTO commentDTO = generateIncidentDTO(true, false, false);
        Assertions.assertFalse(this.commentValidator.isValid(commentDTO));
    }

    @Test
    public void testCommentValidatorMissingIncident() {
        CommentDTO commentDTO = generateIncidentDTO(false, true, false);
        Assertions.assertFalse(this.commentValidator.isValid(commentDTO));
    }

    @Test
    public void testCommentValidatorMissingUser() {
        CommentDTO commentDTO = generateIncidentDTO(false, false, true);
        Assertions.assertFalse(this.commentValidator.isValid(commentDTO));
    }


    private CommentDTO generateIncidentDTO(boolean missingDescription, boolean missingUser, boolean missingIncident) {
        CommentDTO commentDTO = new CommentDTO();
        if (!missingDescription) {
            commentDTO.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        }
        if (!missingUser) {
            commentDTO.setUser(new UserDTO());
        }
        if (!missingIncident) {
            commentDTO.setIncident(new IncidentDTO());
        }
        return commentDTO;

    }


}

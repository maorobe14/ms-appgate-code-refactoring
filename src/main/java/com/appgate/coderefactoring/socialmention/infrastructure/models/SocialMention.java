package com.appgate.coderefactoring.socialmention.infrastructure.models;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static com.appgate.coderefactoring.socialmention.commons.constants.SocialNetworkConstants.ValidationMessage.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialMention {
    @NotNull(message = MESSAGE_NULL)
    private String message;
    private String facebookAccount;
    private String tweeterAccount;
    @NotNull(message = DATE_NULL)
    @PastOrPresent(message = PAST_OR_PRESENT_VALIDATION)
    private LocalDate creationDate;
    private String tweeterUrl;
    private List<String> facebookComments;

    @AssertTrue(message = ONE_ACCOUNT_VALIDATION)
    public boolean isAtLeastOneAccountProvided() {
        return (facebookAccount != null && !facebookAccount.trim().isEmpty()) ||
                (tweeterAccount != null && !tweeterAccount.trim().isEmpty());
    }

    @AssertTrue(message = ONE_DATA_VALIDATION)
    public boolean isSocialDataValid() {
        return (facebookComments != null && !facebookComments.isEmpty()) || (tweeterUrl != null && !tweeterUrl.isEmpty());
    }

    @AssertTrue(message = IS_FACEBOOK_VALID)
    public boolean isFacebookValid() {
        if (facebookAccount != null && !facebookAccount.isEmpty()) {
            return facebookComments != null && !facebookComments.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = IS_TWIITER_VALID)
    public boolean isTwitterValid() {
        if (tweeterAccount != null && !tweeterAccount.isEmpty()) {
            return tweeterUrl != null && !tweeterUrl.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = IS_MUTUAL_EXCLUSION_VALID)
    public boolean isMutualExclusionValid() {
        boolean isFacebookPresent = (facebookAccount != null && !facebookAccount.isEmpty()) && (facebookComments != null && !facebookComments.isEmpty());
        boolean isTwitterPresent = (tweeterAccount != null && !tweeterAccount.isEmpty()) && (tweeterUrl != null && !tweeterUrl.isEmpty());
        return !(isFacebookPresent && isTwitterPresent);
    }
}

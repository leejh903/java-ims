package codesquad.domain.issue;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.validation.constraints.Size;
import java.util.Objects;

@Embeddable
public class IssueBody {

    @Size(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String subject;

    @Size(min = 5)
    @Lob
    private String comment;

    public IssueBody() {
    }

    private IssueBody(String subject, String comment) {
        this.subject = subject;
        this.comment = comment;
    }

    public static IssueBody of(String subject, String comment) {
        return new IssueBody(subject, comment);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueBody issueBody = (IssueBody) o;
        return Objects.equals(subject, issueBody.subject) &&
                Objects.equals(comment, issueBody.comment);
    }

    @Override
    public String toString() {
        return "IssueBody [subject=" + subject + ", comment=" + comment + "]";
    }
}

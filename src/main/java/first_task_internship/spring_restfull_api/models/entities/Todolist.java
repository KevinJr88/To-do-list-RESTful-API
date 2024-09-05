package first_task_internship.spring_restfull_api.models.entities;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;


@Getter
@Entity
@Table(name="tbl_todolist")
@Where(clause = "is_deleted = false")


public class Todolist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String task;

    @Column
    private String note;

    @Column
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    private Boolean isDeleted = false;

    public Todolist() {
    }

    public Todolist(Date updated_at, Date created_at, String status, String note, String task, Long id) {
        this.updatedAt = updated_at;
        this.createdAt = created_at;
        this.status = status;
        this.note = note;
        this.task = task;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


}

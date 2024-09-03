package first_task_internship.spring_restfull_api.models.entities;

public class TodolistRequest {
    private String task;
    private String note;
    private String status;

    public TodolistRequest() {
    }

    public TodolistRequest(String note, String status, String task) {
        this.note = note;
        this.status = status;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package models;

/**
 * Task object
 */
public class Task {

    private Long id;
    private Long order;
    private Long priority;
    private String content;


    public Task withOrder(Long order) {
        this.order = order;
        return this;
    }

    public Task withContent(String content) {
        this.content = content;
        return this;
    }

    public Task withPriority(Long priority) {
        this.priority = priority;
        return this;
    }


    public Long getId() {
        return id;
    }

    public Long getOrder() {
        return order;
    }

    public Long getPriority() {
        return priority;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", order=" + order +
                ", priority=" + priority +
                ", content='" + content + '\'' +
                '}';
    }
}



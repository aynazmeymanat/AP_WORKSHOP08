import java.util.Date;

public class Note {
    private String name;
    private String content;
    private Date creationDate;

    public Note(String name, String content) {
        this.name = name;
        this.content = content;
        this.creationDate = new Date();
    }
}

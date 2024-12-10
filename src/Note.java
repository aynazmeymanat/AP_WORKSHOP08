import java.text.SimpleDateFormat;
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

    public String getName() {
        return name  ;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Name: " + name + ", Date: " + sdf.format(creationDate);
    }
}

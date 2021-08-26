package modelo;
import java.util.ArrayList;
import java.util.Date;

public class Publicacion {

    private int idPost;
    private String content;
    private String typePost;
    private Date datePost;
    private String namePublisher;
    private ArrayList<String> users;


    public Publicacion() {
        this.idPost = idPost;
        this.content = content;
        this.typePost = typePost;
        this.datePost = datePost;
        this.namePublisher = namePublisher;
        users = new ArrayList<>();

    }

    @Override
    public String toString() {
        if (typePost == "Share"){
            return "****Publicación Compartida****\n" +
                    "Id Publicación Compartida= " + idPost +"\n" +
                    "Nombre Publicador= " + namePublisher + "\n" +
                    "Contenido= " + content + "\n" +
                    "Tipo de publicación= " + typePost + "\n" +
                    "Fecha de publicación= " + datePost + "\n" +
                    "Usuarios dirigida la publicación: " + users + "\n"
                    ;
        }
        else{
            return "****Publicación****\n" +
                    "Id Publicación= " + idPost +"\n" +
                    "Nombre Publicador= " + namePublisher + "\n" +
                    "Contenido= " + content + "\n" +
                    "Tipo de publicación= " + typePost + "\n" +
                    "Fecha de publicación= " + datePost + "\n" +
                    "Usuarios dirigida la publicación: " + users + "\n"
                    ;
        }

    }



    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypePost() {
        return typePost;
    }

    public void setTypePost(String typePost) {
        this.typePost = typePost;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }




}

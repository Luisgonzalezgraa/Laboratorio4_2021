package modelo;
import java.util.ArrayList;

public class Usuario {

    private Integer idUser;
    private String nameUser;
    private String passwordUser;
    private ArrayList<Publicacion> listPosts;

    public Usuario() {
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        listPosts = new ArrayList<>();
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "****Usuario****\n" +
                "Id Usuario=" + idUser + "\n" +
                "Nombre usuario: " + nameUser + "\n"

                ;
    }

    public ArrayList<Publicacion> getListPosts() {
        return listPosts;
    }

    public void setListPosts(ArrayList<Publicacion> listPosts) {
        this.listPosts = listPosts;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

}

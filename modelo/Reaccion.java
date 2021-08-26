package modelo;
import java.util.Date;

public class Reaccion {

    private int idReac;
    private String nameUser;
    private Date dateReac;
    private String contentReac;
    private String typeReac;

    public Reaccion() {
        this.nameUser = nameUser;
        this.dateReac = dateReac;
        this.contentReac = contentReac;
        this.typeReac = typeReac;
        this.idReac = idReac;
    }

    @Override
    public String toString() {
        return "****Reacción****\n" +
                "Id Reacción=" + idReac + "\n" +
                "Nombre Usuario= " + nameUser + "\n" +
                "Fecha de reacción= " + dateReac + "\n" +
                "Contenido reacción= " + contentReac + "\n" +
                "Tipo de reacción= " + typeReac + "\n"
                ;
    }

    public int getIdReac() {
        return idReac;
    }

    public void setIdReac(int idReac) {
        this.idReac = idReac;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getDateReac() {
        return dateReac;
    }

    public void setDateReac(Date dateReac) {
        this.dateReac = dateReac;
    }

    public String getContentReac() {
        return contentReac;
    }

    public void setContentReac(String contentReac) {
        this.contentReac = contentReac;
    }

    public String getTypeReac() {
        return typeReac;
    }

    public void setTypeReac(String typeReac) {
        this.typeReac = typeReac;
    }




}

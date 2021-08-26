package modelo;
import java.util.ArrayList;

import errores.cantidadDeUsuarios;
import errores.argumentosInvalidos;
import errores.usuarioRegistrado;

public interface InterfazRed {


        void register(String usuario, String contrasenia) throws argumentosInvalidos, usuarioRegistrado;
        boolean login(String usuario,String contrasenia) throws argumentosInvalidos;
        void post(String tipoPublicacion, String publicacion, Integer cantidadUsers,String nombreL2)throws argumentosInvalidos, usuarioRegistrado, cantidadDeUsuarios;
        void follow(String usuario) throws argumentosInvalidos;
        void share(Integer idPost, ArrayList<String> usuariosCom,int cantidadUsuarios) throws argumentosInvalidos;

}

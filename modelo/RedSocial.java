package modelo;



import errores.cantidadDeUsuarios;
import errores.argumentosInvalidos;
import errores.usuarioRegistrado;
import vista.CompartidoValido;
import vista.PublicacionValida;
import vista.SeguimientoValido;
import vista.UsuariosDiri;
import vista.registerValid;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class RedSocial implements InterfazRed {

    //Atributos
    private ArrayList<ArrayList<Usuario>> listausuarios;
    private ArrayList<ArrayList<Publicacion>> listapublicaciones;
    private ArrayList<ArrayList<Reaccion>>listareacciones;
    private String user;

    public ArrayList<ArrayList<Usuario>> getListausuarios() {
        return listausuarios;
    }

    public ArrayList<ArrayList<Publicacion>> getListapublicaciones() {
        return listapublicaciones;
    }

    public ArrayList<ArrayList<Reaccion>> getListareacciones() {
        return listareacciones;
    }

    public String getUser() {
        return user;
    }

    public void setListausuarios(ArrayList<ArrayList<Usuario>> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public void setListapublicaciones(ArrayList<ArrayList<Publicacion>> listapublicaciones) {
        this.listapublicaciones = listapublicaciones;
    }

    public void setListareacciones(ArrayList<ArrayList<Reaccion>> listareacciones) {
        this.listareacciones = listareacciones;
    }

    public void setAutor(String user) {
        this.user = user;
    }

    public RedSocial() {
        listausuarios = new ArrayList<>();
        listapublicaciones = new ArrayList<>();
        listareacciones = new ArrayList<>();
    }

    public void register(String usuario, String contrasenia) throws argumentosInvalidos, usuarioRegistrado  {
        Usuario user2 = new Usuario();
        Usuario usuaAux;
        user2.setNameUser(usuario);
        user2.setPasswordUser(contrasenia);
        user2.setIdUser(listausuarios.size());
        String nombreAux;
        ArrayList<Usuario> lista2Usuarios = new ArrayList<>();

        if (usuario == null || usuario.isBlank()) {
        	throw new argumentosInvalidos("Usuario Invalido");
        } else if (contrasenia == null || contrasenia.isBlank()) {
        	throw new argumentosInvalidos("Contraseña Invalida");
        }

        Integer i = 0;
        Integer key = 0;
        Integer largo = listausuarios.size();
        while (i < largo) {
            Integer j = 0;
            while (j < listausuarios.get(i).size()) {
                usuaAux = listausuarios.get(i).get(j);
                nombreAux = usuaAux.getNameUser();
                if (usuario.equals(nombreAux)) {
                    j = largo + 1;
                    key = 1;
                    throw new usuarioRegistrado(usuario);
                }
                j++;
            }
            i++;


        }
        if (key == 1){
        	throw new usuarioRegistrado(usuario);
        }
        else{
            if (i.intValue() == largo.intValue()) {
                lista2Usuarios.add(user2);
                listausuarios.add(lista2Usuarios);
                new registerValid().setVisible(true);
            }
        }



    }

    public boolean login(String usuario,String contrasenia)throws argumentosInvalidos{

        Integer i  = 0;
        while(i<listausuarios.size()) {
            Integer j = 0;
            while (j < listausuarios.get(i).size()) {
                if (usuario.equals(listausuarios.get(i).get(j).getNameUser()) && contrasenia.equals(listausuarios.get(i).get(j).getPasswordUser())) {

                    return true;
                } else {
                    j++;
                }
            }
            i ++;
        }

        if(i == listausuarios.size()) {

        	throw new argumentosInvalidos("Usuario Invalido");
        }

    return true;
    }

    public void post(String tipoPublicacion, String publicacion, Integer cantidadUsuarios,String nombreL2)throws argumentosInvalidos, usuarioRegistrado, cantidadDeUsuarios{
        Date fecha = new Date();
        Publicacion publicacion1 = new Publicacion();
        publicacion1.setNamePublisher(user);
        publicacion1.setTypePost(tipoPublicacion);
        publicacion1.setDatePost(fecha);
        publicacion1.setContent(publicacion);
        publicacion1.setIdPost(listapublicaciones.size());
        ArrayList<Publicacion> lista2Publicaciones = new ArrayList<>();
       
        if(cantidadUsuarios <= listausuarios.size()) {
            Integer i = 0;
            Integer key = 0;
            
            while (i < cantidadUsuarios) {
            	
                key = 0;
             
               
                Integer j = 0;
                while (j < listausuarios.size()) {
                    Integer k = 0;
                    while (k < listausuarios.get(i).size()) {
                        if (nombreL2.equals(listausuarios.get(j).get(k).getNameUser())) {
                            publicacion1.getUsers().add(nombreL2);
                            k++;
                            key = 1;
                            break;

                        } else {
                            k++;
                        }
                    }
                    j++;

                    if (key == 1){
                        break;
                    }
                    if (j == listausuarios.size()) {
              
                        key = 2;
                        break;
                    }
                }

                i++;
                
                
            } 

            if (key == 2){
            	throw new argumentosInvalidos("Usuario Invalido");
            }

            else{
                lista2Publicaciones.add(publicacion1);
                listapublicaciones.add(lista2Publicaciones);
                Integer aux = 0;
                while (aux < listausuarios.size()){
                    Integer aux2 = 0;
                    while (aux2 < listausuarios.get(aux).size()) {
                        if (user.equals(listausuarios.get(aux).get(aux2).getNameUser())) {
                            listausuarios.get(aux).get(aux2).getListPosts().add(publicacion1);
                            break;
                        } else {
                            aux2++;
                        }
                    }
                    aux ++;

                }
                new PublicacionValida().setVisible(true);
            }
        }
        



    }

    public void follow (String usuario)throws argumentosInvalidos{
        Date fecha = new Date();
        Reaccion reaccion = new Reaccion();
        reaccion.setDateReac(fecha);
        reaccion.setNameUser(user);
        reaccion.setIdReac(listareacciones.size());
        reaccion.setTypeReac("Follow");
        ArrayList<Reaccion> listaDeReacciones = new ArrayList<>();
        if(user.equals(usuario)){
        	throw new argumentosInvalidos("!!!ERROR NO SE PUEDE SEGUIR A USTED MISMO!!!");
        }
        else {
            Integer i = 0 ;
            Integer key = 0;
            while(i<listausuarios.size()){
                Integer j = 0;
                while (j<listausuarios.get(i).size()){
                    if (usuario.equals(listausuarios.get(i).get(j).getNameUser())){
                        reaccion.setContentReac(user + " sigue a "+ usuario);
                        listaDeReacciones.add(reaccion);
                        listareacciones.add(listaDeReacciones);
                        new SeguimientoValido().setVisible(true);
                        key = 1;
                        break;
                    }
                    else {
                        j++;
                    }
                }
                if (key == 1){
                    break;
                }
                i++;
                if (i == listausuarios.size()) {
                    key = 2;
                    break;
                }

            }
            if (key == 2){
            	throw new argumentosInvalidos("Usuario no existe dentro de la red social");
            }
        }

    }
    public void share(Integer idPost,ArrayList<String> usuariosCom,int cantidadUsuarios) throws argumentosInvalidos{
        Date fecha = new Date();
        Publicacion compartido = new Publicacion();
        compartido.setNamePublisher(user);
        compartido.setTypePost("Share");
        compartido.setDatePost(fecha);
        ArrayList<String> listaVacia = new ArrayList<>();
        ArrayList<Publicacion> listaDeCompartidos= new ArrayList<>();
        Integer key = 0;
        Integer i = 0;
        while (i < listapublicaciones.size()){
            Integer j = 0;
            while (j<(listapublicaciones.get(i).size())){
                if (idPost.equals(listapublicaciones.get(i).get(j).getIdPost())){
                    if (cantidadUsuarios == 0){
                        compartido.setUsers(listaVacia);
                    }
                    else {
                        compartido.setUsers(usuariosCom);
                    }
                    compartido.setIdPost(listapublicaciones.size());
                    compartido.setContent(listapublicaciones.get(i).get(j).getContent());
                    listaDeCompartidos.add(compartido);
                    listapublicaciones.add(listaDeCompartidos);
                    key = 1;
                    break;

                }
                else {
                    j++;
                }

            }
            if (key == 1){
                break;
            }
            i ++;
            if (i == listapublicaciones.size()) {
                key = 2;
                break;
            }

        }
       
    }
    
    public boolean existeId(Integer id) throws argumentosInvalidos {
    	Integer i = 0;
    	Integer key = 0;
    	 while (i < listapublicaciones.size()){
    		 Integer j = 0;
    		 while(j < listapublicaciones.get(i).size()) {
    			 if(id.equals(listapublicaciones.get(i).get(j).getIdPost())) {
    				 key = 1;
        			 return true;
        		 }
    			 else {
    				 j ++;
    			 }
    		 }
    		 if (key == 1){
                 break;
             }
    		 i ++; 
    		 if(i == listapublicaciones.size()) {
    			 key = 2;
    			 break;
    		 }
    		
    	 }
    	 if (key == 2) {
    		 throw new argumentosInvalidos("!!! NO EXISTE ID ASOCIADA A LA PUBLICACIÓN!!!");
    	 }
		return false;
    	 
    }
    public boolean existeCantidadU(Integer cantidadU) throws argumentosInvalidos, cantidadDeUsuarios {
    		if(cantidadU < listausuarios.size()) {
    			return true;
    		}
    		else {
                throw new cantidadDeUsuarios();
            }		
    	 
    }
    public boolean existeUsuario(String name) throws argumentosInvalidos {
    	Integer i = 0;
    	Integer key = 0;
    	 while (i < listausuarios.size()){
    		 Integer j = 0;
    		 while(j < listausuarios.get(i).size()) {
    			 if(name.equals(listausuarios.get(i).get(j).getNameUser())) {
    				 key = 1;
        			 return true;
        		 }
    			 else {
    				 j ++;
    				 
    			 }
    		 }
    		 if (key == 1){
                 break;
             }
    		i ++; 
    		if(i == listapublicaciones.size()) {
   			 key = 2;
   			 break;
   		 	}
    	 }
    	 if (key == 2) {
    		 throw new argumentosInvalidos("!!! NO EXISTE USUARIO DENTRO DE LA RED!!!");
    	 }
		return false;
    	 
    } 
    

}


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfesoresEstudiantes {
       ArrayList<String> listaProfesores;
       ArrayList<String> listaEstudiantes;
       ArrayList<ArrayList<String>> listaGeneralEstudiantes;
       
       
       public ProfesoresEstudiantes() {
    	   listaProfesores=new ArrayList<>();
    	   listaGeneralEstudiantes=new ArrayList<>();
       }
       
       public void iniciar() {
    	   int opcionMenu;
    	   do {
    	   opcionMenu= mostrarMenu();
    	
    	   
    	   switch (opcionMenu) {
    	    	 case 1:
    	    		 registrarProfesores();
    	    		 break;
    	    	 case 2:
    	    		 registrarEstudiantes();
    	    		 break;
    	    	 case 3:
    	    	 consultarListaProfesoresYEstudiante();
    	    	 break;
    	    	 case 4 :
    	    		 consultarProfesorPorNombre();
    	    		 break;
    	    	 case 5: 
    	    		 consultarCantidadEstudiantesPorProfesor();
    	    		 break;
    	    	 case 6:
    	    		 consultarEstudiante();
    	    		 break;
    	    		 
    	    	 case 0:
    	    		 JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                     break;
                 default:
                     JOptionPane.showMessageDialog(null, "Opción no válida, por favor ingrese nuevamente.");
                     break;
             }
    	   }   while (opcionMenu !=0);
    	   }
       
    	    private int mostrarMenu() {
    	    	String menu = "MENU\n\n";
    	    	menu+= "1. Registrar Profesor\n";
    	    	menu+= "2. Registrar estudiantes asociados al profesor\n";
    	    	menu+= "3. Consultar lista total de profesores y sus estudiantes asociados\n";
    	    	menu+= "4. Consultar un profesor e imprimir la lista de estudiantes asociados\n";
    	    	menu+= "5. Consultar un profesor e indicar la cantidad de estudiantes asociados\n";
    	        menu+= "6. Consultar un estudiante e indicar cual es su director de grupo\n";
    	        menu+= "0. Salir\n";
    	        menu+= "ingrese su opcion\n";
    	     String opcionSaltar = JOptionPane.showInputDialog(menu);
    	     return Integer.parseInt(opcionSaltar);
    	  
       }
       
       
       private void registrarProfesores() {
    	   System.out.println("\n<<<< Registro de Profesores >>>>");
    	   int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de profesores"));
    	   
    	   for (int i = 0; i< cant; i++) {
    		   String nombreProfesor=JOptionPane.showInputDialog("nombre profesor"+ (i+1));
    		   listaProfesores.add(nombreProfesor);
    		   }
    	   System.out.println("Registro de profesores Exitoso!\n");
       }
       
      private void registrarEstudiantes() {
   	   System.out.println("\n<<<< Registro de Estudiantes >>>>");
        
   	   for (int i=0; i < listaProfesores.size(); i++) {
   	         JOptionPane.showConfirmDialog(null, "Ingrese los estudiantes"+ "para el profesor"+listaProfesores.get(i));
   	       
   	          listaEstudiantes=new ArrayList<String>();
   	       
   	          int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
   	          for (int j=0; j<cant; j++) {
   	    	   String nombreEst=JOptionPane.showInputDialog("nombre estudiante"+ (j+1));
   	    	   listaEstudiantes.add(nombreEst);
   	       }
   	           listaGeneralEstudiantes.add(listaEstudiantes);
      }
          System.out.println("Registro de estudiantes Exitoso!\n");
} 
       private void consultarListaProfesoresYEstudiante() {
       	   System.out.println("\n<<<< Registro de Profesores y Estudiantes >>>>");
          
       	   ArrayList<String> listaTemporal;
            
            for(int i=0; i< listaGeneralEstudiantes.size(); i++) {
            	listaTemporal=listaGeneralEstudiantes.get(i);
            	System.out.print("Profesor:"+ listaProfesores.get(i)+" - ");
            	System.out.print("[");
            	
            	for (int j=0; j< listaTemporal.size(); j++) {
            	System.out.print(listaTemporal.get(j));
            	System.out.print(",");
            	}
            	System.out.print("]\n");
            }
       }
       private void consultarProfesorPorNombre() {
       	   System.out.println("\n<<<< Consulta de Profesores >>>>  \n");
	       String nombre=JOptionPane.showInputDialog("Ingrese elnombre profesor");
	       
	        if(listaProfesores.contains(nombre)) {
	        	int posicion=listaProfesores.indexOf(nombre);
	        	ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
	        	
	        	System.out.print("Profesor: "+nombre+" = ");
	        	System.out.print("[");
	        	
	        	for (int j=0; j< listaEstudiantesTemporal.size();j++) {
	        		System.out.print(listaEstudiantesTemporal.get(j));
	        		if(j< listaEstudiantesTemporal.size()-1) {
	        			System.out.print(",");
	        		}
	        	}
	        		System.out.print("]\n");
	        	}else {
	        		System.out.println("No se encuenta el profesor"+nombre+"\n");
	        			
	        		}
	        	}
       private void consultarCantidadEstudiantesPorProfesor() {
       	   System.out.println("\n<<<< Consulta cantidad de estudiantes por Profesor >>>>  \n");
	       String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber" + "la cantidad de estudiantes asociados");
	       
	        if(listaProfesores.contains(nombre)) {
	        	int posicion=listaProfesores.indexOf(nombre);
	        	ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
	        	
	        	System.out.println("La cantidad de estudiantes asociados al Profesor: "+nombre+""+ " es "+ listaEstudiantesTemporal.size());
	        }else {
	        	System.out.println("No se encuentra el profesor "+nombre+"\n");
	        }
	        }
	        
       private void consultarEstudiante() {
       	   System.out.println("\n<<<< Consultar Estudiante >>>>  \n");
	       ArrayList<String> listaTemporal;
	       
	       String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");

	       for (int i=0; i< listaGeneralEstudiantes.size();i++) {
	    	   listaTemporal=listaGeneralEstudiantes.get(i);
	    	   
	        if(listaTemporal.contains(nombre)) {
	         for(int j=0; j< listaTemporal.size();j++) {
	        	 if (listaTemporal.get(j).equalsIgnoreCase(nombre)) {
	        		 System.out.println("Encuentra al nombre: "+nombre+" pertenece al"+"grupo de"+listaProfesores.get(i));
	        		 
	        	 }
	         }
	             
	        }else {
	        	System.out.println("No se encuentra el nombre en el grupo de "+listaProfesores.get(i));}}}
	      public static void main(String[]args) {
	    	  ProfesoresEstudiantes procesos= new ProfesoresEstudiantes();
	    	  procesos.iniciar();
	      }}
          
  		   
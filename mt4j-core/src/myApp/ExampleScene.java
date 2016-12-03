package myApp;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.font.IFont;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class ExampleScene extends AbstractScene{
    public ExampleScene(MTApplication mtapp){
        super(mtapp, "Example Scene");//Llamamos a super
        this.setClearColor(new MTColor(153,51,255, 255));//Ponemos el color de fondo a violeta
        //Creamos la fuente a utilizar
        IFont font = FontManager.getInstance().createFont(mtapp, "Ubuntu-L.ttf", 20);

        //Creamos un textField inicializandolo con posición, tamaño y fuente
        MTTextField textField = new MTTextField(mtapp,450,10,120,40,font);
        textField.setText("Hello World!");//Establecemos el texto del textField
        this.getCanvas().addChild(textField);//Añadimos el elemento a la app

        //Creamos otro TextField
        MTTextField textField1 = new MTTextField(mtapp,120,60,800,40,font);
        textField1.setText("Por si no os gustaba como era el \"Hello World\" aqui os muestro un texto algo más largo");
        this.getCanvas().addChild(textField1);
        
        //Creamos dos rectángulos, uno rojo y otro azul
        MTRectangle rectangle1 = new MTRectangle(mtapp, 500, 300, 50, 100);//Iniciamos con posición y tamaño
        rectangle1.setFillColor(MTColor.RED);//Rellenamos con un color
        getCanvas().addChild(rectangle1);
        
        MTRectangle rectangle2 = new MTRectangle(mtapp, 100, 350, 100, 40);
        rectangle2.setFillColor(MTColor.BLUE);
        getCanvas().addChild(rectangle2);

        //Creamos una elipse circular pasandole un Vector3D con la posición en la que se encuentra, el radio en el eje X y el radio en el eje Y
        //Para que sea un circulo el radio en los ejes X e Y debe ser el mismo, en este caso 100
        MTEllipse circle = new MTEllipse(mtapp, new Vector3D(500, 400), 100, 100);
        MTColor transparentColour = new MTColor(0, 255, 0, 125);//Creamos un color verde semitransparente para nuestra elipse.
        //La componente alpha dice cuán transparente será, por lo que a mas baja sea esta componente más transparente será, siendo el rango de la componente de 0 a 255
        circle.setFillColor(transparentColour);//Rellenamos el circulo con nuestro color
        getCanvas().addChild(circle);

        //Cambiamos los colores de los bordes de nuestros rectángulos
        rectangle1.setStrokeColor(MTColor.YELLOW);
        rectangle2.setStrokeColor(MTColor.BLACK);
        
        //Para verlo más claramente hacemos que los bordes sean más grandes
        rectangle1.setStrokeWeight(5);
        rectangle2.setStrokeWeight(5);
        
        //Podemos hacer el borde invisible con setNoStroke y quitarle el relleno con setNoFill
        rectangle1.setNoStroke(true);//Eliminamos el borde
        rectangle2.setNoFill(true);//Eliminamos el relleno (color de fondo)
        
        //Añadimos una imagen pasando el ancho, alto y modo de la imagen
        PImage myImage = mtapp.createImage(300, 300, MTApplication.RGB);
        myImage.loadPixels();//Cargamos los píxeles iniciales
        //Manipulamos cada píxel como si fuera un array, inicializandolos con un color aleatorio
        for(int y = 0; y < myImage.height; y++){
        	 for(int x = 0; x < myImage.width; x++){
	        	 int loc = x + y * myImage.width;
	        	 myImage.pixels[loc] = mtapp.color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        	 }
    	}
        myImage.updatePixels();//Actualizamos los píxeles pintados
        MTRectangle imageRectangle = new MTRectangle(mtapp, myImage);//Creamos un rectángulo y lo inicializamos con la imagen
        getCanvas().addChild(imageRectangle);
        
        //Para cargar una imagen desde un arhivo incluimos la imagen dentro de la carpeta data
        PImage loadedImage = mtapp.loadImage("sora.png");//Cargamos la imagen
        loadedImage.resize(500, 500);//Cambiamos el tamaño porque la imagen es demasiado grande para la aplicación
        MTRectangle loadedRectangle = new MTRectangle(mtapp, loadedImage);
        getCanvas().addChild(loadedRectangle);
    }
    @Override
    public void init() {
    }

    @Override
    public void shutDown() {
 
    }
}
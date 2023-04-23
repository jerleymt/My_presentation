/*
Name: Jose Erley Murillo Torres
Email: jose.erley.murillo@correounivalle.edu.co
Creation Date: 14th / 02 / 2023
Modification Date:
 */

package GUIpresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Here I start to build the class that allow me creates windows for my GUI
public class GUIpresentation extends JFrame
{
    private Title title;
    private JPanel buttonsContainer, containerImage,buttonsContainer2,buttonsContainer3;
    private JButton myPhotos,myHobby,myDescription,mas,menos;
    public Listener escucha;
    private JLabel imageLabel;
    private  JTextArea cajadetexto;
    public  int porcentaje;
    public GUIpresentation()
    {

        this.setSize(600,450);
        this.setVisible(true);
        this.setTitle("Jose Erley Murillo (presentation)");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startGUI();
    }
    public void startGUI()
    {
        //_____________________Creacion de objetos_________________________
        //Nuevas etiquetas
        title = new Title("A presentation about me",Color.DARK_GRAY);
        imageLabel = new JLabel();

        //Nuevos escuchadores
        escucha = new Listener();

        //Nuevas paneles
        buttonsContainer = new JPanel();
        buttonsContainer2 = new JPanel();
        buttonsContainer3 = new JPanel();
        containerImage = new JPanel();

        //Nuevos Botones
        myHobby = new JButton("My hobbies");
        myPhotos = new JButton("This is me");
        myDescription = new JButton("What I expect about this course");
        mas = new JButton("ZOOM +");
        menos = new JButton("ZOOM -");

        //Nuevas Areas de texto
        cajadetexto = new JTextArea();

        porcentaje = 50;
        //_____________________Fin de Creacion de objetos_________________________

        //Configurar los contenedores
        //buttonsContainer.setBackground(Color.lightGray);
        containerImage.setSize(300,300);
        containerImage.add(imageLabel);
        containerImage.setBorder(BorderFactory.createTitledBorder(null,"Something about me",
                TitledBorder.LEFT,TitledBorder.DEFAULT_JUSTIFICATION,
                new Font("arial",2,20),Color.darkGray));

        //Agregar escuchas a los botones
        myPhotos.addActionListener(escucha);
        myHobby.addActionListener(escucha);
        myDescription.addActionListener(escucha);
        mas.addActionListener(escucha);
        menos.addActionListener(escucha);

        //Agreagr los botones al contenedor

        buttonsContainer2.add(menos);
        buttonsContainer2.add(mas);

        buttonsContainer3.add(myPhotos);
        buttonsContainer3.add(myHobby);
        buttonsContainer3.add(myDescription);

        buttonsContainer.add(buttonsContainer3,BorderLayout.PAGE_END);

        //Agrgar los contenedores a la ventata (GUI)
        this.add(containerImage, BorderLayout.CENTER);
        this.add(title, BorderLayout.NORTH);
        this.add(buttonsContainer, BorderLayout.SOUTH);

    }
    public void EscalarImagen(ImageIcon image, int escala){
        /*
         * Primero: llamo al metodo configurar icono de la etiquta que contiene la imagen
         * Segundo: Dentro del argumento del metodo "setIcon" creo un nuevo objeto del tipo "ImageIcon"
         * Tercero: Dentrod del argumento del objeto "ImageIcon" llamo un objet de tipo "ImagenIcon"
         *          que contenga la ruta de la imagen mas el metodo que me permite obtener esa imagen
         *          mas elmetodo que me permite escalar esa imagen
         * Cuarto:  Dentro de los argumentos de "getScaledInsatce" ponemos el ancho, la altura
         *          y el "Image.SCALE_SMOOTH"
         * */

        int alto =  (image.getIconHeight() * escala) / 100;
        int ancho =   (image.getIconWidth() * escala) / 100;

        imageLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));

    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override public void run()
            {
                GUIpresentation MyGUI = new GUIpresentation();

            }
        });
    }
    private class Listener implements ActionListener{
        private ImageIcon  image;
            @Override
            public void actionPerformed(ActionEvent e) {

                imageLabel.setIcon(null);
                containerImage.remove(cajadetexto);
                if (e.getSource() == myPhotos)
                {
                    porcentaje = 30;
                    this.image = new ImageIcon(getClass().getResource("/Recurse/foto.png"));
                    EscalarImagen(image, porcentaje);
                    title.setText("This is me");
                    //buttonsContainer.add(buttonsContainer2,BorderLayout.SOUTH);
                }
                else if (e.getSource() == myHobby)
                {
                    //JOptionPane.showMessageDialog(null,"That I like me");
                    porcentaje = 30;
                    this.image = new ImageIcon(getClass().getResource("/Recurse/hobbies.png"));
                    EscalarImagen(image, porcentaje);
                    title.setText("These are my hobbies");
                    //buttonsContainer.add(buttonsContainer2,BorderLayout.SOUTH);
                }

                else if (e.getSource() == mas )
                {
                    porcentaje = porcentaje + 1;
                    imageLabel.setIcon(image);
                    EscalarImagen(image, porcentaje);
                    //this.image = new ImageIcon(image.getImage());
                    //JOptionPane.showMessageDialog(null,"Se amplio la  imagen");
                }
                else if (e.getSource() == menos)
                {
                    porcentaje = porcentaje - 1;
                    imageLabel.setIcon(image);
                    EscalarImagen(image, porcentaje);
                    //this.image = new ImageIcon(image.getImage());
                    //JOptionPane.showMessageDialog(null,"Se redujo la imagen");
                }
                else
                {
                    buttonsContainer.remove(buttonsContainer2);
                    cajadetexto.setText("There are several things I expect from this course\n" +
                            "The first is to learn all I need to be a better programmer\n" +
                            "The second is to improve those skills that I had learned in previous courses\n" +
                            "Last and most important, pass the course. \n");
                    cajadetexto.setBackground(null);
                    title.setText("My expectation");
                    containerImage.add(cajadetexto);
                }
                revalidate();
                repaint();
            }
    }
}


package GUIpresentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escucha {
    private Title title;
    private JPanel buttonsContainer, containerImage;
    private JButton myPhotos,myHobby,myDescription,mas,menos;
    private GUIpresentation EscalarImagen;
    private JLabel imageLabel;
    private  JTextArea cajadetexto;
    public  int porcentaje;

    public Escucha(){
        Listener escucha = new Listener();
    }

    private class Listener implements ActionListener {
        private ImageIcon  image;
        @Override
        public void actionPerformed(ActionEvent e) {

            imageLabel.setIcon(null);
            containerImage.remove(cajadetexto);
            if (e.getSource() == myPhotos){
                //JOptionPane.showMessageDialog(null,"About me");
                this.image = new ImageIcon(getClass().getResource("/Recurse/photo.png"));
                EscalarImagen.EscalarImagen(image,porcentaje);
                title.setText("My photo");
            }
            else if (e.getSource() == myHobby)
            {
                //JOptionPane.showMessageDialog(null,"That I like me");
                this.image = new ImageIcon(getClass().getResource("/Recurse/hobby.jpg"));
                EscalarImagen.EscalarImagen(image,porcentaje);
                title.setText("My Hobby");
            }
            else if (e.getSource() == mas)
            {
                porcentaje = porcentaje + 10;

            }
            else if (e.getSource() == menos)
            {
                porcentaje = porcentaje - 10;
                //JOptionPane.showMessageDialog(null,"-");
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"That I like me");
                cajadetexto.setText("I expected to learn all needed for me");
                cajadetexto.setBackground(null);
                containerImage.add(cajadetexto);
                title.setText("Presentation about me");
            }
            //revalidate();
            //repaint();

        }
    }


}

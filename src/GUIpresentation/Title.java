/*
Name: Jose Erley Murillo Torres
Email: jose.erley.murillo@correounivalle.edu.co
Creation Date: 14th / 02 / 2023
Modification Date:
 */

package GUIpresentation;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

/**
 * This class allows build titles
 * */
public class Title extends JLabel
{
    /**
     * Constructor method,
     * This method get the text that will be showed and the color of the background
     * */
    public Title(String my_title, Color my_backgroun_Color)
    {
        //Set the text of title (wait a string argument)*/
        this.setText(my_title);
        //Set the background color of text (wait an object Color type)*/
        this.setBackground(my_backgroun_Color);
        //Set the color of the text (wait an object Color type)*/
        this.setForeground(Color.white);
        //Set the font of the*/
        this.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,25));
        //Set the alignment of the text*/
        this.setHorizontalAlignment(JLabel.CENTER);
        //Set if the background color of the text can be changed*/
        this.setOpaque(true);
    }
}


package gameproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class map {
     public int m[][];
     public int width;
    public int height;
    public map(int r,int c)
    {
        m=new int[r][c];
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
            {
                m[i][j]=1;
            }
        }
        width=540/c;
        height=150/r;
    }
    public void draw(Graphics2D g){
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
            {
                if(m[i][j]>0){
                g.setColor(Color.white);
                g.fillRect(j*width+80, i*height+50, width, height);
                
                g.setStroke(new BasicStroke(3));
                g.setColor(Color.black);
                g.drawRect(j*width+80, i*height+50, width, height);
            }
            }
        }

    }
    public void setBrickValue(int value, int r,int c)
    {
        m[r][c]=value;
    }
}

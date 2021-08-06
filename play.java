
package gameproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class play extends JPanel implements KeyListener, ActionListener{
    private boolean play=true;
    private int score=0;
    private int allbricks=24;
    private Timer timer;
    private int delay=6;
    private int playerX=310;
    private int ballpX=120;
    private int ballpY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;
    private map mapg;
    
    public play()
    {
        mapg =new map(4,6);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
       timer.start();
        
        
    }
    @Override
    public void paint(Graphics g)
    {
        //color backgrnd
        g.setColor(Color.darkGray);
        g.fillRect(1, 1, 692, 592);
        
        //drawing map
       mapg.draw((Graphics2D)g);
        
        //borders
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692,3);
         g.fillRect(691, 0, 3,592);
         
         //..scores
         g.setColor(Color.white);
         g.setFont(new Font("serif",Font.BOLD,25));
         g.drawString(""+score, 590, 30);
         
         //padlde
         g.setColor(Color.yellow);
         g.fillRect(playerX, 550, 100,12);
         
         //ball
         g.setColor(Color.yellow);
         g.fillOval(ballpX, ballpY, 20, 20);
     
         if(allbricks<=0)
         {
             play=false;
             ballXdir=0;
             ballYdir=0;
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD,30));
             g.drawString("You Won!", 260, 300);
             g.setFont(new Font("serif",Font.BOLD,30));
             g.drawString("Press Enter to restart", 225, 350);
         }
         
         if(ballpY>570)
         {
             play=false;
             ballXdir=0;
             ballYdir=0;
             g.setColor(Color.ORANGE);
             g.setFont(new Font("serif",Font.BOLD,30));
             g.drawString("Game Over, Score:"+score, 190, 300);
             g.setFont(new Font("serif",Font.BOLD,30));
             g.drawString("Press Enter to restart", 230, 350);
         }
             g.dispose();
         
    }

      public void actionPerformed(ActionEvent e)
      {
          timer.start();
          //repaint();
          if(play)
          {
              if(new Rectangle(ballpX,ballpY,20,20).intersects(new Rectangle(playerX,550,100,8)))
              {
                  ballYdir=-ballYdir;
              }
              A: for(int i=0;i<mapg.m.length; i++)
              {
                  for(int j=0; j<mapg.m[0].length; j++)
                  {
                      if(mapg.m[i][j]>0)
                      {
                          int brickX=j*mapg.width+80;
                          int brickY=i*mapg.height+50;
                          int brickwidth=mapg.width;
                          int brickheight=mapg.height;
                          Rectangle rect= new Rectangle(brickX,brickY,brickwidth,brickheight);
                          Rectangle ballRect= new Rectangle(ballpX,ballpY,20,20);
                          Rectangle brickRect=rect;
                          if(ballRect.intersects(brickRect))
                          {
                              mapg.setBrickValue(0, i, j);
                              allbricks--;
                              score+=5;
                              
                              if(ballpX+19<=brickRect.x||ballpX+1>= brickRect.x+ brickRect.width)
                              {
                                  ballXdir=-ballXdir;
                              }
                              else{
                                  ballYdir=-ballYdir;
                              }
                         break A;
                      }
                  }
                      
              }
              
          }
              ballpX+=ballXdir;
              ballpY+=ballYdir;
              if(ballpX<0)
              {
                  ballXdir=-ballXdir;
              }
              if(ballpY<0)
              {
                  ballYdir=-ballYdir;
              }
              if(ballpX>670)
              {
                  ballXdir=-ballXdir;
              }
          
          repaint();
          
      }
      }
    
    public void keyTyped(KeyEvent e) {}
 public void keyReleased(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
        if(e.getKeyCode() ==KeyEvent.VK_RIGHT)
        {
            if(playerX>=600){
                playerX=600;
        }
        else{
            moveRight();
        }
        }
    
    if(e.getKeyCode()== KeyEvent.VK_LEFT)
    {
        if(playerX<10){
            playerX=10;
    }
    else{
    moveLeft();
         } 
       }
    if(e.getKeyCode()==KeyEvent.VK_ENTER)
    {
        if(!play)
        {
            play=true;
            ballpX=120;
            ballpY=350;
            ballXdir=-1;
            ballYdir=-2;
            playerX=310;
            score=0;
            allbricks=21;
            mapg=new map(4,6);
            repaint();
            
        }
        
    }
    }
    public void moveRight()
    {
        play=true;
        playerX+=20;
    }
        public void moveLeft()
    {
        play=true;
        playerX-=20;
    }
   
}

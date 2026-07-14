package entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up_dante_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up_dante_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/up_dante_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/up_dante_4.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_dante_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_dante_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_dante_3.png"));
            down4= ImageIO.read(getClass().getResourceAsStream("/res/player/down_dante_4.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_dante_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_dante_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_dante_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_dante_4.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_dante_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_dante_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_dante_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_dante_4.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }else if(keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }else if(keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        ///g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        if(image != null){
        // Scale image proportionally to fit within tile size
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        
        // Calculate scale to fit within tile while maintaining aspect ratio
        double scaleX = (double) gp.tileSize / imgWidth;
        double scaleY = (double) gp.tileSize / imgHeight;
        double scale = Math.min(scaleX, scaleY)*1.5;
        
        int scaledWidth = (int) (imgWidth * scale);
        int scaledHeight = (int) (imgHeight * scale);
        
        // Center sprite in tile
        int drawX = x + (gp.tileSize - scaledWidth) / 2;
        int drawY = y + (gp.tileSize - scaledHeight) / 2;
        
        java.awt.Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, java.awt.Image.SCALE_SMOOTH);
        g2.drawImage(scaledImage, drawX, drawY, null);
    }
        
    }
}

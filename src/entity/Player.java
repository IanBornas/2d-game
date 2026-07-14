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

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            
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

        spriteCounter++;

        if (spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }else if(spriteNum == 2){
                spriteNum = 3;
            }else if(spriteNum == 3){
                spriteNum = 4;
            }else if(spriteNum == 4){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }


    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        ///g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum ==1){
                    image = up1;
                }
                if(spriteNum ==2){
                    image = up2;
                }
                if(spriteNum ==3){
                    image = up3;
                }
                if(spriteNum ==4){
                    image = up4;
                }
                break;
            case "down":
                if(spriteNum ==1){
                image = down1;
                }
                if(spriteNum ==2){
                image = down2;
                }
                if(spriteNum ==3){
                image = down3;
                }
                if(spriteNum ==4){
                image = down4;
                }
                break;
            case "left":
                if(spriteNum ==1){
                image = left1;
                }
                if(spriteNum ==2){
                image = left2;
                }
                if(spriteNum ==3){
                image = left3;
                }
                if(spriteNum ==4){
                image = left4;
                }
                break;
            case "right":
                if(spriteNum ==1){
                image = right1;
                }
                if(spriteNum ==2){
                image = right2;
                }
                if(spriteNum ==3){
                image = right3;
                }
                if(spriteNum ==4){
                image = right4;
                }
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

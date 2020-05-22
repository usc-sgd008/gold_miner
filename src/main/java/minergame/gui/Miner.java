package minergame.gui;



import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Miner extends RunGame {
    private static final double W = 600, H = 400;

    private static final String HERO_IMAGE_LOC = ("minergame/gui/Miner.PNG");
    private Image minerImage;
    private Node miner;

    boolean running, goNorth, goSouth, goEast, goWest;


    public Miner() {
        minerImage = new Image(HERO_IMAGE_LOC);
        miner = new ImageView(minerImage);



        moveHeroTo(W / 2, H / 2);




        miner.setOnKeyPressed(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goNorth = true;
                        System.out.println("Miner created");
                        break;
                    case DOWN:
                        goSouth = true;
                        break;
                    case LEFT:
                        goWest = true;
                        break;
                    case RIGHT:
                        goEast = true;
                        break;
                    case SHIFT:
                        running = true;
                        break;
                }
            }
        });

        miner.setOnKeyReleased(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goNorth = false;
                        break;
                    case DOWN:
                        goSouth = false;
                        break;
                    case LEFT:
                        goWest = false;
                        break;
                    case RIGHT:
                        goEast = false;
                        break;
                    case SHIFT:
                        running = false;
                        break;
                }
            }
        });



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) dy -= 32;
                if (goSouth) dy += 1;
                if (goEast) dx += 1;
                if (goWest) dx -= 1;
                if (running) {
                    dx *= 3;
                    dy *= 3;
                }

                moveMinerBy(dx, dy);
            }
        };
        timer.start();
    }

    private void moveMinerBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = miner.getBoundsInLocal().getWidth() / 2;
        final double cy = miner.getBoundsInLocal().getHeight() / 2;

        double x = cx + miner.getLayoutX() + dx;
        double y = cy + miner.getLayoutY() + dy;

        moveHeroTo(x, y);
    }

    private void moveHeroTo(double x, double y) {
        final double cx = miner.getBoundsInLocal().getWidth() / 2;
        final double cy = miner.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= W &&
                y - cy >= 0 &&
                y + cy <= H) {
            miner.relocate(x - cx, y - cy);
        }

    }


}

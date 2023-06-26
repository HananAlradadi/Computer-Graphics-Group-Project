/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgmproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class CGMProject extends Application {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        Box background = Background();
        Cylinder[] cylinder = cylinder();
        Sphere[] sph = app();
        Group group = new Group();
        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        group.getChildren().addAll(background);
        //
        Sphere[] spheres = spheres();
        Box[] boxs = boxs();
        Line[] lines = Lines();
        Rectangle[] R = R();
        Text[] T = T();
        Group group4 = new Group(T);
        //التفاحات
        for (int i = 0; i < sph.length; i++) {
            group1.getChildren().add(sph[i]);
        }
        //البحيرة
        for (int i = 0; i < cylinder.length; i++) {
            group2.getChildren().add(cylinder[i]);
        }
        //منطاد
        for (int i = 0; i < spheres.length; i++) {
            group3.getChildren().add(spheres[i]);
        }
        //بوكس المنطاد 
        for (int i = 0; i < boxs.length; i++) {
            group3.getChildren().add(boxs[i]);
        }
        //lines
        for (int i = 0; i < lines.length; i++) {
            group3.getChildren().add(lines[i]);
        }
        //Rectangle
        for (int i = 0; i < R.length; i++) {
            group3.getChildren().add(R[i]);
        }
        
        AmbientLight ambLight1 = new AmbientLight(Color.WHITE);
        PointLight pLight = new PointLight(Color.WHITE);
        pLight.getTransforms().add(new Translate(200, 150, -50));
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case UP:
                    group1.setTranslateY(group1.getLayoutY());// apple event
                    break;
                case DOWN:
                    group1.setTranslateY(group1.getTranslateY() + 130);// apple event
                    break;
                case RIGHT:
                    group2.setTranslateX(group2.getTranslateX() + 130);// grass event
                    break;
                case LEFT:
                    group2.setTranslateX(group2.getTranslateX() - 130);// grass event
                //lighting color
                case W:
                    pLight.setColor(Color.WHITE);
                    break;
                case G:
                    pLight.setColor(Color.GREEN);
                    break;
                case B:
                    pLight.setColor(Color.BLUE);
                    break;
                case Y:
                    pLight.setColor(Color.YELLOW);
                    break;
                case R:
                    group1.setTranslateX(group1.getLayoutX());
                    group1.setTranslateY(group1.getLayoutY());
                    group2.setTranslateX(group1.getLayoutX());
                    group2.setTranslateY(group1.getLayoutY());
            }
        });
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                pLight.setLightOn(!pLight.isLightOn());
            } else if (event.getButton() == MouseButton.SECONDARY) {
                ambLight1.setLightOn(!ambLight1.isLightOn());
            }
        });
        //
        group2.getChildren().addAll(ambLight1, pLight);
        group3.getChildren().addAll(ambLight1, pLight);
        group.getChildren().addAll(group1, group2, group3, group4);
        //
        Scene scene = new Scene(group, WIDTH, HEIGHT, true);
        primaryStage.setTitle("! Mini Project !");
        primaryStage.setScene(scene);
        primaryStage.show();
        //
        PerspectiveCamera camera1 = new PerspectiveCamera();
        scene.setCamera(camera1);
        primaryStage.setScene(scene);  //Adding scene to the stage 
        primaryStage.show();   //Displaying the contents of the stage 

    }
    public Sphere[] spheres() {
        Sphere sp = new Sphere(40, 250);
        sp.setTranslateX(390.0);
        sp.setTranslateY(137.0);
        sp.setTranslateZ(-50.0);
        Image im1 = new Image("https://i.pinimg.com/736x/40/61/e2/4061e284933aefb77552e363f8d01648.jpg");
        PhongMaterial mat1 = new PhongMaterial();
        mat1.setDiffuseMap(im1);
        sp.setMaterial(mat1);
        //<<..............
        Sphere sp1 = new Sphere(40, 250);
        sp1.setTranslateX(231.0);
        sp1.setTranslateY(310.0);
        sp1.setTranslateZ(-50.0);
        Image im2 = new Image("https://st2.depositphotos.com/3894705/6797/i/950/depositphotos_67972625-stock-photo-pastel-stripes.jpg");
        PhongMaterial mat2 = new PhongMaterial();
        mat2.setDiffuseMap(im2);
        sp1.setMaterial(mat2);
        //<<................
        Sphere sp2 = new Sphere(30, 250);
        sp2.setTranslateX(598.0);
        sp2.setTranslateY(90.0);
        sp2.setTranslateZ(-40.0);
        Image im3 = new Image("https://i.pinimg.com/474x/ec/64/74/ec647465d00bc767e107c8213e8e4d14.jpg");
        PhongMaterial mat3 = new PhongMaterial();
        mat3.setDiffuseMap(im3);
        sp2.setMaterial(mat3);
        Sphere[] spheres = {sp, sp1, sp2};
        return spheres;
    }

    public Box[] boxs() {
        //center
        Box box = new Box(40, 30, 40);
        box.setTranslateX(390.0);
        box.setTranslateY(215.0);
        box.setTranslateZ(-40.0);
        Image im1 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbr_r6PhTX-_jR7sMRL1YkEHaaN3cKUvWF2Qa5fBcWk5gOF55tecvMiT7m3AwT4Enb6LQ&usqp=CAU");
        PhongMaterial mat1 = new PhongMaterial();
        mat1.setDiffuseMap(im1);
        box.setMaterial(mat1);
        //<<......................
        //left
        Box box1 = new Box(40, 30, 40);
        box1.setTranslateX(231.0);
        box1.setTranslateY(400.0);
        box1.setTranslateZ(-40.0);
        Image im2 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbr_r6PhTX-_jR7sMRL1YkEHaaN3cKUvWF2Qa5fBcWk5gOF55tecvMiT7m3AwT4Enb6LQ&usqp=CAU");
        PhongMaterial mat2 = new PhongMaterial();
        mat2.setDiffuseMap(im2);
        box1.setMaterial(mat2);
        //<<.....................
        //right
        Box box2 = new Box(30, 20, 40);
        box2.setTranslateX(597.0);
        box2.setTranslateY(150.0);
        box2.setTranslateZ(-40.0);
        Image im3 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbr_r6PhTX-_jR7sMRL1YkEHaaN3cKUvWF2Qa5fBcWk5gOF55tecvMiT7m3AwT4Enb6LQ&usqp=CAU");
        PhongMaterial mat3 = new PhongMaterial();
        mat3.setDiffuseMap(im3);
        box2.setMaterial(mat3);
        Box[] boxs = {box, box1, box2};
        return boxs;
    }

    public Box Background() {

        Image img1 = new Image("https://image.freepik.com/free-vector/natural-landscape-background-video-conferencing_23-2148652921.jpg");
        PhongMaterial mat = new PhongMaterial();
        mat.setDiffuseMap(img1);
        Box box = new Box(WIDTH, HEIGHT, 100);
        box.setTranslateX(WIDTH / 2);
        box.setTranslateY(HEIGHT / 2);
        box.setTranslateZ(80);
        mat.setDiffuseMap(img1);
        box.setMaterial(mat);
        return box;
    }

    public Line[] Lines() {
        //Center right
        Line l = new Line();
        l.setStrokeWidth(2);
        l.setStartX(410);
        l.setStartY(168);
        l.setEndX(405);
        l.setEndY(206);
        //<<.................
        //Center left 
        Line l1 = new Line();
        l1.setStrokeWidth(2);
        l1.setStartX(375);
        l1.setStartY(169);
        l1.setEndX(379);
        l1.setEndY(206);
        //<<...............
        //above left 
        Line l2 = new Line();
        l2.setStrokeWidth(2);
        l2.setStartX(588);
        l2.setStartY(108);
        l2.setEndX(593);
        l2.setEndY(138);
        //<<............
        //above Right
        Line l3 = new Line();
        l3.setStrokeWidth(2);
        l3.setStartX(625);
        l3.setStartY(104);
        l3.setEndX(618);
        l3.setEndY(136);

        //bottom right
        Line l4 = new Line();
        l4.setStrokeWidth(2);
        l4.setStartX(248);
        l4.setStartY(347);
        l4.setEndX(241);
        l4.setEndY(389);
        //<<...............
        //bottom Left
        Line l5 = new Line();
        l5.setStrokeWidth(2);
        l5.setStartX(208);
        l5.setStartY(347);
        l5.setEndX(212);
        l5.setEndY(389);

        Line[] lines = {l, l1, l2, l3, l4, l5};
        return lines;
    }

    public Rectangle[] R() {
        //center
        Rectangle R = new Rectangle();
        R.setX(375);
        R.setY(175);
        R.setWidth(35);
        R.setHeight(2);
        R.setArcHeight(40);
        R.setArcWidth(20);
        R.setFill(Color.ORANGE);
        //<<................
        //Bottom Left
        Rectangle R1 = new Rectangle();
        R1.setX(208);
        R1.setY(353);
        R1.setWidth(40);
        R1.setHeight(2);
        R1.setArcHeight(40);
        R1.setArcWidth(20);
        R1.setFill(Color.CORNFLOWERBLUE);
        //<<...........................
        Rectangle R2 = new Rectangle();
        R2.setX(588);
        R2.setY(115);
        R2.setWidth(35);
        R2.setHeight(2);
        R2.setArcHeight(40);
        R2.setArcWidth(20);
        R2.setFill(Color.PALEVIOLETRED);
        Rectangle[] Rectangels = {R, R1, R2};
        return Rectangels;

    }

    public Cylinder[] cylinder() {

        Cylinder cylinder1 = new Cylinder(30, 3);
        Image img2 = new Image("https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/78783/lily-pad-clipart-xl.png");
        Rotate rz = new Rotate(18, Rotate.X_AXIS);
        cylinder1.setTranslateX(270);
        cylinder1.setTranslateY(480);
        cylinder1.setTranslateZ(2);
        cylinder1.getTransforms().add(rz);
        PhongMaterial mat1 = new PhongMaterial();
        mat1.setDiffuseMap(img2);
        cylinder1.setMaterial(mat1);

        Cylinder cylinder2 = new Cylinder(30, 3);
        cylinder2.setTranslateX(85);
        cylinder2.setTranslateY(475);
        cylinder2.setTranslateZ(2);
        cylinder2.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder2.setMaterial(mat1);

        Cylinder cylinder3 = new Cylinder(30, 3);
        cylinder3.setTranslateX(220);
        cylinder3.setTranslateY(450);
        cylinder3.setTranslateZ(2);
        cylinder3.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder3.setMaterial(mat1);

        Cylinder cylinder4 = new Cylinder(25, 3);
        cylinder4.setTranslateX(150);
        cylinder4.setTranslateY(500);
        cylinder4.setTranslateZ(2);
        cylinder4.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder4.setMaterial(mat1);

        Cylinder cylinder5 = new Cylinder(20, 3);
        cylinder5.setTranslateX(400);
        cylinder5.setTranslateY(500);
        cylinder5.setTranslateZ(2);
        cylinder5.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder5.setMaterial(mat1);

        Cylinder cylinder6 = new Cylinder(20, 3);
        cylinder6.setTranslateX(230);
        cylinder6.setTranslateY(530);
        cylinder6.setTranslateZ(2);
        cylinder6.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder6.setMaterial(mat1);

        Cylinder cylinder7 = new Cylinder(30, 3);
        cylinder7.setTranslateX(350);
        cylinder7.setTranslateY(450);
        cylinder7.setTranslateZ(2);
        cylinder7.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder7.setMaterial(mat1);

        Cylinder cylinder8 = new Cylinder(20, 3);
        cylinder8.setTranslateX(500);
        cylinder8.setTranslateY(470);
        cylinder8.setTranslateZ(2);
        cylinder8.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder8.setMaterial(mat1);

        Cylinder cylinder9 = new Cylinder(15, 3);
        cylinder9.setTranslateX(420);
        cylinder9.setTranslateY(440);
        cylinder9.setTranslateZ(2);
        cylinder9.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder9.setMaterial(mat1);

        Cylinder cylinder10 = new Cylinder(23, 3);
        cylinder10.setTranslateX(590);
        cylinder10.setTranslateY(450);
        cylinder10.setTranslateZ(2);
        cylinder10.getTransforms().add(rz);
        mat1.setDiffuseMap(img2);
        cylinder10.setMaterial(mat1);

        Cylinder[] cylinders = {cylinder1, cylinder2, cylinder3, cylinder4, cylinder5,
            cylinder6, cylinder7, cylinder8, cylinder9, cylinder10,};

        return cylinders;
    }

    public Sphere[] app() {
        Image img2 = new Image("https://www.i2clipart.com/cliparts/6/3/7/c/clipart-cartoon-apple-512x512-637c.png");
        Sphere sph[] = new Sphere[6];
        PhongMaterial[] mat = new PhongMaterial[6];
        for (int i = 0; i < mat.length; i++) {

            mat[i] = new PhongMaterial();
        }
        sph[1] = new Sphere(15, 20);
        sph[0] = new Sphere(18, 20);
        sph[2] = new Sphere(15, 20);
        sph[3] = new Sphere(12, 20);
        sph[4] = new Sphere(15, 20);
        sph[5] = new Sphere(15, 20);

        sph[0].setTranslateX(110);
        sph[0].setTranslateY((HEIGHT / 2) - 5);
        sph[0].setTranslateZ(-100);
        mat[0].setDiffuseMap(img2);
        sph[0].setMaterial(mat[0]);
        sph[1].setTranslateX(150);
        sph[1].setTranslateY((HEIGHT / 2) - 80);
        sph[1].setTranslateZ(-100);
        mat[1].setDiffuseMap(img2);
        sph[1].setMaterial(mat[1]);
        sph[2].setTranslateX(128);
        sph[2].setTranslateY((HEIGHT / 2) - 48);
        sph[2].setTranslateZ(-100);
        mat[2].setDiffuseMap(img2);
        sph[2].setMaterial(mat[2]);
        sph[3].setTranslateX(180);
        sph[3].setTranslateY((HEIGHT / 2) - 1);
        sph[3].setTranslateZ(-100);
        mat[3].setDiffuseMap(img2);
        sph[3].setMaterial(mat[3]);
        sph[4].setTranslateX(175);
        sph[4].setTranslateY((HEIGHT / 2) - 40);
        sph[4].setTranslateZ(-100);
        mat[4].setDiffuseMap(img2);
        sph[4].setMaterial(mat[4]);
        sph[5].setTranslateX(145);
        sph[5].setTranslateY((HEIGHT / 2) - 20);
        sph[5].setTranslateZ(-100);
        mat[5].setDiffuseMap(img2);
        sph[5].setMaterial(mat[4]);
        return sph;
    }

    public Text[] T() {
        Text t = new Text();
        t.setX(35.0);
        t.setY(35.0);
        t.setCache(true);
        t.setText("Mouse Event:\n");
        t.setFont(Font.font(null, FontWeight.NORMAL, 15));
        t.setFill(Color.DARKBLUE);
        Text t1 = new Text();
        t1.setX(38);
        t1.setY(55);
        t1.setCache(true);
        t1.setText("Mouse Button Primary (light on)\n"
                + "Mouse Button Secondary (light off)");
        t1.setFont(Font.font(null, FontWeight.NORMAL, 10));
        t1.setFill(Color.LIGHTCORAL);

        Text t2 = new Text();
        t2.setX(35.0);
        t2.setY(99.0);
        t2.setCache(true);
        t2.setText("Key Event:\n");
        t2.setFont(Font.font(null, FontWeight.NORMAL, 15));
        t2.setFill(Color.DARKBLUE);

        Text t3 = new Text();
        t3.setX(38);
        t3.setY(120);
        t3.setText("Up,Down arrow -> event on apple \n"
                + "Right,left arrow -> event on grass\n"
                + "W,Y,G,B -> lighting color\nR -> reset to initial state");
        t3.setFont(Font.font(null, FontWeight.NORMAL, 10));
        t3.setFill(Color.LIGHTCORAL);

        Text[] T = {t, t1, t2, t3};
        return T;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

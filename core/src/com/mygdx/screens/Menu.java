package com.mygdx.screens;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.asteroids.AsteroidsGame;
import com.mygdx.screens.MainGameScreen;

public class Menu extends Game implements Screen {
    AsteroidsGame menu;
    Texture playbutton;
    Texture exitbutton; 
    Texture rankingbutton;

    
    int WINDOWS_WIDTH  = Gdx.graphics.getWidth() ;
    int WINDOWS_HEIGHT = Gdx.graphics.getHeight();
    
    //Construtor da classe
    public Menu(AsteroidsGame menu){
        this.menu = menu;
        //Texturas dos botões
        playbutton = new Texture("imgs/playbutton.png");
        exitbutton = new Texture("imgs/exitbutton.png");
        rankingbutton = new Texture("imgs/history.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        super.render();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        menu.batch.begin();

        //Posiciona os botoes na tela
        menu.batch.draw(playbutton,(WINDOWS_WIDTH)/2-playbutton.getWidth()/2,WINDOWS_HEIGHT/2);
        menu.batch.draw(exitbutton,(WINDOWS_WIDTH)/2-playbutton.getWidth()/2,WINDOWS_HEIGHT/4);
        menu.batch.draw(rankingbutton, (WINDOWS_WIDTH)/2 - rankingbutton.getWidth()/2, WINDOWS_HEIGHT/10);
        if(Gdx.input.isKeyPressed(Keys.ENTER)){
            menu.setScreen(new MainGameScreen(menu, 2,0));
        }
        //Verifica se o mouse está sobre o botao de play
        if((Gdx.input.getX()>(WINDOWS_WIDTH/2-playbutton.getWidth()/2)&&(Gdx.input.getX()<WINDOWS_WIDTH/2+playbutton.getWidth()/2)&&(Gdx.input.getY()<WINDOWS_HEIGHT/2)&&(Gdx.input.getY()>WINDOWS_HEIGHT/2-playbutton.getHeight()))){
            //Verifica se o botão esquerdo do mouse foi pressionado
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                //Começa o jogo
                menu.setScreen(new MainGameScreen(menu,2,0));
            }
        }

        //Verifica se o mouse está sobre o botao de sair
        if((Gdx.input.getX()>WINDOWS_WIDTH/2-playbutton.getWidth()/2)&&(Gdx.input.getX()<WINDOWS_WIDTH/2+exitbutton.getWidth()/2)&&(Gdx.input.getY()<WINDOWS_HEIGHT-WINDOWS_HEIGHT/4)&&(Gdx.input.getY()>-WINDOWS_HEIGHT/4-exitbutton.getHeight()+WINDOWS_HEIGHT)){
            //Verifica se o botão esquerdo do mouse foi pressionado
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                //Fecha o jogo
                Gdx.app.exit();
            }
        }

        if ((Gdx.input.getX() > (WINDOWS_WIDTH)/2-playbutton.getWidth()/2)&&(Gdx.input.getX() < (WINDOWS_WIDTH)/2+playbutton.getWidth()/2)&&(Gdx.input.getY() > (WINDOWS_HEIGHT  -  WINDOWS_HEIGHT/10 - rankingbutton.getHeight())&& (Gdx.input.getY() < ((WINDOWS_HEIGHT - WINDOWS_HEIGHT/10))))){
            
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                try{
                    menu.setScreen(new History(menu, new File("save_files/ranking.txt")));
                }
                catch (IOException e){
                    JOptionPane.showMessageDialog(null, "ERRO! Arquivo com o save não foi encontrado");
                }
            }
        }
        
        menu.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void create() {

    }

    
    
}